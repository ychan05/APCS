/***

  Hand Sanitizers (Yat Long Chan + Diana Akhmedova)
  APCS pd8
  HW61 -- Instructions so Simple...
  2022-02-08t
  time spent: 0.5 hrs


  Summary of Algorithm:
  1) split array of size n into 2 subarrays
  2) repeat step 1 with each of the subarrays until there are n subarrays with 1 element each
  3) merge adjacent subarrays
  4) repeat 3 until one array with size n 

  ***/

public class MergeSort
{
  /******************************************************
   * int[] merge(int[],int[])
   * Merges two input arrays
   * Precond:  Input arrays are sorted in ascending order
   * Postcond: Input arrays unchanged, and
   * output array sorted in ascending order.
   ******************************************************/
  private static int[] merge( int[] a, int[] b )
  {
    int[] mergedArr = new int[a.length + b.length];
    int i = 0; // index of a
    int j = 0; // index of b
    int k = 0; // index of mergedArr
    
    while (i < a.length && j < b.length) { 
      if (a[i] <= b[j]) {
        mergedArr[k] = a[i];
        i++;
      } else {
        mergedArr[k] = b[j];
        j++;
      }
      k++;
    }

    // append any remaining elements in a to end of mergedArr
    while (i < a.length) {
        mergedArr[k] = a[i];
        i++;
        k++;
    }

    // append any remaining elements in b to end of mergedArr
    while (j < b.length) {
        mergedArr[k] = b[j];
        j++;
        k++;
    }

    return mergedArr;
  }//end merge()


  /******************************************************
   * int[] sort(int[])
   * Sorts input array using mergesort algorithm
   * Returns sorted version of input array (ascending)
   ******************************************************/
  public static int[] sort( int[] arr )
  {

    // arrays of size 1 already sorted
    int[] sorted = new int[arr.length];
    if (arr.length < 2) {
      sorted[0] = arr[0];
    } 

    // run sort algo otherwise
    else {
      int mid = arr.length / 2;
      int[] l = new int[mid]; // left half of original array
      int[] r = new int[arr.length - mid]; // right half of array
      int j = 0; // index of array for right half 

      // copy elements into the two halves
      for (int i = 0; i < arr.length; i ++) {
        if (i < mid) {
          l[i] = arr[i];
        } else {
          r[j] = arr[i];
          j++;
        }
      }

      // repeat for each subarray
      l = sort(l); 
      r = sort(r);

      // merge sorted subarrays
      sorted = merge(l,r);
    }
    return sorted;

  }//end sort()



  //-------------------HELPERS-------------------------
  //tester function for exploring how arrays are passed
  //usage: print array, mess(array), print array. Whaddayasee?
  public static void mess( int[] a ) {
    for( int i = 0 ; i<a.length; i++ )
      a[i] = 0;
  }

  //helper method for displaying an array
  public static void printArray( int[] a ) {
    System.out.print("[");
    for( int i : a )
      System.out.print( i + ",");
    System.out.println("]");
  }
  //---------------------------------------------------


  //main method for testing
  public static void main( String [] args )
  {
      int[] arr0 = {0};
      int[] arr1 = {1};
      int[] arr2 = {1,2};
      int[] arr3 = {3,4};
      int[] arr4 = {1,2,3,4};
      int[] arr5 = {4,3,2,1};
      int[] arr6 = {9,42,17,63,0,512,23};
      int[] arr7 = {9,42,17,63,0,9,512,23,9};

      System.out.println("\nTesting mess-with-array method...");
      printArray( arr3 );
      mess(arr3);
      printArray( arr3 );

      System.out.println("\nMerging arr1 and arr0: ");
      printArray( merge(arr1,arr0) );

      System.out.println("\nMerging arr4 and arr6: ");
      printArray( merge(arr4,arr6) );

      System.out.println("\nSorting arr4-7...");
      printArray( sort( arr4 ) );
      printArray( sort( arr5 ) );
      printArray( sort( arr6 ) );
      printArray( sort( arr7 ) );
    /*~~~~~~~~~~~~~~ Ye Olde Tester Bar ~~~~~~~~~~~~~~
      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
  }//end main()

}//end class MergeSort
