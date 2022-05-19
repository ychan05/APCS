// Yatlongstan (Yat Long Chan, Gabriel Thompson, Weichen Liu)
// APCS
// HW103 -- Erica's Friends, Hugo, and The One in the Middle
// 2022-05-18
// time spent: 0.8hrs

/*
DISCO
- We throw NoSuchElementException() if there are no elements in either heaps 
- bigVals corresponds to minHeap while lilVals corresponds to maxheap
- We should use a while loop in balanced() to make sure that the heaps are balanced 


QCC
- Will we have to merge minHeaps and maxHeaps in the future?
- What are some cases where you would need a running median? 
- What other major types of heaps are there? 

*/




/**
   driver file for testing class RunMed

   (RunMed provides for calculating a running median
   of a stream of input ints)

   USAGE: Runnable as-is.
   Uncomment RunMed-specific lines below once RunMed is implemented.
   Compile, run fr same dir as RunMed.java

   to feed numbers manually:
   $ java RunMed

   to feed in prepared set:
   $ java RunMed < input.nums
   (input.nums provided; must be in same dir)

   -------------------------
   Clyde "Thluffy" Sinclair
   APCS
   2018-05-17
*/

import java.util.Scanner;

public class RunMedDriver
{
  public static void main( String[] args )
  {

     RunMed r = new RunMed();

    int n;
    double median;
    int count = 0;
    Scanner sc = new Scanner( System.in );

    while( sc.hasNextInt() ) {
      try {
        n = sc.nextInt();
        System.out.print("read " + n + "\n");

        count++;
        System.out.print("this many ints have been seen: " + count + "\n");

        r.add(n);
        median = r.getMedian();
        System.out.print("median is now " + median + "\n");
      } catch (Exception e) {
        System.err.println("BOOP! probs w yer input:\n"+e);
      }
    }

  }//end main

}//end class