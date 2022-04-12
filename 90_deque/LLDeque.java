//Under Pressure: Julia Kozak, Yat Long Chan, Anjini Katari
//APCS pd08
//HW90 - Swabbing the Deque
//2022-04-11M
//time spent: 0.4 hours


import java.util.LinkedList;

public class LLDeque<T> implements Deque<T> {
    private LinkedList<T> _dequeue;

    public LLDeque() {
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

    public T removeFirst() {
        return _dequeue.removeFirst();
    }
    
    public T removeLast() {
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

    public static void main(String[] args) {
        Deque dq = new LLDeque();
        dq.add("x");
        dq.addFirst(1);
        dq.addLast(2.3);
        System.out.println(dq.peekFirst()); // 1
        System.out.println(dq.peek()); // 1
        System.out.println(dq.peekLast()); // 2.3
        System.out.println(dq.removeLast()); // 2.3

        while (!dq.isEmpty()) {
            System.out.println(dq.removeFirst()); // 1 x 
        }

        // System.out.println(dq.remove()); //exception

    }
}
