/***
 * class LLNode
 * Implements a node, for use in lists and other container classes.
 * Stores its data as a String
 **/

public class LLNode
{
  //instance vars
  private String cargo;
  private LLNode nextNode;

  // constructor
  public LLNode( String value, LLNode next )
  {
      cargo = value;
      nextNode = next;
  }


  //--------------v  ACCESSORS  v--------------
  public String getCargo()
  {
      return cargo;
  }

  public LLNode getNext()
  {
      return nextNode;
  }
  //--------------^  ACCESSORS  ^--------------


  //--------------v  MUTATORS  v--------------
  public String setCargo( String newCargo )
  {
      cargo = newCargo;
      return cargo;
  }

  public LLNode setNext( LLNode newNext )
  {
      nextNode = newNext;
      return nextNode;
  }
  //--------------^  MUTATORS  ^--------------


  // override inherited toString
  public String toString()
  {
      if (nextNode != null) return this.cargo + ", "  + nextNode.toString();

      return this.cargo;
  }


  //main method for testing
  public static void main( String[] args )
  {

    //Below is an exercise in creating a linked list...

    //Create a node
    LLNode first = new LLNode( "cat", null );
    //System.out.println(first);

    //Create a new node after the first
    first.setNext( new LLNode( "dog", null ) );
    //System.out.println(first);

    //Create a third node after the second
    first.getNext().setNext( new LLNode( "cow", null ) );
    //System.out.println(first);

    /* A naive list traversal, has side effects.... ??
    while( first != null ) {
        System.out.println( first );
        first = first.getNext();
    }
    */
    //Q: when head ptr moves to next node in list, what happens to the node it just left? 
    //A: It becomes null
    
    //...so better: ?
    //make a clone of list
    LLNode clone = first;
    while( clone != null ) {
        System.out.println( clone );
        clone = clone.getNext();
    }

  }//end main

}//end class LLNode
