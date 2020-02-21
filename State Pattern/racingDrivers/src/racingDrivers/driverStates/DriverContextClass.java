package racingDrivers.util;

import racingDrivers.util.FileProcessor;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import racingDrivers.util.Results;
//import racingDrivers.util.MyLogger;
import racingDrivers.util.MyLogger.DebugLevel;

import racingDrivers.util.DriverContextInterface;


public class DriverContextClass implements DriverContextInterface {

	ContextClass cc = new ContextClass();
	// Results results = new Results();

	confident ls = new confident();
	calculative hs = new calculative();
	reckless los = new reckless();
	

	/**
	 * @param takes the hash map from the RaceContextClass and object of Results to
	 *              determine the position of the driver then rank the driver based
	 *              on the distance covered passes the rank stored in a list called
	 *              rank
	 * @return nothing
	 */
	public void position(Map<Integer, Double> position, Results results) {

		int noOfDrivers = position.size();

		/*
		 * for(int i : position.keySet()) { System.out.println("Position at "+i+ " 	: "
		 * +position.get(i)); }
		 */

		/**
		 * Citation : https://howtodoinjava.com/sort/java-sort-map-by-values/ took the
		 * help of the above link for sorting hash map in reverse order
		 */
		LinkedHashMap<Integer, Double> reversePosition = new LinkedHashMap<>();

		position.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
				.forEachOrdered(x -> reversePosition.put(x.getKey(), x.getValue()));

		/*
		 * for(int i : reversePosition.keySet()) {
		 * System.out.println("New Position at "+i+ " 	: " +reversePosition.get(i)); }
		 * 
		 * System.out.println("Deciding the Rank...");
		 */

		List<Integer> rank = new ArrayList<Integer>();

		for (int i = 0; i < noOfDrivers; i++) {
			rank.add(0);
		}
//        System.out.println(rank);
		int j = 1, flag = 0, k = 0;
		Set<Integer> keySort = reversePosition.keySet();
		List<Integer> keySortList = new ArrayList<Integer>();
		keySortList.addAll(keySort);

//        System.out.println(keySort);

		for (int i : reversePosition.keySet()) {
			// System.out.println("Keys--"+i);
//        	System.out.println(keySortList.get(k) +",,,,,,,,"+keySortList.get(k+1)+" : "+(k)+",,,,"+noOfDrivers);
//        	System.out.println(reversePosition.get(i)+" :: "+reversePosition.get(i+1));
//        	System.out.println(reversePosition.get(keySortList.get(k))+" :: "+reversePosition.get(keySortList.get(k+1)));
			if (((k + 1 < noOfDrivers)
					&& (reversePosition.get(keySortList.get(k)).equals(reversePosition.get(keySortList.get(k + 1)))))
					|| flag == 1) {
				// System.out.println("here");
				rank.set(i - 1, noOfDrivers);
				flag = 1;
			} else {
				rank.set(i - 1, j);
				j++;
			}
			k++;
			// System.out.println("Testing: "+(i-1)+"::"+ (j));
			// j++;
		}
		// System.out.println(rank);

		/*
		 * for(int i=1;i<=noOfDrivers;i++) { System.out.println("Driver " + i +
		 * " has a rank of " + rank.get(i-1)); }
		 */

		for (int i = 1; i <= rank.size(); i++) {

			if (rank.get(i - 1) < 0.3 * rank.size()) {
				ls.doAction(cc, results);
			} else if (rank.get(i - 1) < Math.round(0.7 * rank.size())
					&& rank.get(i - 1) >= Math.round(0.3 * rank.size())) {
				hs.doAction(cc, results);
			} else if (rank.get(i - 1) >= Math.round(0.7 * rank.size())) {
				los.doAction(cc, results);
			}

		}

	}
}