package racingDrivers.driver;

import racingDrivers.util.FileProcessor;
import racingDrivers.util.RaceContextClass;
import racingDrivers.util.Results;
import racingDrivers.util.FileDisplayInterface;
import racingDrivers.util.StdoutDisplayInterface;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.File;
import java.util.Scanner;
import java.lang.NullPointerException;
import java.nio.file.NoSuchFileException;
import racingDrivers.util.MyLogger;
import racingDrivers.util.MyLogger.DebugLevel;
/**
 * @author Garvita More
 *
 */
public class Driver{
	public static void main(String[] args) throws FileNotFoundException {

		/*
		 * As the build.xml specifies the arguments as argX, in case the
		 * argument value is not given java takes the default value specified in
		 * build.xml. To avoid that, below condition is used
		 */
		 if (args.length != 3)  // || args[0].equals("${arg0}") || args[1].equals("${arg1}") || args[2].equals("${arg2}")
		// 		|| args[3].equals("${arg3}") || args[4].equals("${arg4}"))
		 {

			System.err.println("Error: Incorrect number of arguments. Program accepts 5 argumnets.");
			System.exit(0);
		}

		System.out.println("Hello World! Lets get started with the assignment");
			  
			  MyLogger.writeMessage("OBJECTS created here"  ,
                                     DebugLevel.OBH);
		      Results results = new Results();
			  MyLogger.setDebugValue(Integer.parseInt(args[2]));
			 
		      FileProcessor fileprocessor = new FileProcessor();
		      fileprocessor.openinit(args[0]);
		     
		      RaceContextClass racecontext = new RaceContextClass();
		      racecontext.putArray(fileprocessor,results);

		      results.writeToFile(args[1]);
			  MyLogger.writeMessage("FILE closed here",DebugLevel.FILE);

   }
}