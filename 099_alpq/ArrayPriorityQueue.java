// Yatlongstan (Yat Long Chan, Weichen Liu, Gabriel Thompson)
// APCS
// HW99 -- Some Are More Equal Than Others, Codified
// 2022-05-13
// time spent: 0.9hrs

/*

DISCO:
 - Removing from the end of an ArrayList is a constant time operation
 - Although binary search has been implemented in our add() method, the method still
   runs in O(n) time, because it must before an ArrayList.add() operation, which runs
   in O(n) time, overriding the O(log n) time complexity that binary search has
 - isEmpty(), peekMin(), and removeMin() a trivial to implement.

QCC:
 - How exactly does an ArrayPriorityQueue differ from an OrderedArrayList? It's
   functionality and use cases appear to be the same.
 - How much does it matter whether the ArrayList used as the datatype is sorted from
   low to high or high to low?
 - It's kind of crazy that the seemingly logarithmic nature of the add() method is
   overruled by it having a single linear-time operation inside!

*/

import java.util.ArrayList;

public class ArrayPriorityQueue implements PriorityQueue {

	ArrayList<Integer> _list;

	// O(1)
	// EXPLANATION: Creating an array is constant time because it does not depend
        //              on any variables.
	public ArrayPriorityQueue() {
		_list = new ArrayList<Integer>();
	}

	// O(n)
	// EXPLANATION: Although our implementation of this method uses binary search,
        //              which would seem to make it O(log n), it still has to insert
        //              x into the array once, which is an O(n) operation. This makes
        //              the overall algorithm O(n) time.
	public void add( int x ) {
		int lo = _list.size() - 1;
		int hi = 0;
		int mid;

		while (hi <= lo) {
			mid = (hi + lo) / 2;
			if (_list.get(mid).compareTo(x) > 0) {
				hi = mid + 1;
			} else if (_list.get(mid).compareTo(x) < 0) {
				lo = mid - 1;
			} else {
				_list.add(mid, x);
				return;
			}

		}

		_list.add(hi, x);
	}

	// O(1)
	// EXPLANATION: Checking if an array is empty is constant time because it does
        // 		not depend on any variables
	public boolean isEmpty() {
		return _list.isEmpty();
	}

	// O(1)
	// EXPLANATION: Retrieving the last item of the array is constant time because
        // 		it does not depend on any variables
	public int peekMin() {
		return _list.get(_list.size()-1);
	}

	// O(1)
	// EXPLANATION: Although removing from an array is generally O(n) time because
	//              every item succeeding the item being removed must be shifted
	//		over, removing from the end won't require any shifting, so it
	//		runs in O(1) time
	public int removeMin() {
		return _list.remove(_list.size() -1);
	}

        // O(n)
	// EXPLANATION: Converting an ArrayList to a string requires processing every
	//		item of the array exactly once, so this method runs in O(n).
	public String toString() {
		return _list.toString();
	}

	public static void main(String[] args) {
		ArrayPriorityQueue poo = new ArrayPriorityQueue();
		poo.add(5);
		poo.add(3);
		poo.add(4);
                poo.add(7);
                poo.add(8);
                poo.add(1);
                System.out.println("poo: "+  poo);

                System.out.println();
                System.out.println("min: " + poo.peekMin());
                System.out.println("removeMin: " + poo.removeMin());
                System.out.println("min: " + poo.peekMin());
                System.out.println("removeMin: " + poo.removeMin());
                System.out.println("min: " + poo.peekMin());
                System.out.println("removeMin: " + poo.removeMin());

                System.out.println();
                System.out.println("poo: "+  poo);
	}

}