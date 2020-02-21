package multiThreadedHS.driver;

import java.io.IOException;
import multiThreadedHS.util.FileProcessor;
import multiThreadedHS.threads.ThreadWorker;
import java.util.List;
import java.util.ArrayList;
import multiThreadedHS.util.Results;
import multiThreadedHS.util.MyLogger;
import multiThreadedHS.util.MyLogger.DebugLevel;

/**
 * @author Garvita More
 *
 */
public class Driver {
//	public static void main(String[] args) throws IOException{
public static void main(String[] args) {

		/*
		 * As the build.xml specifies the arguments as argX, in case the
		 * argument value is not given java takes the default value specified in
		 * build.xml. To avoid that, below condition is used
		 */

		 try{
		 int inputs = Integer.parseInt(args[0]);
		 //System.out.println(inputs);
		 if(inputs == 1){
		 if ((args.length != 4) || args[0].equals("${arg0}") || args[1].equals("${arg1}") || args[2].equals("${arg2}")
		 		|| args[3].equals("${arg3}")) // || args[4].equals("${arg4}"))
			{
		 	System.err.println("Error: Incorrect number of arguments. Program accepts 4 argumnets.");
		 	System.exit(0);
		 }
	 }
		 else if(inputs ==2){
			 if ((args.length != 5) || args[0].equals("${arg0}") || args[1].equals("${arg1}") || args[2].equals("${arg2}")
					|| args[3].equals("${arg3}") || args[4].equals("${arg4}"))
				{
				System.err.println("Error: Incorrect number of arguments. Program accepts 5 argumnets.");
				System.exit(0);
			 }
		 }
		 else if(inputs ==3){
			 if ((args.length != 6) || args[0].equals("${arg0}") || args[1].equals("${arg1}") || args[2].equals("${arg2}")
					|| args[3].equals("${arg3}") || args[4].equals("${arg4}") || args[5].equals("${arg5}"))
				{
				System.err.println("Error: Incorrect number of arguments. Program accepts 6 argumnets.");
				System.exit(0);
			 }
		 }

		System.out.println("Hello World! Lets get started with the assignment");

		int debugValue = Integer.parseInt(args[inputs+2]);
		MyLogger.setDebugValue(debugValue);

		MyLogger.writeMessage("File Processor Objects Created",DebugLevel.OBH);

		FileProcessor fileprocessor = new FileProcessor();

		MyLogger.writeMessage("Results Objects Created",DebugLevel.OBH);
		Results results = new Results();
		MyLogger.writeMessage("File Open",DebugLevel.FILE);

		//int inputs = Integer.parseInt(args[0]);
		//System.out.println(inputs);
		if(inputs<1 || inputs>3)
			System.out.println("Invalid Input");
		else{
			for(int i=1;i<=inputs;i++){
				//System.out.println("Running the thread: " + i);
				Thread threadworker = new ThreadWorker(args[i], args[inputs+1]);
				threadworker.start();
				MyLogger.writeMessage("Ran Thread " +i+ " ",DebugLevel.THREADS);
				try {
					threadworker.join();
				}
				catch(Exception e) {
					System.out.println("Threads didnt join error");
				}
			 }
			results.convert_and_write(args[inputs+1]);
		}
	}
	catch(Exception e){

		System.out.println("Invalid args entered.");
	}
	}
}
