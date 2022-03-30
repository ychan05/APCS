import java.util.LinkedList;

public class LLStack<PANCAKE> implements Stack<PANCAKE> {
    private LinkedList<PANCAKE> _stack = new LinkedList<PANCAKE>();
    private int _stackSize = 0;

    public boolean isEmpty() {
        return _stackSize == 0;
    }

    public PANCAKE peekTop() {
        return _stack.get(_stackSize - 1);
    }
    
    public PANCAKE pop() {
        PANCAKE ret = _stack.get(_stackSize - 1);
        _stack.remove(_stackSize - 1);
        _stackSize = _stack.size();
        return ret;
    }
    
    public void push(PANCAKE x) {
        _stack.add(x);        
        _stackSize = _stack.size();
    }
}
