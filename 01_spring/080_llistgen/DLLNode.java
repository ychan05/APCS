/*****************************************************
 * class LLNode
 * Implements a node, for use in lists and other container classes.
 * Stores its data as a String
 *****************************************************/

public class DLLNode<T>
{
    //instance vars
    private T _cargo;    //cargo may only be of type T
    private DLLNode<T> _nextNode; //pointer to next LLNode
	private DLLNode<T> _prevNode; //pointer to previous LLnode

    // constructor -- initializes instance vars
    public DLLNode( DLLNode<T> prev, T value, DLLNode<T> next ) {
	_cargo = value;
	_nextNode = next;
	_prevNode = prev;
    }


    //--------------v  ACCESSORS  v--------------
    public T getCargo() { return _cargo; }

    public DLLNode<T> getNext() { return _nextNode; }
	
	public DLLNode<T> getPrev() { return _prevNode; }
    //--------------^  ACCESSORS  ^--------------


    //--------------v  MUTATORS  v--------------
    public T setCargo( T newCargo ) {
	T foo = getCargo();
	_cargo = newCargo;
	return foo;
    }

    public DLLNode<T> setNext( DLLNode<T> newNext ) {
	DLLNode<T> foo = getNext();
	_nextNode = newNext;
	return foo;
    }

    public DLLNode<T> setPrev( DLLNode<T> newPrev ) {
	DLLNode<T> foo = getPrev();
	_prevNode = newPrev;
	return foo;
	}

			
    //--------------^  MUTATORS  ^--------------

    
    // override inherited toString
    public String toString() { return _cargo.toString(); }

}//end class LLNode

