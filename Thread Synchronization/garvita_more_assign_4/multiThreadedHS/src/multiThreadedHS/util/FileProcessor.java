package multiThreadedHS.util;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import multiThreadedHS.util.MyLogger;
import multiThreadedHS.util.MyLogger.DebugLevel;

public class FileProcessor {

	private String line;
	private Scanner scanner;
	List<String> allLines;

	/**
	 * @param input which is the name of the input file coming from command line
	 * opens up the file for reading
	 * @return nothing
	 */
	public void openinit(String input) {
		try {
			scanner = new Scanner(
					new File(input));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

  /**
	 * @param the filename
	 * reads from the file and stores it in a list
	 * the list is passed to a convert() function to convert from String to integer array
	 * @return arr
	 */
	public int[] store(String filename) throws IOException {
			allLines = Files.readAllLines(Paths.get(filename));
			int arr[] = convert(allLines);
			return arr;
	}

	/**
	 * @param the list
	 * Citation : https://www.techiedelight.com/convert-list-to-array-java/
	 * converts the String list into an integer array
	 * @return newarr
	 */
	public static int[] convert(List<String> list) {
		int newarr[] = new int[list.size()];
		Object arr[] = list.toArray();
		for(int i=0;i<list.size();i++) {
			newarr[i] = Integer.parseInt((String) arr[i]);
		}
		return newarr;
	}

	/**
	 * @param nothing reads one line at a time from the input file terminates when
	 * no line in the file giving the message
	 * @return returns the line read from the files
	 */
	public String readLine() {
		if (!scanner.hasNext()) {
      return null;
		}
		line = scanner.nextLine();
		return line;
	}
}
