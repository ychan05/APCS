//Under Pressure: Julia Kozak, Anjini Katari, Yat Long Chan
//APCS pd08
//HW87 -- The English Do Not Wait In Line for Soup
//2022-04-04
//time spent: 0.4 hours

/*
DISCO:
- Using an inner class means we can directly access cargo and next
- When enqueue-ing an empty Queue, we have to account for _head pointing to null from previous dequeue

QCC:
none
*/

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
    private int _size;

    public NodeQueue() {
        _head = new Node(null, null);
        _size = 0;
    }

    // add element
    public void enqueue(T x) {
        if (_head == null) {
            _head = new Node(x, null);
        }
        else if (isEmpty()) {
            _head.cargo = x;
        }
        else if (_size == 1) {
            _head.next = new Node(x, null);
        }
        else {
            Node ptr = _head;
            while (ptr.next != null)
                ptr = ptr.next;
            ptr.next = new Node(x, null);
        }
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
        q.enqueue(2);
        System.out.println(q.peekFront());

    }
}
