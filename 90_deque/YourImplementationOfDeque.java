//Under Pressure: Julia Kozak, Yat Long Chan, Anjini Katari
//APCS pd08
//HW90 - Swabbing the Deque
//2022-04-11M
//time spent: 0.4 hours


import java.util.LinkedList;

public class YourImplementationOfDeque<T> implements Deque<T> {
    private LinkedList<T> _dequeue;

    public YourImplementationOfDeque() {
        _dequeue = new LinkedList<T>();
    }

    public T peekFirst() {
        return _dequeue.peekFirst();
    }

    public T peekLast() {
        return _dequeue.peekLast();
    }

    public boolean isEmpty() {
        return _dequeue.isEmpty();
    }

    public void addFirst(T x) {
        _dequeue.addFirst(x);
    }

    public void addLast(T x) {
        _dequeue.addLast(x);        
    }

    public T removeFirst(T x) {
        return _dequeue.removeFirst();
    }
    
    public T removeLast(T x) {
        return _dequeue.removeLast();
    }

    public T peek() {
        return _dequeue.peek();        
    }

    public boolean add(T x) {
        return _dequeue.add(x);
    }

    public T remove() {
        return _dequeue.remove();
    }

    public int size() {
        return _dequeue.size();
    }
}
