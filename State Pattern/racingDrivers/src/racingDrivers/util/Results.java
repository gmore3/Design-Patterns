package racingDrivers.util;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.io.File;

public class Results implements FileDisplayInterface, StdoutDisplayInterface {

	private List<String> listResult = new ArrayList<String>();
	String result = "";

	public void writeToFile(String fileName) {
		try {
                         //System.out.println("Hey");
			BufferedWriter wr = new BufferedWriter(new FileWriter(fileName));
			for (String str : listResult) {
				wr.write(str);
			}
			wr.close();
		} catch (Exception e) {
			System.out.println("Exception while writing to the file");
			System.exit(1);
		}
		System.out.println("Done");

	}
	// }

	public void writeToStdout(String s) {
		System.out.print(s);
	}

	public List<String> getListResult() {
		return listResult;
	}

	public void setListResult(List<String> listResult) {
		this.listResult = listResult;
	}

	public void storeNewResult(String result) {
		if (!result.equals("newline")) {
			listResult.add(result + "\t");
			writeToStdout(result + "\t");
		} else {
			listResult.add("\n");
			writeToStdout("\n");
		}
	}

}
