# csx42_summer_19_assign_4
# CSX42: Assignment 3
## Name    : Garvita More
## BNumber : B00755031
## Bmail   : gmore3@binghamton.edu
-----------------------------------------------------------------------
-----------------------------------------------------------------------

Following are the commands and the instructions to run ANT on your project.
#### Note: build.xml is present in multi/src folder.

-----------------------------------------------------------------------
## Instruction to clean:

####Command: ant -buildfile multiThreadedHS/src/build.xml clean

Description: It cleans up all the .class files that were generated when you
compiled your code.

-----------------------------------------------------------------------
## Instruction to compile:

####Command: ant -buildfile multiThreadedHS//src/build.xml all

Description: Compiles your code and generates .class files inside the BUILD folder.

-----------------------------------------------------------------------
## Instruction to run:

####Command:

ant -buildfile multiThreadedHS/src/build.xml run "1 input1.txt output.txt debugvalue "  (For N=1)

ant -buildfile multiThreadedHS/src/build.xml run "2 input1.txt input2.txt output.txt debugvalue "  (For N=2)

ant -buildfile multiThreadedHS/src/build.xml run "1 input1.txt input2.txt input3.txt output.txt debugvalue "  (For N=3)

debugvalue = 1,2,3,4  where 1=THREADS whether the threads ran, 2=OBH whether the respective objects get created, 3=FILE whether file is opened and/or closed, 4=CONSTRUCTOR whether the respective constructor is called.
Note: Arguments accept the absolute path of the files.
-----------------------------------------------------------------------
## Description:

a)Data Structures used :

1.Arrays : This data structure are used for intermediate storage. The individual threads are stored in individual arrays. On these arrays, the merge sort is called which sorts the arrays.

2.Array List : The shared data structure in Results which is shared by all the threads. The individual sorted arrays is added to the list on which the method merge sort is called which sorts the list which is combination of all the files and then again this lost is converted into an array and written to the output file. The reason for using array list is that it is flexible, it grows dynamically whenever needed unlike, arrays where the size has to be given while declaring the array itself.

b)Sorting algorithm used : Merge sort is used to sort both individual threads as well as the shared data structure list. I have used this sorting algorithm as its a stable sort which means that the same element in an array maintain their original positions with respect to each other. Overall time complexity of merge sort is O(nlogn).

c) I have updated the build.xml and it takes the arguments with respect to the N (N=1,2,3) accordingly.

d)Citations :

1)Thread Synchronization : https://www.tutorialspoint.com/java/java_thread_synchronization
                         https://www.geeksforgeeks.org/synchronized-in-java/
2)Merge sort : https://www.geeksforgeeks.org/merge-sort/
               https://www.dreamincode.net/forums/topic/223934-merge-sort-java-threads/
3)Conversion of String list into an integer array :https://www.techiedelight.com/convert-list-to-array-java/

Note : I have kept the name of HeapSort as it was, but I have written the code for Merge Sort for sorting in it. Just that the filename is HeapSort.java.
-----------------------------------------------------------------------
### Academic Honesty statement:
-----------------------------------------------------------------------

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating an official form will be
submitted to the Academic Honesty Committee of the Watson School to
determine the action that needs to be taken. "

Date: -- July 22nd,2019
