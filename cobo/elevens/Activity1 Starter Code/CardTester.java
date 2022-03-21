//Lobsters -- Yat Long Chan, Weichen Liu, Hamim Seam

/**
 * This is a class that tests the Card class.
 */
public class CardTester {

	/**
	 * The main method in this class checks the Card operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		Card bob = new Card("seven", "diamond", 7);
		Card ted = new Card("seven", "diamond", 7);
		Card jef = new Card("eight", "spade", 8);

		System.out.println("Testing accessors...");

		System.out.println(bob.suit());
		System.out.println(bob.rank());
		System.out.println(bob.pointValue());
		System.out.println(ted.suit());
		System.out.println(ted.rank());
		System.out.println(ted.pointValue());
		System.out.println(jef.suit());
		System.out.println(jef.rank());
		System.out.println(jef.pointValue());

		System.out.println("Testing matches...");
		System.out.println(bob.matches(ted));
		System.out.println(bob.matches(jef));


	}
}
