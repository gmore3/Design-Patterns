package studentCoursesBackup.myTree;

import java.util.ArrayList;
import java.util.List;

import studentCoursesBackup.Extra.SelectOperation;
import studentCoursesBackup.util.MyLogger;
import studentCoursesBackup.util.MyLogger.DebugLevel;

public class Node implements SubjectI,ObserverI{

		public int bNumber;
		public String course;
  	public List<String> coursesList = new ArrayList<>();
		public Node left, right;
  	public List<Node> backupList;
  	private Node backup_Node_1;
		private Node backup_Node_2;
		private String insert = "insert";
		private String delete = "delete";

  	public Node(){
  		MyLogger.writeMessage("Default Constructor for Node class",DebugLevel.CONSTRUCTOR);
    }

		public Node(Node node)
		{
			MyLogger.writeMessage("Default Constructor for Node class",DebugLevel.CONSTRUCTOR);
			this.bNumber = node.getbNumber();
			this.left = node.getLeft();
			this.right = node.getRight();
			this.course = node.getCourse();
			this.coursesList.add(this.course);
		}


    public Node(int bNumber,String course)
    {
			MyLogger.writeMessage("Default Constructor for Node class",DebugLevel.CONSTRUCTOR);
      this.left = null;
      this.right = null;
      this.bNumber = bNumber;
      this.course = course;
      this.coursesList.add(course);
      backupList = new ArrayList<>();
    }

		/**
		 * @return course
		 */
  	public String getCourse(){
			return course;
		}

		/**
		 * @param course
		 * set course
		 */
	  public void setCourse(String course){
			this.course = course;
		}

		/**
		 * @return coursesList
		 */
    public List<String> getCoursesList(){
			return coursesList;
		}

		/**
		 * @param coursesList
		 * set coursesList
		 */
	  public void setCoursesList(List<String> coursesList){
			this.coursesList = coursesList;
		}

		/**
		 * @return left
		 */
    public Node getLeft(){
			return left;
		}

		/**
		 * @param left
		 * set left
		 */
	  public void setLeft(Node left){
			this.left = left;
		}

		/**
		 * @return right
		 */
		public Node getRight(){
			return right;
		}

		/**
		 * @param right
		 * set right
		 */
		public void setRight(Node right){
					this.right = right;
		}

		/**
		 * @param bNumber
		 * set bNumber
		 */
		public void setbNumber(int bNumber){
        	this.bNumber = bNumber;
    }

		/**
		 * @return bNumber
		 */
    public int getbNumber(){
        return bNumber;
    }

		/**
		 * @return backupList
		 */
    public List<Node> getbackupList(){
        return backupList;
    }

		/**
		 * @return backup_Node_1
		 */
		public Node getBackup_Node_1(){
			return backup_Node_1;
		}

		/**
		 * @param setBackup_Node_1
		 * set setBackup_Node_1
		 */
		public void setBackup_Node_1(Node backup_Node_1){
			this.backup_Node_1 = backup_Node_1;
		}

		/**
		 * @return backup_Node_2
		 */
		public Node getBackup_Node_2() {
			return backup_Node_2;
		}

		/**
		 * @param setBackup_Node_2
		 * set setBackup_Node_2
		 */
		public void setBackup_Node_2(Node backup_Node_2){
			this.backup_Node_2 = backup_Node_2;
		}

		/**
		 * @param bNumber and course
		 * Clones the Node_orig into backup_Node_1 and backup_Node_2
		 * @return the previousNode
		 */
		public Node clone(){
	 		  Node previousNode = new Node(this.bNumber,this.course);
        return previousNode;
    }

		/**
		 * @param observer form the driver class i.e the bNumber getting inserted is registered
		 * adds the observer to the backupList of the observers
		 * @return nothing
		 */
    @Override
    public void registerObserver(Node observer){
      	//System.out.println("Inside register pattern");
        backupList.add(observer);
        //System.out.println();
        //System.out.println("For Node in register observer " + observer.bNumber);
    }

		/**
		 * @param the
		 * for all the observers in the backupList,notification of the updation is passed
		 * @return nothing
		 */
    @Override
    public void notifyAll(SelectOperation s){
    	//System.out.println("For Node Inside Notify " + student.getBnumber());
   		//System.out.println("\n\nBackuplist Node: "+backupList.get(0).getbNumber()+"::"+backupList.get(1).getbNumber());
      for (Node node : backupList){
//        	System.out.println("**************The backup list value is " + node.bNumber + "******************");
        	node.update(s);
			 }
    }

		/**
		 * @param the
		 * depending on the whether its insert or delete, the appropriate operation is performed
		 * @return nothing
		 */
    @Override
    public void update(SelectOperation s){
    	String Course = s.getCourse();

			if (s.getOperation().equalsIgnoreCase(insert) && !coursesList.contains(Course)) {
				this.coursesList.add(Course);
			//System.out.println("Updation: "+bNumber+":: Courses: "+coursesList);
			}

			if (s.getOperation().equalsIgnoreCase(delete) && coursesList.contains(Course)) {
				this.coursesList.remove(Course);
			}
	}
}
