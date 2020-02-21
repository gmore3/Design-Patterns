package studentCoursesBackup.driver;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.File;
import java.util.Scanner;
import java.lang.NullPointerException;
import java.nio.file.NoSuchFileException;
import studentCoursesBackup.util.FileProcessor;
import studentCoursesBackup.myTree.Node;
import studentCoursesBackup.util.TreeBuilder;
import studentCoursesBackup.Extra.SelectOperation;
import studentCoursesBackup.util.Results;
import studentCoursesBackup.util.FileDisplayInterface;
import studentCoursesBackup.util.StdoutDisplayInterface;
import studentCoursesBackup.util.MyLogger;
import studentCoursesBackup.util.MyLogger.DebugLevel;

/**
 * @author Garvita More
 */

  public class Driver {

  /**
   * @param args Unused
   * @return nothing
   * @exception IOException when IO operation fails. This is the main method.
   *            Calls the fileprocessor by using its objest to read both
   *            input and delete files
   */
	public static void main(String[] args) throws IOException{

	    /*
	     * As the build.xml specifies the arguments as argX, in case the
	     * argument value is not given java takes the default value specified in
	     * build.xml. To avoid that, below condition is used
	     */
	    // FIXME: update this if statement for this assignment
	    if ((args.length != 6) || args[0].equals("${arg0}") || args[1].equals("${arg1}") || args[2].equals("${arg2}")|| args[3].equals("${arg3}")|| args[4].equals("${arg4}") || args[5].equals("${arg5}")) {

		    System.err.println("Error: Incorrect number of arguments. Program accepts 6 argumnets.");
		    System.exit(0);
	    } // end of if

	    System.out.println("Hello World! Lets get started with the assignment");

      TreeBuilder treebuilder = new TreeBuilder();

  		Results re = new Results();
  	  Results re1 = new Results();
  	  Results re2 = new Results();

      int debugValue = Integer.parseInt(args[5]);
      MyLogger.setDebugValue(debugValue);

  		int bNumber = 0;
  		Node Node_orig;

  		FileProcessor fileprocessor1 = new FileProcessor(); // input.txt
      MyLogger.writeMessage("File Open",DebugLevel.FILE);
  		FileProcessor fileprocessor2 = new FileProcessor(); // delete.txt
      MyLogger.writeMessage("File Open",DebugLevel.FILE);

  		fileprocessor1.openinit(args[0]);
  		fileprocessor2.openinit(args[1]);

  		String line;
  		while((line = fileprocessor1.readLine()) != null) {
  			try {
  				String[] arr = line.split(":");
  				bNumber = Integer.parseInt(arr[0]);
  				String course = arr[1];
  				Node_orig = treebuilder.searchNode(bNumber);

  				if(Node_orig == null) {
  					Node_orig = new Node(bNumber, course);
  					//System.out.println("Node Original :" +Node_orig.getbNumber() + "----" + Node_orig.getCourse());
  					Node_orig.setBackup_Node_1((Node)Node_orig.clone());
  					//System.out.println("Clones back up node 1 in driver :"+ Node_orig.getBackup_Node_1().getbNumber()+ "----"+ Node_orig.getBackup_Node_1().getCourse());
  					Node_orig.setBackup_Node_2((Node)Node_orig.clone());
  					//System.out.println("Clones back up node 2 in driver :"+ Node_orig.getBackup_Node_2().getbNumber()+ "----"+ Node_orig.getBackup_Node_2().getCourse());
  					Node_orig.registerObserver(Node_orig.getBackup_Node_1());
  					Node_orig.registerObserver(Node_orig.getBackup_Node_2());
            MyLogger.writeMessage("Tree Insertion",DebugLevel.TREE);
  					//System.out.println("Hello::: "+Node_orig.backupList);
  					treebuilder.insert(Node_orig);

  				}
  				else {
  					SelectOperation oper = new SelectOperation(bNumber, course, "insert");
  //					System.out.println("Hello::: "+Node_orig.backupList);
  					Node_orig.update(oper);
  //					System.out.println("Node_orig after updation:"+Node_orig.getbNumber() + "----" +Node_orig.getCoursesList());
  					Node_orig.notifyAll(oper);
  				}
  //				System.out.println("\n\nBackuplist main: "+Node_orig.getBackup_Node_1().getbNumber()+"::"+Node_orig.getBackup_Node_2().getbNumber());
  			}
  			catch(Exception e) {
  				System.out.println("Error while cloning the original node");
  				e.printStackTrace();
  			}
  		}

  		String line2;
  		while((line2 = fileprocessor2.readLine()) != null) {
  			try {
  				String[] arr = line2.split(":");
  				bNumber = Integer.parseInt(arr[0]);
  				String course = arr[1];
  				Node_orig = treebuilder.searchNode(bNumber);
  				SelectOperation oper = new SelectOperation(bNumber, course, "delete");
  				Node_orig.update(oper);
  				//System.out.println("Node_orig after deletion:"+Node_orig.getbNumber() + "----" +Node_orig.getCoursesList());
  				Node_orig.notifyAll(oper);
  			} catch(Exception e) {
  				System.err.println(e);
  			}
  		}

      System.out.println("Printing the tree in inorder format:");
      treebuilder.printNodes(re,re1,re2);
      re.writeToFile(args[2]);
      re1.writeToFile(args[3]);
      re2.writeToFile(args[4]);
}  // end public static void main
}  // end public class Driver
