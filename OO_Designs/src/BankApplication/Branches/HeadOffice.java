package BankApplication.Branches;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

public class HeadOffice {

	private Logger logger = Logger.getLogger(HeadOffice.class.getName());

	private List<Branch> branches;

	AtomicLong lastCreatedBranch;

	public HeadOffice() {
		lastCreatedBranch = new AtomicLong(0L);
	}

	public synchronized void createBranch() {
		Branch newBranch = new Branch();
		long newBranchId = lastCreatedBranch.incrementAndGet();
		newBranch.setBranchId(newBranchId + "");
		branches.add(newBranch);
	}

	public Branch getBranchById(String branchId) throws BranchException {

		Optional<Branch> foundBranch = branches.parallelStream().filter(e -> e.getBranchId().equalsIgnoreCase(branchId))
				.findAny();

		// If Branch was not found throw exception
		String errorMsg = "Branch with provided branchId: " + branchId + " was not found in records";
		foundBranch.orElseThrow(() -> new BranchException(logger, errorMsg));

		// Otherwise return value
		return foundBranch.get();
	}

	public List<Branch> getAllBranches() {
		return branches;
	}
}
