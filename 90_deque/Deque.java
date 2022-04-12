//Under Pressure: Julia Kozak, Yat Long Chan, Anjini Katari
//APCS pd08
//HW90 - Swabbing the Deque
//2022-04-11M
//time spent: 0.4 hours

public interface Deque<T> {
    
    public T peekFirst();

    public T peekLast();

    public boolean isEmpty();

    public void addFirst(T x);

    public void addLast(T x);

    public T removeFirst();

    public T removeLast();

    public T peek();

    public T remove();

    public boolean add(T x);

    public int size();
}