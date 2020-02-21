package multiThreadedHS.util;

import multiThreadedHS.threads.ThreadWorker;

public class HeapSort {

  /**
   * @param array to be sorted
   * Citation : https://www.geeksforgeeks.org/merge-sort/
   * Citation : https://www.dreamincode.net/forums/topic/223934-merge-sort-java-threads/
   * @return result
   */

  public static synchronized int[] mergeSort(int arr[]) {
  		if(arr.length <= 1) {
  			return arr;
  		}

  		int mid = arr.length / 2;
  		int left[] = new int[mid];
  		int right[];

  		if(arr.length%2 == 0)
  			right = new int[mid];
  		else
  			right = new int[mid+1];

  		for(int i=0;i<left.length;i++)
  			left[i] = arr[i];

  		for(int j=0;j<right.length;j++)
  			right[j] = arr[mid+j];

  		//Create the resultant array
  		int result[] = new int[arr.length];

  		//Call mergeSort on left and right
  		left = mergeSort(left);
  		right = mergeSort(right);
  		result = merge(left, right);

      try {
        Thread.sleep(400);
      }
      catch(Exception e) {
        System.out.println(e);
      }
  		return result;
  	}

  /**
   * @param left,right
   * combines the divided arrays, left and right
   * Citation : https://www.geeksforgeeks.org/merge-sort/
   * Citation : https://www.dreamincode.net/forums/topic/223934-merge-sort-java-threads/
   * @return result, combination of left and right arrays
   */
  public static int[] merge(int[] left, int[] right) {
  		int[] result = new int[left.length + right.length];

  		int leftPointer, rightPointer, resultPointer;
  		leftPointer = rightPointer = resultPointer = 0;

  		while(leftPointer < left.length || rightPointer < right.length) {
  			if(leftPointer < left.length && rightPointer < right.length) {
  				if(left[leftPointer] < right[rightPointer])
  					result[resultPointer++] = left[leftPointer++];
  				else
  					result[resultPointer++] = right[rightPointer++];
  			}

  			else if(leftPointer < left.length) {
  				result[resultPointer++] = left[leftPointer++];
  			}
  			else if (rightPointer < right.length) {
  				result[resultPointer++] = right[rightPointer++];
  			}
  		}
  		return result;
  	}

}
