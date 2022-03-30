import java.util.ArrayList;

public class ALStack<PANCAKE> implements Stack<PANCAKE>{
    private ArrayList<PANCAKE> _stack = new ArrayList<PANCAKE>();

    public boolean isEmpty() {
        return _stack.size() == 0;
    }

    public PANCAKE peekTop() {
        return _stack.get(_stack.size() - 1);
    }
    
    public PANCAKE pop() {
        PANCAKE ret = _stack.get(_stack.size() - 1);
        _stack.remove(_stack.size() - 1);
        return ret;
    }

    public void push(PANCAKE x) {
        _stack.add(x);        
    }
}
