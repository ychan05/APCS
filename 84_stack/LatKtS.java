// Under Pressure: Julia Kozak, Yat Long Chan, Anjini Katari
// APCS pd08
// HW84 -- Stack: What Is It Good For?
// 2022-03-30
// time spent: 0.5 hours

/*
DISCO:
- open paren is removed from stack only if a matching closing paren is found

QCC:
- adding a peek() method to Latkes will help avoid having to push popped element back when "peeking"
- allMatched() can't simply return true after iteration b/c extra parens can be in the stack

/***
 * class LatKtS
 * SKELETON
 * driver class for Latkes
 * Uses a stack to reverse a text string, check for sets of matching parens.
 **/

public class LatKtS
{

  /***
   * precondition:  input string has length > 0
   * postcondition: returns reversed string s
   *                flip("desserts") -> "stressed"
   **/
  public static String flip( String s )
  {
    Latkes stack = new Latkes(s.length());
    for (int i = 0; i < s.length(); i ++) {
      stack.push(s.substring(i, i +1));
    }
    String ret = stack.pop();
    while (!stack.isEmpty()) ret += stack.pop();
    return ret;
  }


  /***
   * precondition:  s contains only the characters {,},(,),[,]
   * postcondition: allMatched( "({}[()])" )    -> true
   *                allMatched( "([)]" )        -> false
   *                allMatched( "" )            -> true
   **/
  public static boolean allMatched( String s )
  {
    if (s.isEmpty()) return true; //no parens, return true
    Latkes stack = new Latkes(s.length());
    for (int i = 0; i < s.length(); i++) {
      String current = s.substring(i, i + 1);

      if (current.equals("(") || current.equals("[") || current.equals("{")) {
          stack.push(current);
      } else {
        if (stack.isEmpty()) return false; //no open parens, return false
        
        //"peek"
        String top = stack.pop();
        stack.push(top); 

        //if open and closed dont match, return false
        if ( (current.equals(")") && !top.equals("(")) 
            || (current.equals("]") && !top.equals("[")) 
            || (current.equals("}") && !top.equals("{"))){
          return false;
        } else {stack.pop();} //match, remove open paren from stack
      }
  }
  return stack.isEmpty(); //if no open parens left, all match
}


  //main method to test
  public static void main( String[] args )
  {
    System.out.println(flip("stressed"));
    System.out.println(allMatched( "({}[()])" )); //true
    System.out.println(allMatched( "([)]" ) ); //false
    System.out.println(allMatched( "(){([])}" ) ); //true
    System.out.println(allMatched( "](){([])}" ) ); //false
    System.out.println(allMatched( "(){([])}(" ) ); //false
    System.out.println(allMatched( "()[[]]{{{{((([])))}}}}" ) ); //true
    /*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v
      ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/
  }

}//end class
