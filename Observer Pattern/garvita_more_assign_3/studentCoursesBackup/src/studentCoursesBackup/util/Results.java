package studentCoursesBackup.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class Results implements FileDisplayInterface, StdoutDisplayInterface {

	private List<String> listResult = new ArrayList<String>();
	String result = "";

  /**
	 * @param takes the name of the file in which the result is to be written
	 * writes to the file
	 * @return nothing
	 */
	public void writeToFile(String fileName){
		try {
			BufferedWriter wr = new BufferedWriter(new FileWriter(fileName));
			for (String str : listResult) {
				wr.write(str);
				wr.write("\r\n");
			}
			wr.close();
		} catch (Exception e) {
			System.out.println("Exception while writing to the file");
			System.exit(1);
		}
		//System.out.println("Done");
	}

  /**
	 * @param takes the String
	 * writes to the command line
	 * @return nothing
	 */
	public void writeToStdout(String s){
		System.out.print(s);
	}

  /**
	 * @return listResult
   */
	public List<String> getListResult(){
		return listResult;
	}

	/**
	 * @param listResult
	 * sets listResult
   */
	public void setListResult(List<String> listResult){
		this.listResult = listResult;
	}

	/**
	 * @param takes the string result
	 * stores the result in listResult
	 * @return nothing
   */
	public void storeNewResult(String result){
		listResult.add(result);
	  listResult.add("\n");
		writeToStdout(result);
		writeToStdout("\n");

	}
}
