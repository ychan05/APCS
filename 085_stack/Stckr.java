/***
 * class Stckr
 * SKELETON
 * driver/tester for Stack implementations (Linked-list-based, ArrayList-based)
 **/

public class Stckr
{
  public static void main( String[] args )
  {

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    // USAGE: un-comment exactly 1 assignment below
    //Stack<Object> cakes = new ALStack<Object>();
    Stack<Object> cakes = new LLStack<Object>();
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    cakes.push("pancake");
    cakes.push(true);
    cakes.push(1);
    cakes.push(2.0);
    while (!cakes.isEmpty()) {
      System.out.println(cakes.peekTop());
      cakes.pop();
    }
    //...

  }//end main

}//end class
