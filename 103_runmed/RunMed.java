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

// ALGO: 
// a. if next val < root of maxheap, add to maxheap
//    else add to minheap

// b. balance heaps (so that size difference < 2)
//    (remove from larger heap, add to smaller heap)

// c. at any time find med by:
//     a) heap sizes equal: med is mean of roots
//     b) heap sizes !equal: med is root of larger heap

import java.util.NoSuchElementException; 

public class RunMed {
        private ALHeapMin bigVals;
        private ALHeapMax lilVals;

        public RunMed(){
            bigVals = new ALHeapMin();
            lilVals = new ALHeapMax(); 
        }

        public double getMedian() {
            if (lilVals.size() == 0 && bigVals.size() == 0) {
                throw new NoSuchElementException();
            }
            else if (bigVals.size() > lilVals.size()) {
                return bigVals.peekMin() * 1.0; 
            } else if (bigVals.size() < lilVals.size()) {
                return lilVals.peekMax() * 1.0;
            } else {
                return (lilVals.peekMax() + bigVals.peekMin()) / 2.0; 
            }
        }

        public void add(Integer newVal){
            if (lilVals.size() == 0 && bigVals.size() == 0) {
                lilVals.add(newVal); 
            } else if (newVal < lilVals.peekMax()) {
                lilVals.add(newVal);
            } else {
                bigVals.add(newVal); 
            }

            balance();
        }

        public void balance() {
            while (Math.abs(lilVals.size() - bigVals.size()) >= 2) {
                if (lilVals.size() > bigVals.size()) {
                    bigVals.add(lilVals.removeMax());
                } else {
                    lilVals.add(bigVals.removeMin());
                }
            }
        }


} // end class