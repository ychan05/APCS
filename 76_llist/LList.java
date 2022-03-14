/***
 * class LList
 * Implements a linked list of LLNodes, each containing String data
 **/

public class LList implements List //interface def must be in this dir
{

  //instance vars
  private LLNode _head;
  private int _size;

  // constructor -- initializes instance vars
  public LList( )
  {
    _head = null;
    _size = 0;
  }


  //--------------v  List interface methods  v--------------

  public boolean add( String newVal )
  {
    if (_head == null) {
      _head = new LLNode(newVal, null);
    } else {
      LLNode temp = _head;
      while (temp.getNext() != null) {temp = temp.getNext();}
      temp.setNext(new LLNode(newVal, null));
    }
    _size ++;
    return true;
  }


  public String get( int index )
  {
    if ( index < 0 || index >= size() )
      throw new IndexOutOfBoundsException();
    
    if (index == 0) {return _head.getCargo();}

    int ctr = 0;
    LLNode temp = _head;

    while (temp != null) {
      if (ctr == index) {return temp.getCargo();}
      temp = temp.getNext();
      ctr++;
    }
    return null;
  }


  public String set( int index, String newVal )
  {
    String ret;

    if ( index < 0 || index >= size() )
      throw new IndexOutOfBoundsException();

    if (index == 0) {
      ret = _head.getCargo();
      _head.setCargo(newVal);
      return ret;
    }

    int ctr = 0;
    LLNode temp = _head;

    while (temp != null) {
      if (ctr == index) {
        ret = temp.getCargo();
        temp.setCargo(newVal);
        return ret;
      }
      temp = temp.getNext();
      ctr++;
    }
    
    return null;
  }


  //return number of nodes in list
  public int size()
  {
    return _size;
  }

  //--------------^  List interface methods  ^--------------



  // override inherited toString
  public String toString()
  {
    String ret = "";
    LLNode temp = _head;
    while (temp != null) {
      ret = ret + temp.getCargo() + " ";
      temp = temp.getNext();
    }
    return ret;
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
    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
  }

}//end class LList
