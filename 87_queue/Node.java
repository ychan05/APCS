/***
 * class LLNode
 * Implements a node, for use in lists and other container classes.
 * Stores its data as a String
 **/

public class Node<T>
{
  //instance vars
  private T cargo;
  private Node<T> next;

  // constructor
  public Node( T value, Node<T> next )
  {
    cargo = value;
    this.next = next;
  }


  //--------------v  ACCESSORS  v--------------
  public T getCargo()
  {
    return cargo;
  }

  public Node<T> getNext()
  {
    return next;
  }
  //--------------^  ACCESSORS  ^--------------


  //--------------v  MUTATORS  v--------------
  public T setCargo( T newCargo )
  {
    T ret = cargo;
    this.cargo = newCargo;
    return ret;
  }

  public Node<T> setNext( Node<T> newNext )
  {
    Node<T> ret = next;
    this.next = newNext;
    return ret;
  }
  //--------------^  MUTATORS  ^--------------

}//end class LLNode