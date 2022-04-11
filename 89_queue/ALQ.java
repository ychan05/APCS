import java.util.List;
import java.util.ArrayList;

public class ALQ<T> implements Queue<T> {
    
    List<T> _queue;

    public ALQ() {
        _queue = new ArrayList<T>();
    }

    public boolean isEmpty() {
        return _queue.isEmpty();
    }

    public void enqueue(T x) {
        _queue.add(x);
    }

    public T dequeue() {
        T retVal = _queue.get(0);
        _queue.remove(0);
        return retVal;
    }

    public T peekFront() {
        return _queue.get(0);
    }

    public static void main(String[] args) {
        Queue q = new ALQ();
        
        q.enqueue(1);
        q.enqueue("f");
        q.enqueue(2.3);        
        q.enqueue(false);
        q.peekFront();
        while (!q.isEmpty()) {
            System.out.println(q.dequeue());
        }        

    }
}