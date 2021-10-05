/*
BDY: Yat Long Chan, Ben Belotser, David Chen, Eugene, Bob, TwoFace
APCS
HW10: Refactor Big Sib One
2021-10-05


DISCOVERIES
Instance vars can only be used in non static methods.
UNRESOLVED QUESTIONS
none
*/

public class Greet {
	public static void main( String[] args ) {
    		String greeting;

    		BigSib freshie = new BigSib();
    		freshie.setHelloMsg("Word up");

    		greeting = freshie.greet("freshman");
    		System.out.println(greeting);
		
		BigSib spaceman = new BigSib();
		spaceman.setHelloMsg("Salutations");

		greeting = spaceman.greet("Dr. Spaceman");
		System.out.println(greeting);

		BigSib kong = new BigSib();
		kong.setHelloMsg("Hey ya");

		greeting = kong.greet("Kong Fooey");
		System.out.println(greeting);

		BigSib mother = new BigSib();
		mother.setHelloMsg("Sup");

		greeting = mother.greet("mom");
		System.out.println(greeting);
  }
} 
