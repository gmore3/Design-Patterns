package racingDrivers.util;

/*import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.List;*/
import java.util.Scanner;
import java.io.File;
import racingDrivers.util.MyLogger;
import racingDrivers.util.MyLogger.DebugLevel;

public class FileProcessor {

	private String line;
	private Scanner scanner;
	private int count = 0;

	/**
	 * @param input which is the name of the input file coming from command line
	 *              opens up the file for reading
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
	 * @param nothing reads one line at a time from the input file terminates when
	 *                no line in the file giving the message
	 * @return returns the line read from the files
	 */
	
	public String readLine() {

		if (!scanner.hasNext()) {
			//System.out.println("No line remaining from the file to be read");
                         return null;
			//System.exit(0);
			//scanner.close();
		}
		line = scanner.nextLine();
		return line;
	}
}