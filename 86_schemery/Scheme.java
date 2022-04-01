//Under Pressure: Julia Kozak, Anjini Katari, Yat Long Chan
//APCS pd08
//HW86 -- What a Racket
//2022-04-01
//time spent: 0.6hrs

/*
DISCO:
- Writing the code was super ez once we figured out the algo
- closed paren should be popped after unloading

QCC:
- Which Stack implementation would be best?
*/


/***
 * class Scheme
 * Simulates a rudimentary Scheme interpreter
 *
 * ALGORITHM for EVALUATING A SCHEME EXPRESSION:
 *   1. Starting from end of expression. If char is not open paren or operation, push to stack.
 *   2. If char is open paren, operate on operands in stack using matching operation until top of stack is a close paren, 
 *      which is then removed. Push result of operation to stack.
 *   3. Repeat 1 and 2 until entire expression is looked through.
 *   5. Simplified expression should be at the top of the stack.
 *
 * STACK OF CHOICE: LLStack by Under Pressure
 * b/c if ALStack reaches max capacity in the array encapsulated in the AL, an O(n) op is required to expand the capacity.
 *     This doesn't happen with LL and adding nodes to head/tail.
 **/

public class Scheme
{
  /***
   * precond:  Assumes expr is a valid Scheme (prefix) expression,
   *           with whitespace separating all operators, parens, and 
   *           integer operands.
   * postcond: Returns the simplified value of the expression, as a String
   * eg,
   *           evaluate( "( + 4 3 )" ) -> 7
   *	         evaluate( "( + 4 ( * 2 5 ) 3 )" ) -> 17
   **/
  public static String evaluate( String expr )
  {
    Stack<String> numbers = new LLStack<String>();
    String a[] = expr.split("\\s+");
    int op = 0;

    for (int i = a.length - 1; i >= 0; i --) {

      if (a[i].equals("(")) {
        String res = (unload(op, numbers));
        numbers.pop();
        numbers.push(res);
      }

      else if (a[i].equals("+")) {op = 1;}
      else if (a[i].equals("-")) {op = 2;}
      else if (a[i].equals("*")) {op = 3;}
      else {numbers.push(a[i]);}
      
    }
    return numbers.peekTop();
  }//end evaluate()


  /***
   * precond:  Assumes top of input stack is a number.
   * postcond: Performs op on nums until closing paren is seen thru peek().
   *           Returns the result of operating on sequence of operands.
   *           Ops: + is 1, - is 2, * is 3
   **/
  public static String unload( int op, Stack<String> numbers )
  {
    Integer res = Integer.parseInt(numbers.pop());

    while ( !numbers.peekTop().equals(")") ) {
      if (op == 1) {res += Integer.parseInt(numbers.pop());}
      else if (op == 2) {res -= Integer.parseInt(numbers.pop());}
      else {res *= Integer.parseInt(numbers.pop());}
    }
    return Integer.toString(res);
  }//end unload()


  /*
  //optional check-to-see-if-its-a-number helper fxn:
  public static boolean isNumber( String s ) {
    try {
      Integer.parseInt(s);
      return true;
    }
    catch( NumberFormatException e ) {
      return false;
    }
  }
  */


  //main method for testing
  public static void main( String[] args )
  {

    String zoo1 = "( + 4 3 )";
    System.out.println(zoo1);
    System.out.println("zoo1 eval'd: " + evaluate(zoo1) );
    //...7
    
    String zoo2 = "( + 4 ( * 2 5 ) 3 )";
    System.out.println(zoo2);
    System.out.println("zoo2 eval'd: " + evaluate(zoo2) );
    //...17
    
    String zoo3 = "( + 4 ( * 2 5 ) 6 3 ( - 56 50 ) )";
    System.out.println(zoo3);
    System.out.println("zoo3 eval'd: " + evaluate(zoo3) );
    //...29
    
    String zoo4 = "( - 1 2 3 )";
    System.out.println(zoo4);
    System.out.println("zoo4 eval'd: " + evaluate(zoo4) );
    //...-4
    /*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v
      ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/
  }//main()

}//end class Scheme
