/*
Chicken Noodle Soup: Yat Long Chan and Courtney Huang
APCS
HW13: Where do BigSibs Come From?
2021-10-06

DISCO
Constructors are a special method used to initialize objects/set initial values for objects. 
Should be the first method in class.
QCC
none
*/


public class Greet {
	public static void main( String[] args ) {
    		String greeting;

    		BigSib richard = new BigSib("Word up");
		
    		greeting = richard.greet("freshman");
    		System.out.println(greeting);
		
		BigSib spaceman = new BigSib("Salutations");

		greeting = spaceman.greet("Dr. Spaceman");
		System.out.println(greeting);

		BigSib kong = new BigSib("Hey ya");

		greeting = kong.greet("Kong Fooey");
		System.out.println(greeting);

		BigSib mother = new BigSib("Sup");

		greeting = mother.greet("mom");
		System.out.println(greeting);
  }
} 
