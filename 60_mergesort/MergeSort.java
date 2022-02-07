
// Hand Sanitizers (Yat Long Chan + Diana Akhmedova + David Chen)
// APCS pd8
// HW60 -- Merge Sort algo
// 2022-02-07m
// time spent: 0.5 hrs

/***
 * class MergeSort
 * Implements mergesort on array of ints.
 * 
 * Summary of Algorithm:
 * 1) Divide array into approximate halves
 * 2) keep dividing those halves until each subdivision is only 1 element
 * 3) Merge each of the adjacent subdivisions in ascending order until an array of size n is reached 
 * 
 ***/

public class MergeSort {
  /******************************************************
   * int[] merge(int[],int[])
   * Merges two input arrays
   * Precond: Input arrays are sorted in ascending order
   * Postcond: Input arrays unchanged, and
   * output array sorted in ascending order.
   ******************************************************/
  private static int[] merge(int[] a, int[] b) {
    int[] mergedArr = new int[a.length + b.length];
    int i = 0; // index for a
    int j = 0; // index for b
    int k = 0; // index for mergedArr

    // check and add to mergedArr until one array runs out of elements
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

    // append any remaining elements at end of mergedArr
    while (i < a.length) {
      mergedArr[k] = a[i];
      i++;
      k++;
    }

    // append any remaining elements at end of mergedArr
    while (j < b.length) {
      mergedArr[k] = b[j];
      j++;
      k++;
    }

    return mergedArr;
  }// end merge()

  /******************************************************
   * int[] sort(int[])
   * Sorts input array using mergesort algorithm
   * Returns sorted version of input array (ascending)
   ******************************************************/
  public static int[] sort(int[] arr) {
    int[] sorted;
    
    // array of len 1 is sorted
    if (arr.length < 2) { 
      sorted = new int[arr.length];
      sorted[0] = arr[0];
    } 

    // divide arr in half otherwise
    else {
      int mid = arr.length / 2;
      int[] l = new int[mid]; // left half of arr
      int[] r = new int[arr.length - mid]; // right half of arr
      int j = 0; // index of right half

      // copy elements of arr into halves
      for (int i = 0; i <arr.length; i ++) {
        if (i < mid) {
          l[i] = arr[i];
        } else {
          r[j] = arr[i];
          j++;
        }
      }

      // keep dividing each half in 2 until each are 1 element
      l = sort(l); 
      r = sort(r);

      // merge the two halves together at the end
      sorted = merge(l, r);
    }
    return sorted;
  }// end sort()

  // -------------------HELPERS-------------------------
  // tester function for exploring how arrays are passed
  // usage: print array, mess(array), print array. Whaddayasee?
  public static void mess(int[] a) {
    for (int i = 0; i < a.length; i++)
      a[i] = 0;
  }

  // helper method for displaying an array
  public static void printArray(int[] a) {
    System.out.print("[");
    for (int i : a)
      System.out.print(i + ",");
    System.out.println("]");
  }
  // ---------------------------------------------------

  // main method for testing
  public static void main(String[] args) {
    int[] arr0 = { 0 };
    int[] arr1 = { 1 };
    int[] arr2 = { 1, 2 };
    int[] arr3 = { 3, 4 };
    int[] arr4 = { 1, 2, 3, 4 };
    int[] arr5 = { 4, 3, 2, 1 };
    int[] arr6 = { 9, 42, 17, 63, 0, 512, 23 };
    int[] arr7 = { 9, 42, 17, 63, 0, 9, 512, 23, 9 };

    System.out.println("\nTesting mess-with-array method...");
    printArray(arr3);
    mess(arr3);
    printArray(arr3);

    System.out.println("\nMerging arr1 and arr0: ");
    printArray(merge(arr1, arr0));

    System.out.println("\nMerging arr4 and arr6: ");
    printArray(merge(arr4, arr6));

    System.out.println("\nSorting arr4-7...");
    printArray(sort(arr4));
    printArray(sort(arr5));
    printArray(sort(arr6));
    printArray(sort(arr7));


    /* ~~~~~~~~~~~~~~ Ye Olde Tester Bar ~~~~~~~~~~~~~~
       ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
  }// end main()

}// end class MergeSort
