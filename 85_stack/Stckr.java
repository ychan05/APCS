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
    Stack cakes = new ALStack();
    //Stack<Z> cakes = new LLStack<Z>();
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    cakes.push("pancake");
    cakes.push(true);
    cakes.push(1);
    cakes.push(2.0);
    System.out.println(cakes.peekTop());
    while (!cakes.isEmpty()) {System.out.println(cakes.pop());}

   

    //...

  }//end main

}//end class
