public class NodeQueue<T> implements Queue<T> {
    Node<T> _head;
    int _size = 0;

    public NodeQueue() {
        _head = new Node<T>(null, null);
    }
 
    public void enqueue(T x) {
        if (isEmpty()) {
            _head.setCargo(x);
            _size ++;
            return;
        }

        if (_size == 1) {
            _head.setNext( new Node<T>(x, null) );
            _size ++;
            return;
        }

        Node<T> ptr = _head;
        while (ptr.getNext() != null) {
            ptr = ptr.getNext();
        }
        ptr.setNext( new Node<T>(x, null) );
        _size ++;
    }

    public T dequeue() {
        if (isEmpty()) return null;
        T ret = _head.getCargo();
        _head = _head.getNext();
        _size --;
        return ret;
    }

    public boolean isEmpty() {
        return _size == 0;
    }

    public T peekFront() {
        if (isEmpty()) return null;
        return _head.getCargo();
    }

    public static void main(String[] args) {
        Queue<Object> q = new NodeQueue<Object>();
        q.enqueue(1);
        q.enqueue("hi");
        q.enqueue(true);
        q.enqueue(2.0);
        
        while(!q.isEmpty()) {
            System.out.println(q.peekFront());
            q.dequeue();
        }

        q.dequeue();
        System.out.println(q.peekFront());


    }
}
