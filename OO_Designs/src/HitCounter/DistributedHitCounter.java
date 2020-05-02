package HitCounter;

import java.util.HashSet;
import java.util.List;

public class DistributedHitCounter {

	HashSet<HitCounterSingleMachine> listOfMachines;

	void registerMachine(HitCounterSingleMachine machine) {
		listOfMachines.add(machine);
	}

	void deRegisterMachine(HitCounterSingleMachine machine) {
		listOfMachines.remove(machine);
	}

	long getHitsOfAllMachines(int timeStamp) {
		long result = 0L;

		for (HitCounterSingleMachine machine : listOfMachines) {
			result += machine.getHits(timeStamp);
		}

		return result;
	}

}
