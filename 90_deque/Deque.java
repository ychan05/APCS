public interface Deque<T> {
    public T peekFirst();

    public T peekLast();

    public boolean isEmpty();

    public void addFirst(T x);

    public void addLast(T x);

    public T removeFirst(T x);

    public T removeLast(T x);

    public T peek();

    public T remove();

    public T add();

    public int size();
}