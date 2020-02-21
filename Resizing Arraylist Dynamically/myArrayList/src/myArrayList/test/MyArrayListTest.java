package myArrayList.util;

import myArrayList.MyArrayList;
import myArrayList.util.Results;

public class MyArrayListTest{

  private String Case ;
	String Result="";

  public void testMe(MyArrayList myarraylist, Results results) {
  test1(myarraylist, results);
  test2(myarraylist, results);
  test3(myarraylist, results);
  test4(myarraylist, results);
  test5(myarraylist, results);
  test6(myarraylist, results);
  test7(myarraylist, results);
  test8(myarraylist, results);
  test9(myarraylist, results);
  test10(myarraylist, results);
}

//To check the size of the array
  private void test1(MyArrayList myarraylist, Results results){
  Case = "Size Test";
  myarraylist.insertSorted(30);
  myarraylist.insertSorted(60);
  if(myarraylist.size()==2)
    Result=results.printResult(true,Case ,"PASS");
    else
    Result=results.printResult(false,Case ,"FAIL");
    results.storeNewResult(Result);

}

//Resizing Test
   private void test2(MyArrayList myarraylist, Results results){
   Case = "Add new element after 50 and check Increase in Array Size";

    for(int i=0;i<60;i++){
    myarraylist.insertSorted(i);
    }
    if(myarraylist.length() == 75)
      Result=results.printResult(true,Case ,"PASS");
    else
      Result=results.printResult(false,Case ,"FAIL");
    results.storeNewResult(Result);
    }

//To check the index of a given element
 private void test3(MyArrayList myarraylist, Results results){
  Case = "Index Test";
  myarraylist.insertSorted(10);
  myarraylist.insertSorted(20);
  myarraylist.insertSorted(30);
  myarraylist.insertSorted(40);
  myarraylist.insertSorted(50);
  myarraylist.insertSorted(60);
  myarraylist.insertSorted(70);
  myarraylist.insertSorted(80);
  if(myarraylist.indexOf(80)==7)
      Result=results.printResult(true,Case ,"PASS");
    else
      Result=results.printResult(false,Case ,"FAIL");
    results.storeNewResult(Result);
}

//To check the sum of all the elements
public void test4(MyArrayList myarraylist, Results results){
 Case = "Sum Test";
  int a=100;
  int b=200;
  int c=300;
  int d=400;
  myarraylist.insertSorted(a);
  myarraylist.insertSorted(b);
  myarraylist.insertSorted(c);
  myarraylist.insertSorted(d);
  int temp=a+b+c+d;
  if(myarraylist.sum()==temp)
        Result=results.printResult(true,Case ,"PASS");
    else
        Result=results.printResult(false,Case ,"FAIL");
    results.storeNewResult(Result);
}

//Addition of duplicate elements
private void test5(MyArrayList myarraylist, Results results){
 Case = "Adding duplicate and then checking the size of the array";
  myarraylist.insertSorted(30);
  myarraylist.insertSorted(60);
  int temp1 = myarraylist.size();
  myarraylist.insertSorted(60);
  int temp2 = myarraylist.size();
  if(temp2 > temp1)
      Result=results.printResult(true,Case ,"PASS");
    else
      Result=results.printResult(false,Case ,"FAIL");
    results.storeNewResult(Result);
}

//Addition of negative numbers to the arraylist
private void test6(MyArrayList myarraylist, Results results){
  Case = "Addition of negative numbers test";

  myarraylist.insertSorted(-20);
  myarraylist.insertSorted(-60);
  myarraylist.insertSorted(60);
  if(myarraylist.size()==1)
      Result=results.printResult(true,Case ,"PASS");
    else
      Result=results.printResult(false,Case ,"FAIL");
    results.storeNewResult(Result);

}

//To remove the values from the arraylist
private void test7(MyArrayList myarraylist, Results results){
  Case = "Remove Values test";

  myarraylist.insertSorted(10);
  myarraylist.insertSorted(20);
  myarraylist.insertSorted(30);
  int temp1 = myarraylist.size();
  myarraylist.removeValue(30);
  int temp2 = myarraylist.size();
  if(temp2 < temp1)
      Result=results.printResult(true,Case ,"PASS");
    else
      Result=results.printResult(false,Case ,"FAIL");
    results.storeNewResult(Result);
}

//To check the size of the arraylist taking into consieration the limit constraints
private void test8(MyArrayList myarraylist, Results results){
  Case = "Size test with constraint";

  myarraylist.insertSorted(60);
  myarraylist.insertSorted(20000);
  myarraylist.insertSorted(-1);
  if(myarraylist.size()==1)
      Result=results.printResult(true,Case ,"PASS");
    else
      Result=results.printResult(false,Case ,"FAIL");
    results.storeNewResult(Result);

}

//To compact the arraylist
private void test9(MyArrayList myarraylist, Results results){
  Case = "Compact Test";

  myarraylist.insertSorted(10);
  myarraylist.insertSorted(20);
  myarraylist.insertSorted(30);
  myarraylist.insertSorted(40);
  myarraylist.insertSorted(50);
  myarraylist.insertSorted(60);
  myarraylist.insertSorted(70);
  myarraylist.insertSorted(80);
  myarraylist.removeValue(20);
  myarraylist.removeValue(40);
  myarraylist.removeValue(60);
  myarraylist.compact();
  if(myarraylist.length()==5)
      Result=results.printResult(true,Case ,"PASS");
    else
      Result=results.printResult(false,Case ,"FAIL");
    results.storeNewResult(Result);

}

//To check two test cases Sum and Remove value combined
private void test10(MyArrayList myarraylist, Results results){
  Case = "Sum and remove test";


  myarraylist.insertSorted(1);
  myarraylist.insertSorted(2);
  myarraylist.insertSorted(3);
  myarraylist.insertSorted(4);
  int s=myarraylist.sum();
  myarraylist.removeValue(3);
  int ns = myarraylist.sum();
  //int temp2 = myarraylist.size();
  if(s==ns)
      Result=results.printResult(false,Case ,"FAIL");
    else
      Result=results.printResult(true,Case ,"PASS");
    results.storeNewResult(Result);

}
}
