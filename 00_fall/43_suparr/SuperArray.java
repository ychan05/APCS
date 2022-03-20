// LYJ: Yat Long Chan, Lawrence Joa, Joshua Gao
// APCS pd7
// HW43 -- encapsulation (basic SuperArray functionality)
// 2021-12-07
// Time spent: 0.5 hours

/***************************
DISCO
- nothing new
QCC 
- What is _size going to be used for?
***************************/

/***************************
 * class SuperArray
 * Wrapper class for array. Facilitates resizing,
 * getting and setting element values.
 ***************************/

public class SuperArray
{

  private int[] _data;  //underlying container
  private int _size;    //number of elements in this SuperArray


  //default constructor – initializes 10-item array
  public SuperArray() {
      this._data = new int[10];
      this._size = this._data.length;
  }


  //output SuperArray in [a,b,c] format
  public String toString() {
      String s = "[";
      for (int i = 0; i < _size; i ++){
          if (i != this._size - 1) {
              s = s + this._data[i] + ", ";
            } else {
              s = s + this._data[i] + "]";
            }
        }
        return s;
    }


  //double capacity of SuperArray
  private void expand() {
      int[] tempA = new int[this._size * 2];
      for (int i = 0; i < _size; i ++){
          tempA[i] = this._data[i];
      }
      this._data = tempA;
      this._size = this._size * 2;
    }


  //accessor -- return value at specified index
  public int get( int index )
  {
    return this._data[index];
  }


  //mutator -- set value at index to newVal,
  //           return old value at index
  public int set( int index, int newVal )
  {
    int oldVal = this._data[index];
    this._data[index] = newVal;
    return oldVal;
  }


  //main method for testing
  public static void main( String[] args )
  {
    
      SuperArray curtis = new SuperArray();
      System.out.println( "Printing empty SuperArray curtis..." );
      System.out.println( curtis );

      for( int i = 0; i < curtis._data.length; i++ ) {
      curtis.set( i, i * 2 );
      }

      System.out.println("Printing populated SuperArray curtis...");
      System.out.println(curtis);

      System.out.println("Printing Index 1 of SuperArray curtis...");
      System.out.println(curtis.get(1));

      System.out.println("Replacing Index 1 of SuperArray curtis...");
      System.out.println(curtis.set(1, 3));
      System.out.println(curtis);

      for( int i = 0; i < 3; i++ ) {
      curtis.expand();
      System.out.println("Printing expanded SuperArray curtis...");
      System.out.println(curtis);
      }
      /*~~~~~~~~move~me~down~~~~~~~~~~~~~~V~~~~~~~~
      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|~~~~~~~~*/
  }//end main()


}//end class