package studentCoursesBackup.util;

import java.util.ArrayList;
import java.util.List;

import studentCoursesBackup.myTree.Node;
import studentCoursesBackup.Extra.SelectOperation;
import studentCoursesBackup.util.Results;

public class TreeBuilder{

   Node backup_Node_1;
   Node backup_Node_2;
   Node root;

  public TreeBuilder(){
  	   backup_Node_1 = null;
  	   backup_Node_2 = null;
  	   root = null;
     }

 /**
  * @param takes the Bnumber as the input when read from the input file
  * Searches whether the incoming bNumber is already present or not
  * Citation : https://www.geeksforgeeks.org/binary-search-tree-set-1-search-and-insertion/
  * @return returns null if the Bnumber is not found
  */
  public Node searchNode(int key){
  	 Node temp = root;
  	 if(root != null)
  	 while (temp != null) {
  			if (temp.getbNumber() == key) {
  //				System.out.println("Found the node " +temp.getbNumber()+ " with courses " + temp.getCoursesList());
  			//	System.out.println("In search tree: "+temp.backupList);
  				return temp;
  			} else if (temp.getbNumber() > key) {
  				temp = temp.getLeft();
  			} else if (temp.getbNumber() < key) {
  				temp = temp.getRight();
  			}
  		}
  		return null;
     }

 /**
  * @param the new node to be inserted
  * Calls the recursive insert function
  * Citation : https://www.geeksforgeeks.org/binary-search-tree-set-1-search-and-insertion/
  * @return nothing
  */
  public void insert(Node newNode) {
  		try {
  			root = this.insertNodes(root, newNode);

  			//Node_orig = this.insertRec(Node_orig, newNode);
  			//List<Node> list = new ArrayList<>();
  			List<Node> list = newNode.getbackupList();
  			//System.out.println("\n\nBackuplist: "+list.get(0).getbNumber()+"::"+list.get(1).getbNumber());
  			backup_Node_1 = insertNodes(backup_Node_1, list.get(0));
  			//System.out.println("Backup node 1 :"+ backup_Node_1.getCoursesList());
  	    backup_Node_2 = insertNodes(backup_Node_2, list.get(1));
  	    //System.out.println("Backup node 1 :"+ backup_Node_2.getCoursesList());
  		}
  		catch (Exception e) {
  			e.printStackTrace();
  		}
  		//System.out.println("Root: "+root.bNumber);
  	}

  /**
   * @param root and the node to be inserted
   * called from insert function,performs insertion into the tree
   * @return root
   */
  private Node insertNodes(Node root, Node newNode) {

      //root= Node_orig;
  		int key = newNode.getbNumber();
  		if (root == null) {
  			try {
  				//root = new Node(newNode);
  				root = newNode;
  			} catch (Exception e) {
  				e.printStackTrace();
  			}
  			return root;
  		}
  		try {
  			if (key < root.getbNumber())
  				root.setLeft(this.insertNodes(root.getLeft(), newNode));
  			else if (key > root.getbNumber())
  				root.setRight(this.insertNodes(root.getRight(), newNode));
  		} catch (Exception e) {
  			e.printStackTrace();
  		}
  		return root;
  	}

    /**
     * @param the root and the new node to be inserted
     * Recursive function for insertion
     * Citation : https://www.geeksforgeeks.org/binary-search-tree-set-1-search-and-insertion/
     * @return root
     */
  	public void printNodes(Results r1,Results r2,Results r3) {
  	    System.out.println("\n\n\n");
  	    //System.out.println("Courses of the root " + root.getCoursesList());
  	    printInorder(root,r1);
  	    System.out.println("\n\n\n");
  	    //System.out.println("Courses of the backup_Node_1 " + backup_Node_1.getCoursesList());
  	    printInorder(backup_Node_1,r2);
  	    System.out.println("\n\n\n");
  	    //System.out.println("Courses of the backup_Node_2 " + backup_Node_2.getCoursesList());
  	    printInorder(backup_Node_2,r3);
  	  }

    public void printInorder(Node node, Results r)
  	  {
  	      if(node != null) {
  	        printInorder(node.getLeft(),r);
  	        //System.out.println(node.getbNumber() + " " + node.getCoursesList());
  	        //r.storeNewResult(String.valueOf(node.getbNumber()) + " " + node.getCoursesList());
  	        r.storeNewResult(String.valueOf(node.getbNumber()) + " " + node.getCoursesList());
  	        //r.storeNewResult(String.valueOf(node.getbNumber()) + " " + node.getCoursesList());
  	        //r.writeToFile(String.valueOf(node.getbNumber()) + " " + node.getCoursesList());
  	        printInorder(node.getRight(),r);
  	      }

  	  }

  }
