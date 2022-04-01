public class NodeQueue<T> implements Queue<T> {
    LLNode<T> _node;
    int _size = 0;

    public NodeQueue() {
        _node = new LLNode<T>(null, null);
    }
 
    public void enqueue(T x) {
        if (_size == 0) {
            _node.setCargo(x);
            _size ++;
            return;
        }

        if (_size == 1) {
            _node.setNext( new LLNode<T>(x, null) );
            _size ++;
            return;
        }

        LLNode<T> head = _node;
        while (head.getNext() != null) {
            head = head.getNext();
        }
        head.setNext( new LLNode<T>(x, null) );
        _size ++;
    }

    public T dequeue() {
        
    }
}
