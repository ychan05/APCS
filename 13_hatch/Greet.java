/*
Chicken Noodle Soup: Yat Long Chan and Courtney Huang
APCS
HW13: Where do BigSibs Come From?
2021-10-06

DISCO
Constructors are used to initialize objects/set initial values for objects.
QCC
none
*/

public class Greet {
	public static void main( String[] args ) {
    		String greeting;

    		BigSib richard = new BigSib();

    		greeting = richard.greet("freshman");
    		System.out.println(greeting);
  }
} 
