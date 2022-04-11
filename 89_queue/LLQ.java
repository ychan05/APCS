import java.util.List;
import java.util.LinkedList;

public class LLQ<T> implements Queue<T> {
    List<T> _queue;

    public LLQ() {
        _queue = new LinkedList<T>();
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
}
