public class NodeQueue<T> implements Queue<T> {
    
    // inner class Node()
    private class Node {
        private T cargo;
        private Node next;

        public Node(T value, Node next) {
            cargo = value;
            this.next = next;
        }
    } // End inner class Node()

    private Node _head;
    private int _size = 0;

    public NodeQueue() {
        _head = new Node(null, null);
    }

    // add element
    public void enqueue(T x) {
        if (isEmpty()) {
            _head.cargo = (x);
            _size++;
            return;
        }

        if (_size == 1) {
            _head.next = new Node(x, null);
            _size++;
            return;
        }

        Node ptr = _head;
        while (ptr.next != null) {
            ptr = ptr.next;
        }
        ptr.next = new Node(x, null);
        _size++;
    }

    // remove element
    public T dequeue() {
        if (isEmpty())
            return null;
        T ret = _head.cargo;
        _head = _head.next;
        _size--;
        return ret;
    }

    // chk for emptiness
    public boolean isEmpty() {
        return _size == 0;
    }

    // get element at front
    public T peekFront() {
        if (isEmpty())
            return null;
        return _head.cargo;
    }


    public static void main(String[] args) {
        Queue<Object> q = new NodeQueue<Object>();
        q.enqueue(1);
        q.enqueue("hi");
        q.enqueue(true);
        q.enqueue(2.0);

        while (!q.isEmpty()) {
            System.out.println(q.peekFront());
            q.dequeue();
        }

        q.dequeue();
        System.out.println(q.peekFront());
    }
}
