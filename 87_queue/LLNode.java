/***
 * class LLNode
 * Implements a node, for use in lists and other container classes.
 * Stores its data as a String
 **/

public class LLNode<T>
{
  //instance vars
  private T cargo;
  private LLNode<T> next;

  // constructor
  public LLNode( T value, LLNode<T> next )
  {
    cargo = value;
    this.next = next;
  }


  //--------------v  ACCESSORS  v--------------
  public T getCargo()
  {
    return cargo;
  }

  public LLNode<T> getNext()
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

  public LLNode<T> setNext( LLNode<T> newNext )
  {
    LLNode<T> ret = next;
    this.next = newNext;
    return ret;
  }
  //--------------^  MUTATORS  ^--------------

}//end class LLNode