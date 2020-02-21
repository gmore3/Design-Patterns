# csx42_summer_19_assign_3
# CSX42: Assignment 3
## Name    : Garvita More
## BNumber : B00755031
## Bmail   : gmore3@binghamton.edu
-----------------------------------------------------------------------
-----------------------------------------------------------------------

Following are the commands and the instructions to run ANT on your project.
#### Note: build.xml is present in studentCoursesBackup/src folder.

-----------------------------------------------------------------------
## Instruction to clean:

####Command: ant -buildfile studentCoursesBackup/src/build.xml clean

Description: It cleans up all the .class files that were generated when you
compiled your code.

-----------------------------------------------------------------------
## Instruction to compile:

####Command: ant -buildfile studentCoursesBackup//src/build.xml all

Description: Compiles your code and generates .class files inside the BUILD folder.

-----------------------------------------------------------------------
## Instruction to run:

####Command: ant -buildfile studentCoursesBackup/src/build.xml run -Darg0=input.txt -Darg1=delete.txt -Darg2=output1.txt -Darg3=output2.txt -Darg4=output3.txt -Darg5=3

Note: Arguments accept the absolute path of the files.
-----------------------------------------------------------------------
## Description:

Tree : Binary Search Tree used for building trees.

Advantages of BST :

They provide an efficient insertion and searching.
They are very flexible with data, allowing to move subtrees around with minimum effort.
When inserting or searching for an element in a binary search tree, the key of each visited node has to be compared with the key of the element to be inserted or found.

Complexity :

Search : O(n)
Insertion and deletion : O(n)

Citations :

Reference for Observer pattern : https://www.tutorialspoint.com/design_pattern/observer_pattern.htm
Binary search tree inorder print function : https://www.geeksforgeeks.org/tree-traversals-inorder-preorder-and-postorder/
Binary search tree Search function and Insert Function : https://www.geeksforgeeks.org/binary-search-tree-set-1-search-and-insertion/
List used for maintaining courses list : https://www.geeksforgeeks.org/list-interface-java-examples/

Implementation of Observer Pattern :

Firstly, the node to be inserted i.e the bNumber and course read from the input file is checked whether its present in the tree or not.
Depending on the searchNode() function returned value, the node is inserted.
After this the Node_orig is created, then the node is cloned to make backup_Node_1 and backup_Node_2 to make the respective backup nodes trees.
Then the two backup nodes are registered as the observers of the original node.
Then, the Node_orig node is inserted in the tree, same with the two backup nodes.
Whenever an update or delete occurs on Node_orig, the notifyAll() function is called, which in turn calls the update on the two backup nodes.
This keeps all the three trees in sync with each other thereby implementing the Observer Pattern.
The printNodes() function is used for printing in inorder format.

-----------------------------------------------------------------------
### Academic Honesty statement:
-----------------------------------------------------------------------

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating an official form will be
submitted to the Academic Honesty Committee of the Watson School to
determine the action that needs to be taken. "

Date: -- July 11th,2019
