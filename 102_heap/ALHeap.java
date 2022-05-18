// Yatlongstan (Yat Long Chan, Gabriel Thompson, Weichen Liu)
// APCS
// HW102 -- Heap On Heapin’ On
// 2022-05-17
// time spent: 0.8hrs

/***
 *
 * DISCO
 *  - You have to check if the heap is empty before preceding
 *  - In a heap, there are multiple places that a node can go (unlike a BST)
 *  - An ArrayList-based heap is just as complete as a node-based heap would be
 *
 * QCC
 *  - What is the use of the minOf() function? We didn't end up needing it.
 *  - (How) can we simplify the spaghetti if statements in minChildPos?
 *  - Are we going to implement a remove-at-index method?
 *
 ***/

/**
 * class ALHeap
 * SKELETON
 * Implements a min heap using an ArrayList as underlying container
 */

import java.util.ArrayList;

public class ALHeap
{

  //instance vars
  private ArrayList<Integer> _heap;

  /**
   * default constructor  ---  inits empty heap
   */
  public ALHeap()
  {
    _heap = new ArrayList<Integer>();
  }



  /**
   * toString()  ---  overrides inherited method
   * Returns either
   * a) a level-order traversal of the tree (simple version)
   * b) ASCII representation of the tree (more complicated, more fun)
   */
  public String toString()
  {
    return _heap.toString();
  }//O(n), because you need to print out each item of the array


  /**
   * boolean isEmpty()
   * Returns true if no meaningful elements in heap, false otherwise
   */
  public boolean isEmpty()
  {
    return _heap.isEmpty();
  }//O(1), because the program is just performing a check independent of the size of the array


  /**
   * Integer peekMin()
   * Returns min value in heap
   * Postcondition: Heap remains unchanged.
   */
  public Integer peekMin()
  {
    return _heap.get(0);
  }//O(1), because retrieving the value at an index in an ArrayList is a constant-time operation


  /**
   * add(Integer)
   * Inserts an element in the heap
   * Postcondition: Tree exhibits heap property.
   *
   * ALGO:
   *   Add item to heap
   *   if heap is empty
   *	  end the function
   *   insert node after deepest node
   *   while node value < parent value
   *	  swap the two
   *      update the value for parent
   */
  public void add( Integer addVal )
  {
    _heap.add(addVal);
    if (isEmpty()) {
      return;
    }

    int current = _heap.size() - 1;
    int p = (current - 1) / 2;

    while (addVal < _heap.get(p)) {
      swap(p, current);
      current = p;
      p = (current - 1) / 2;
    }
  }//O(log n), because the complexity is roughly proportional to how many layers the algorithm must traverse


  /**
   * removeMin()  ---  means of removing an element from heap
   * Removes and returns least element in heap.
   * Postcondition: Tree maintains heap property.
   *
   * ALGO:
   *   if the heap is empty
   *      end the function
   *   replace root node with deepest node
   *   remove the deepest node
   *   if the node is smaller than both of its children
   *      you are done
   *   but if that condition hasn't been met,
   *	  swap with smaller child with the current node
   *	  repeat from if statement
   */
  public Integer removeMin()
  {
    if (isEmpty())
      return null;

    int toReturn = _heap.get(0);
    _heap.set(0, _heap.get(_heap.size() - 1));
    _heap.remove(_heap.size() - 1);

    int root = 0;
    int minChild;
    while ((((2*root + 1) < _heap.size()) && _heap.get(root) > _heap.get(2*root + 1)) ||
            (((2*root + 2) < _heap.size()) &&_heap.get(root) > _heap.get(2*root + 2))) {
      minChild = minChildPos(root);
      swap(root, minChild);
      root = minChild;
    }

    return toReturn;
  }//O(log n), because the while loop will run as many times as there are layers in the heap


  /**
   * minChildPos(int)  ---  helper fxn for removeMin()
   * Returns index of least child, or
   * -1 if no children, or if input pos is not in ArrayList
   * Postcondition: Tree unchanged
   */
  private int minChildPos( int pos )
  {
    int childOneIndex = 2 * pos + 1;
    int childTwoIndex = 2 * pos + 2;

    if (childOneIndex >=_heap.size()) {
      if (childTwoIndex >= _heap.size()) {
	return -1;
      }
      return childTwoIndex;
    }
    if (childTwoIndex >= _heap.size()) {
      return childOneIndex;
    }

    if (_heap.get(childOneIndex) > _heap.get(childTwoIndex)) {
      return childTwoIndex;
    }
    return childOneIndex;
  }//O(1), because no iteration is occurring, and there is no difference in performance for different heap sizes

  //~~~~~~~~~~~~~ aux helper fxns ~~~~~~~~~~~~~~
  private Integer minOf( Integer a, Integer b )
  {
    if ( a.compareTo(b) < 0 )
      return a;
    else
      return b;
  }

  //swap for an ArrayList
  private void swap( int pos1, int pos2 )
  {
    _heap.set( pos1, _heap.set( pos2, _heap.get(pos1) ) );	
  }
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~



  //main method for testing
  public static void main( String[] args )
  {
      ALHeap pile = new ALHeap();
      pile.add(2);
      System.out.println(pile);
      pile.add(4);
      System.out.println(pile);
      pile.add(6);
      System.out.println(pile);
      pile.add(8);
      System.out.println(pile);
      pile.add(10);
      System.out.println(pile);
      pile.add(1);
      System.out.println(pile);
      pile.add(3);
      System.out.println(pile);
      pile.add(5);
      System.out.println(pile);
      pile.add(7);
      System.out.println(pile);
      pile.add(9);
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
  }//end main()

}//end class ALHeap