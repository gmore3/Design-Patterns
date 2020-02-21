package multiThreadedHS.threads;

import multiThreadedHS.util.FileProcessor;
import java.util.List;
import java.util.ArrayList;
import multiThreadedHS.util.HeapSort;
import multiThreadedHS.util.Results;
import multiThreadedHS.util.MyLogger;
import multiThreadedHS.util.MyLogger.DebugLevel;

public class ThreadWorker extends Thread{

  public String filename;
  public String output_filename;
  HeapSort heapsort = new HeapSort();

  /**
   * Constructor for ThreadWorker
   */
  public ThreadWorker(String filename, String output_filename) {
      MyLogger.writeMessage("Constructor for ThreadWorker Class",DebugLevel.CONSTRUCTOR);
      this.filename = filename;
      this.output_filename = output_filename;
  }

  FileProcessor fileprocessor = new FileProcessor();
  Results results = new Results();

  /**
   * @param nothing
   * runs the threads
   * calls the store() of Results which inturn calls the store() of the FileProcessor Class
   * calls the HeapSort() for sorting and returns a sorted array
   * the same array is sent to Results that stores them into a list
   * @return nothing
   */
  @Override
	public void run() {
      try {
        fileprocessor.openinit(filename);
        MyLogger.writeMessage("File Opened",DebugLevel.FILE);
        int[] arr = results.store(filename);
        int sorted_arr[] = heapsort.mergeSort(arr);
        results.addValues(sorted_arr);
        MyLogger.writeMessage("File Closed",DebugLevel.FILE);
        }
      catch(Exception e) {
      }
	}
}
