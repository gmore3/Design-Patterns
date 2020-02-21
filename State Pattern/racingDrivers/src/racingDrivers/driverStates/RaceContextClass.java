package racingDrivers.util;

import java.io.FileNotFoundException;
import racingDrivers.util.FileProcessor;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import racingDrivers.util.Results;

public class RaceContextClass {

	Map<Integer, Double> map = new HashMap<Integer, Double>();
	private int count = 0;
	private String str;
	List<Double> var = new ArrayList<Double>();

	DriverContextClass dcc = new DriverContextClass();

	/**
	 * @param takes the object of the file processor class takes one line from file
	 *              processor read from the file converts the string read from the
	 *              file into integer for the first line i.e no of drivers converts
	 *              the second line read, splits it with space and stores in an
	 *              array then puts the array into an hash map passes this map to
	 *              position() in DriverContextCLass using the object of the same
	 * @return nothing
	 */
	public void putArray(FileProcessor fileprocessor, Results results) throws FileNotFoundException {
		str = fileprocessor.readLine();
		String str2;
//		System.out.println("The number of drivers : "+str);

		while ((str2 = fileprocessor.readLine()) != null) {
//				 System.out.println(str2);

			int noOfDrivers = Integer.parseInt(str);
			String[] line1 = str2.split(" ");
			for (int i = 0; i < noOfDrivers; i++) {
				map.put(i + 1, map.getOrDefault(i + 1, 0.0) + Double.parseDouble(line1[i]));

			}
			dcc.position(map, results);
			results.getListResult().add("\n");
			results.storeNewResult("newline");

		}
	}
}
