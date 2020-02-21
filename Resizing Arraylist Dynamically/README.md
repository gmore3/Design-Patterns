# CSX42: Assignment 1
## Name    : Garvita More
## BNumber : B00755031
## Bmail   : gmore3@binghamton.edu
-----------------------------------------------------------------------
-----------------------------------------------------------------------

Following are the commands and the instructions to run ANT on your project.
#### Note: build.xml is present in coursesRegistration/src folder.

-----------------------------------------------------------------------
## Instruction to clean:

####Command: ant -buildfile myArrayList/src/build.xml clean

Description: It cleans up all the .class files that were generated when you
compiled your code.

-----------------------------------------------------------------------
## Instruction to compile:

####Command: ant -buildfile myArrayList//src/build.xml all

Description: Compiles your code and generates .class files inside the BUILD folder.

-----------------------------------------------------------------------
## Instruction to run:

####Command: ant -buildfile myArrayList/src/build.xml run -Darg0=<input_file.txt> -Darg1=<output.txt> 

Note: Arguments accept the absolute path of the files.
-----------------------------------------------------------------------
## Description:

1.Resizing the arraylist that is the dynamically the size of the arraylist increases the input length increases than the initial limit of the array. In my program, this takes place by copying the array contents to another temp array and increasing the original array by a factor of 25. This happens as soon as the input is arr.length+1.

Time Complexity : O(n)+O(n)+O(n) = 3O(n) = O(n)

2.Searching for the index of an element would require to scan the array until you find the element and return its index.

Time Complexity : O(n)

3.Sorting the array would require O(n2). Sorting requires the array to be scanned at least twice to get the sorted format. It could have been done by O(n) if the elements would have been equal to the size of the array.

Time Complexity : O(n)

After running the code :

My output.txt gets created by the name ${arg1} and not output.txt. So please look for this filename for my output file.

Also, I have commented testMe() in Driver.java because keeping both testMe() and printing the sum, makes the sum come wrong. Kindly check this individually.
-----------------------------------------------------------------------
### Academic Honesty statement:
-----------------------------------------------------------------------

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating an official form will be
submitted to the Academic Honesty Committee of the Watson School to
determine the action that needs to be taken. "

Date: -- June 17,2019
