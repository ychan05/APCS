//Under Pressure: Julia Kozak, Yat Long Chan, Anjini Katari
//APCS pd08
//HW90 - Swabbing the Deque
//2022-04-12T
//time spent: 0.4 hours


import java.util.LinkedList;
import java.util.Iterator;

public class LLDeque<T> implements Deque<T> {
    private LinkedList<T> _deque;



    public LLDeque() {
        _deque = new LinkedList<T>();
    }

    public T peekFirst() {
        return _deque.peekFirst();
    }

    public T peekLast() {
        return _deque.peekLast();
    }

    public boolean isEmpty() {
        return _deque.size() <= 0;
    }

    public void addFirst(T x) {
        _deque.addFirst(x);
    }

    public void addLast(T x) {
        _deque.addLast(x);        
    }

    public T removeFirst() {
        return _deque.removeFirst();
    }
    
    public T removeLast() {
        return _deque.removeLast();
    }

    public T peek() {
        return _deque.peek();        
    }

    public boolean add(T x) {
        return _deque.add(x);
    }

    public T remove() {
        return _deque.remove();
    }

    public Iterator<T> iterator() {
        return _deque.iterator();
    }

    public int size() {
        return _deque.size();
    }
}
