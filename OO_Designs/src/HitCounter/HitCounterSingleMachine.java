package HitCounter;

public class HitCounterSingleMachine {

	int[] hits;
	int[] timeStamps;
	int timeRangeInSeconds;

	public HitCounterSingleMachine(int timeRangeInSeconds) {
		// Boundary conditions for time Range

		hits = new int[timeRangeInSeconds];
		timeStamps = new int[timeRangeInSeconds];
		this.timeRangeInSeconds = timeRangeInSeconds;
	}

	/*
	 * Let's say timeRange is 300 seconds Then we can track timeStamp as 37Seconds
	 * since start -> 337 seconds since start -> 667 seconds since start All of the
	 * above values will map to same id -> 37 Our timeStamp[id] will keep track of
	 * which timeStamp we are keeping track of right now
	 * 
	 * S1) If say we are tracking t -37 seconds, suddenly we recieve a request of t
	 * 337 seconds then we start tracking that timeStamp, by increasing the hits
	 * 
	 * 
	 * Note: -> This approach requires the hit reporting systems, to work linearly
	 * means to report 37 seconds hits only when (0-300) Since system startup and
	 * not during (300-600) or further intervals, Since it basically defeats the
	 * purpose
	 * 
	 * -> I have made another impl which only records newer timestamps than current
	 * ones
	 * 
	 */
	void hit(int timeStamp) {
		int id = timeStamp % timeRangeInSeconds;
		if (timeStamps[id] != timeStamp) {
			timeStamps[id] = timeStamp;
			hits[id] = 1;
		} else {
			hits[id] += 1;
		}
	}

	void hit2(int timeStamp) {
		int id = timeStamp % timeRangeInSeconds;
		if (timeStamps[id] < timeStamp) {
			timeStamps[id] = timeStamp;
			hits[id] = 1;
		} else {
			hits[id]++;
		}
	}
	
	
	/*
	  You provide a timeStamp like t0 -> 435 seconds, t->867 seconds since start of website
	  I look into my timeStamps array and if the timeStamps, stored there are in the range
	  Of what we are reliably offering then we return the result to you 
	
	 */

	int getHits(int timeStamp) {
		int result = 0;
		int id = timeStamp % timeStamps.length;

		for (int i = 0; i < timeStamps.length; i++) {
			if (timeStamp - timeStamps[i] < timeRangeInSeconds) {
				result += hits[id];
			}
		}

		return result;
	}
}
