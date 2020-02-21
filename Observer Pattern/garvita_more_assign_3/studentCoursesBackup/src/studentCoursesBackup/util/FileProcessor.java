package studentCoursesBackup.util;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class FileProcessor {

	public String line;
	private Scanner scanner;

	/**
	 * @param input which is the name of the input file coming from command line
	 *              opens up the file for reading
	 * @return nothing
	 */
	public void openinit(String input) {

		try {
			scanner = new Scanner(
					new File(input));
            //br = new BufferedReader(file);
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * @param nothing reads one line at a time from the input file terminates when
	 *                no line in the file giving the message
	 * @return returns the line read from the files
	 * @throws IOException
	 */
	public String readLine() throws IOException {

		if (!scanner.hasNext()) {
			 return null;
		}
		else {
			line = scanner.nextLine();
			return line;
		}
	}
}
