public interface Deque<T> {
    public T peekFirst();

    public T peekLast();

    public boolean isEmpty();

    public void addFirst(T x);

    public void addLast(T x);

    public void removeFirst(T x);

    public void addLast(T x);
}