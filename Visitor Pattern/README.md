# csx42_summer_19_assign_5
# CSX42: Assignment 5
## Name    : Garvita More
## BNumber : B00755031
## Bmail   : gmore3@binghamton.edu
-----------------------------------------------------------------------
-----------------------------------------------------------------------

Following are the commands and the instructions to run ANT on your project.
#### Note: build.xml is present in multi/src folder.

-----------------------------------------------------------------------
## Instruction to clean:

####Command: ant -buildfile troubleShootSearch/src/build.xml clean

Description: It cleans up all the .class files that were generated when you
compiled your code.

-----------------------------------------------------------------------
## Instruction to compile:

####Command: ant -buildfile troubleShootSearch//src/build.xml all

Description: Compiles your code and generates .class files inside the BUILD folder.

-----------------------------------------------------------------------
## Instruction to run:

####Command:

ant -buildfile troubleShootSearch/src/build.xml run -Darg0=userInputs.txt -Darg1="technicalA.txt" -Darg2="technicalB.txt" -Darg3="technicalC.txt" -Darg4="synonyms.txt" -Darg5="output.txt" -Darg6=2

ant -buildfile troubleShootSearch/src/build.xml run -Darg0=userInputs.txt -Darg1="technicalA.txt" -Darg2="technicalB.txt" -Darg3="technicalC.txt" -Darg4="synonyms.txt" -Darg5="output.txt" -Darg6=3

ant -buildfile troubleShootSearch/src/build.xml run -Darg0=userInputs.txt -Darg1="technicalA.txt" -Darg2="technicalB.txt" -Darg3="technicalC.txt" -Darg4="synonyms.txt" -Darg5="output.txt" -Darg6=4

debugValue = 2,3,4  where 2=ABSTRACT when the abstract class gets called, 3=FILE whether file is opened and/or closed, 4=VISITOR whether the visitor is visited
Note: Arguments accept the absolute path of the files.
-----------------------------------------------------------------------
## Description:

Command Line Arguments :

-Darg0=userInputs.txt     --For the user Inputs (there are total 27 entries out of which 8 work with Exact match, 8  work with Naive Stemming match, 8 work with
                            Semantic match and the remaining do not work for any of the mentioned matches)
-Darg1=technicalA.txt     --For the technical sentences for Product A
-Darg2=technicalB.txt     --For the technical sentences for Product B
-Darg3=technicalC.txt     --For the technical sentences for Product C
-Darg5=synonyms.txt       --For the synonyms required for the Semantic Search
-Darg6=output.txt         --For the output file generated using the matched sentences form the different searching algorithms

-----Data structures used :

1.ArrayList is used to store all the string representation of the input sentences from userInputs, technicalA, technicalB, technicalC .txt files.
2.HashMap is used to store the key-value pairs of synonyms coming from the synonyms.txt files.

-----Working of the Program :

1.I have considered three different technical files namely technicalA, technicalB, technicalC for the Products A,B and C respectively and one input file namely userInputs.txt for the inputs from the user.

2.When the inputs from the input file come, it goes to the respective search methods (Exact, Naive Stemming and Semantic) to find the appropriate match and the print the matched sentences into the output file i.e output.txt file.

-----Implementation of the Visitor Pattern :

1.There are two interfaces :

a.)SearchVisitorInterface which is implemented by class SearchVisitor and has the method implementation for the three methods declared in the interface -- visit(Exact e),visit(NaiveStemming n)and visit(Semantic s).

b.)Product interface which is implemented by three classes namely Exact, NaiveStemming, Semantic and overrides the accept(SearchVisitorInterface searchvisitor) declared in the interface.

c.)There is an abstract class called Search which has three abstract methods so that they can be implemented in the class that extends it (helps in accessing the contents to and forth between classes):
  1.putExact() which initializes the file processor contents from the file processor and helps in accessing them
  2.putSemantic() which initializes the file processor contents from the file processor and helps in accessing them
  3.output() which initializes the filename of the output file from the command line

-----Flow of the program :

1.There are three concrete classes namely Exact, NaiveStemming and Semantic which overrides the accept() method which take the argument of type visitor interface i.e SearchVisitorInterface.

2.The visitor interface i.e SearchVisitorInterface implements the visit which takes arguments of type of the Concrete classes Exact, NaiveStemming and Semantic.

When from the driver, the statement "e.accept(s)", it understands that it has to go to the Exact class because "e" is an object of Exact class which is of type Product interface in which it is declared, there it accepts the argument which is of concrete visitor interface type, in which it understands that it has to go to the visit() in which it takes the arguments of type Exact, wherein the logic for the Exact match pattern is implemented.

Similarly it works for NaiveStemming and Semantic Search.

-----Citations :

Visitor Pattern : https://www.tutorialspoint.com/design_pattern/visitor_pattern
                  https://www.geeksforgeeks.org/visitor-design-pattern/
Conversion of String List into an array : https://www.techiedelight.com/convert-list-to-array-java/
Abstract class : https://stackoverflow.com/questions/1320745/abstract-class-in-java

-----------------------------------------------------------------------
### Academic Honesty statement:
-----------------------------------------------------------------------

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating an official form will be
submitted to the Academic Honesty Committee of the Watson School to
determine the action that needs to be taken. "

Date: -- August 5th,2019
