package multiThreadedHS.util;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.io.File;
import java.io.FileWriter;
import multiThreadedHS.util.FileProcessor;
import multiThreadedHS.util.MyLogger;
import multiThreadedHS.util.MyLogger.DebugLevel;

public class Results implements FileDisplayInterface, StdoutDisplayInterface {

	/**
	 * Default Constructor for Results
	 */
	public Results() {}

	public List<Integer> getAllValues () {
		return allValues;
	}

	public static List<Integer> allValues = new ArrayList<Integer>();
	public static int counter = 0;

	FileProcessor fileprocessor = new FileProcessor();
	HeapSort heapsort = new HeapSort();

	/**
	 * @param filename i.e the name of the input file
	 * the input file is scanned, converted to int and stored into an array
	 * the lines read from the particular file is converted from String into an int array
	 * the converted int array returned from store() function is stored into
	 * a new array named "arr"
	 * @return arr
	 */
	public int[] store(String filename) throws IOException {
		int[] arr = fileprocessor.store(filename);
		return arr;
	}

	/**
	 * @param arr the converted array received from Heapsort
	 * appends the values of the array into a list
	 * @return nothing
	 */
	public void addValues(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			allValues.add(arr[i]);
		}
	}

	/**
	 * @param output_filename the name of the output file where the finale result is stored
	 * performs a conversion from List to Object array and then to Integer array
	 * writes to output file
	 * @return nothing
	 */
	public void convert_and_write(String output_filename) {
		int newarr[] = new int[allValues.size()];
		Object arr[] = allValues.toArray();
		for(int i=0;i<allValues.size();i++) {
			newarr[i] = (Integer) arr[i];
		}
		int[] sorted_arr = heapsort.mergeSort(newarr);
		writeToFile(output_filename, sorted_arr);
	}

  /**
	 * @param filename,int array to be to be written in the output file
	 * writes to the output file
	 * @return nothing
	 */
	public void writeToFile(String fileName, int[] arr) {
		try {
			counter++;
			File file = new File(fileName);
			if(file.exists() && counter == 1){
				 file.delete();
				 file.createNewFile();
    	}
			FileWriter fw = new FileWriter(file,true);
			BufferedWriter wr = new BufferedWriter(fw);
			//System.out.println("Final Length of array is " + arr.length);
			for (int i=0;i<arr.length;i++) {
				//System.out.println(arr[i]);
				wr.write(Integer.toString(arr[i]) + "\n");
			}
			wr.close();
		}
		catch (Exception e) {
			System.out.println("Exception while writing to the file");
			System.exit(1);
		}
	}

  /**
	 * @param String s
	 * prints on the command line
	 * @return nothing
   */
	public void writeToStdout(String s) {
		System.out.print(s);
	}
}
