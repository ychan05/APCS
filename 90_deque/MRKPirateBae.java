import java.util.Iterator;

public class MRKPirateBae {
   public static void main(String[] args) {
       Deque<Object> dq = new LLDeque<Object>();

       dq.add("x");
       dq.addFirst(1);
       dq.addLast(4.4);
       System.out.println("Testing remove (1, then 4.4)");
       System.out.println(dq.removeFirst());
       System.out.println(dq.removeLast());
       System.out.println("Testing peek (should all be 'x')");
       System.out.println(dq.peek());
       System.out.println(dq.peekFirst());
       System.out.println(dq.peekLast());

       for (int i = 0; i < 6; i ++) {
           dq.add(i);
       }

       System.out.println("Test iterator");
       Iterator<Object> it = dq.iterator();

       while (it.hasNext()) {
           System.out.println(it.next());
           it.remove();
       }


       for (int i = 0; i < 6; i ++) {
           dq.add(i);
        }

       System.out.println("Test FOREACH");
       
       for (Object o : dq) {
           System.out.println(o);
       }
   } 
}
