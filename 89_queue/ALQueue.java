//Under Pressure: Julia Kozak, Yat Long Chan, Anjini Katari
//APCS pd08
//HW89 -- Queue Two Ways
//2022-04-11M
//time spent: 0.4 hours

/*
DISCO
- Implementations for both AL and LLQ are the same but time complexities are different

QCC
- Would it be better to make the var type LinkedList so that we can use addLast and removeFirst? 
*/

import java.util.List;
import java.util.ArrayList;

public class ALQueue<T> implements Queue<T> {
    List<T> _queue;

    public ALQueue() {
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
        Queue q = new ALQueue();
        
        q.enqueue(1);
        q.enqueue("f");
        q.enqueue(2.3);        
        q.enqueue(false);
        System.out.println(q.peekFront());

        while (!q.isEmpty()) {
            System.out.println(q.dequeue());
        }        

    }
}