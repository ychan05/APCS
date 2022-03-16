// Under Pressure: Julia Kozak, Yat Long Chan, Anjini Katari
// APCS pd08
// HW77 -- Insert|Remove
// 2022-03-16w
// time spent: 0.6hrs
// KTS used: 2

/***
 * class LList
 * Implements a linked list of LLNodes, each containing String data
 * 
 * algo for remove:
 * if index is less than 0 or greater than the current size, return 
 *   an error
 * if the node you want to remove is at index 0, set ret to the 
 *   current cargo value and reassign head to the next node 
 * if the node you want to remove is the last one in the list, 
 *   set head to tmp, and set the current tmp value equal to the next 
 *   node until you reach the last node. Set ret to the current cargo, 
 *   and the next node to null 
 * If the node being removed is not the first or the last node in the 
 *   list, set temp to the current head value and and set the current 
 *   tmp value equal to the next node until you reach the last node. 
 *   Set ret to the current tmp cargo and names the node that is 2 
 *   nodes away from the current location and set that to be the next node  
 *   from the current location.
 * return ret
 * 
 * algo for add:
 * if index is less than 0 or greater than the current size, return 
 *   an error
 * if you're trying to add a node to the first position, add(newVal)
 * Otherwise create LLNode tmp and assign it the value of head before 
 *   having tmp equal the next node for every node until you reach one 
 *   before the targeted index. 
 * create a new node and set its contents to newVal and have it point to 
 *   the next node. Set temp to the new node and then increase the size. 
 **/

public class LList implements List //interface def must be in this dir
{

  //instance vars
  private LLNode _head;
  private int _size;

  // constructor -- initializes instance vars
  public LList( )
  {
    _head = null; //at birth, a list has no elements
    _size = 0;
  }


  //--------------v  List interface methods  v--------------

  public boolean add( String newVal )
  {
    //make a new node with cargo newVal and made it point to head
    //change head to the new node and increase size
    LLNode tmp = new LLNode( newVal, _head );
    _head = tmp;
    _size++;
    return true;
  }


  public String get( int index )
  {
    if ( index < 0 || index >= size() )
      throw new IndexOutOfBoundsException();

    String retVal;
    LLNode tmp = _head; //create alias to head

    //walk to desired node and set temp to the next node 
    for( int i=0; i < index; i++ )
      tmp = tmp.getNext();

    //check target node's cargo hold
    retVal = tmp.getCargo();
    return retVal;
  }


  public String set( int index, String newVal )
  {

    if ( index < 0 || index >= size() )
      throw new IndexOutOfBoundsException();

    LLNode tmp = _head; //create alias to head

    //walk to desired node
    for( int i=0; i < index; i++ )
      tmp = tmp.getNext();

    //store target node's cargo
    String oldVal = tmp.getCargo();

    //modify target node's cargo
    tmp.setCargo( newVal );

    return oldVal;
  }


  //return number of nodes in list
  public int size() { return _size; }

/* algo for remove 
  * if index is less than 0 or greater than the current size, return 
    an error
  * if the node you want to remove is at index 0, set ret to the 
    current cargo value and reassign head to the next node 
  * if the node you want to remove is the last one in the list, 
    set head to tmp, and set the current tmp value equal to the next 
    node until you reach the last node. Set ret to the current cargo, 
    and the next node to null 
  * If the node being removed is not the first or the last node in the 
    list, set temp to the current head value and and set the current 
    tmp value equal to the next node until you reach the last node. 
    Set ret to the current tmp cargo and names the node that is 2 
    nodes away from the current location and set that to be the next node 
    from the current location.
  * return ret

*/
  public String remove( int index ){
    if (index < 0 || index >= size())
      throw new IndexOutOfBoundsException();

    String ret;
    if (index == 0) {
      ret = _head.getCargo();
      _head = _head.getNext();
    }

    else if (index == _size - 1) {
      LLNode tmp = _head;
      for (int i = 0; i < index - 1; i++) {
        tmp = tmp.getNext();
      }

      ret = tmp.getCargo();
      tmp.setNext(null);
    }

    else {
      LLNode tmp = _head;
      for (int i = 0; i < index - 1; i++) {
        tmp = tmp.getNext();
      }

      ret = tmp.getCargo();
      LLNode newNext = tmp.getNext().getNext(); 
      //names the node that the prev node should point to
      tmp.setNext(newNext);
    }
      _size--;
      return ret;
  }

  /*
    * if index is less than 0 or greater than the current size, return 
    an error
    * if you're trying to add a node to the first position, add(newVal)
    * Otherwise create LLNode tmp and assign it the value of head before 
      having tmp equal the next node for every node until you reach one 
      before the targeted index. 
    * create a new node and set its contents to newVal and have it point to 
      the next node. Set temp to the new node and then increase the size. 
  */
  public void add(int index, String newVal) {
    if (index < 0 || index >= size())
      throw new IndexOutOfBoundsException();

    if (index == 0) {
      add(newVal);
      return;
    }

    LLNode tmp = _head;
    for (int i = 0; i < index - 1; i++) {
      tmp = tmp.getNext();
    }

    LLNode newNode = new LLNode(newVal, tmp.getNext());
    tmp.setNext(newNode);
    _size++;
  }

  //--------------^  List interface methods  ^--------------


  // override inherited toString
  public String toString()
  {
    String retStr = "HEAD->";
    LLNode tmp = _head; //init tr
    while( tmp != null ) {
	    retStr += tmp.getCargo() + "->";
	    tmp = tmp.getNext();
    }
    retStr += "NULL";
    return retStr;
  }


  //main method for testing
  public static void main( String[] args )
  {
    LList james = new LList();

    System.out.println( james );
    System.out.println( "size: " + james.size() );

    james.add("beat");
    System.out.println( james );
    System.out.println( "size: " + james.size() );

    james.add("a");
    System.out.println( james );
    System.out.println( "size: " + james.size() );

    james.add("need");
    System.out.println( james );
    System.out.println( "size: " + james.size() );

    james.add("I");
    System.out.println( james );
    System.out.println( "size: " + james.size() );

    System.out.println( "2nd item is: " + james.get(1) );

    james.set( 1, "got" );
    System.out.println( "...and now 2nd item is: " + james.set(1,"got") );

    System.out.println( james );
  }

}//end class LList
