/**
 *TNPG: DIY (David Deng, Yat Long Chan)
 *APCS
 *HW24 -- Get It While You Can / Using while loops with class Coin.
 *2021-10-25
 *Time Spent: 0.5 hrs
 *
 *DISCO
 *this() is used to call a constructor within the current object.
 *QCC
 *No unresolved questions.
 **/

public class Driver {
  // flip until x heads have come up
  public static void headCount(Coin c1,Coin c2, int max){
     int headsCt = c1.getHeadsCtr() + c2.getHeadsCtr();
     int flips = 0;
     while (headsCt < max)
     {
	c1.flip();
	c2.flip();
        headsCt = c1.getHeadsCtr() + c2.getHeadsCtr();
	flips += 1;
     }
    System.out.println("It took " + flips + " flips for " + max + " heads to come up.");
  }
  
  //flip until y matches have occurred
  public static void matchCount(Coin c1, Coin c2, int matches){
     int matchCtr = 0;
     int flips = 0;
     while (matchCtr < matches)
     {
        c1.flip();
        c2.flip();
	if (c1.equals(c2)){
         matchCtr += 1;
	}
	flips += 1;
     }
    System.out.println("It took " + flips + " flips for " + matchCtr + " matches to occur.");
  }

//flip until at least 65536 matches have come up, and the number of matches is divisible by the year of your birth.
 public static void yearMatch(Coin c1, Coin c2, int birthyear){
  int matchCtr = 0;
  int flips = 0;
  while (matchCtr < 65536){
        c1.flip();
        c2.flip();
	if (c1.equals(c2)){
         matchCtr += 1;
	}
	flips += 1;
  }
  while (matchCtr % birthyear != 0){
        c1.flip();
        c2.flip();
	if (c1.equals(c2)){
         matchCtr += 1;
	}
	flips += 1;
 }
    System.out.println("It took " + flips + " flips for the # of matches to be greater than 65536 and divisible by " + birthyear);
 }

  public static void main( String[] args ) {
 /*===================TOP==========================
    //build Objects from blueprint specified by class Coin
    //test default constructor
      Coin mine = new Coin();
      //test 1st overloaded constructor
      Coin yours = new Coin( "quarter" );
      //test 2nd overloaded constructor
      Coin wayne = new Coin( "dollar", "heads" );
      //test toString() methods of each Coin
      System.out.println("mine: " + mine);
      System.out.println("yours: " + yours);
      System.out.println("wayne: " + wayne);
      //test flip() method
      System.out.println("\nAfter flipping...");
      yours.flip();
      wayne.flip();
      System.out.println("yours: " + yours);
      System.out.println("wayne: " + wayne);
      //test equals() method
      if ( yours.equals(wayne) ) {
        System.out.println( "Matchee matchee!" );
      }
      else {
        System.out.println( "No match. Firestarter you can not be." );
      }
      ====================BOTTOM======================*/
     Coin coin1 = new Coin("penny", "heads");
     Coin coin2 = new Coin("quarter", "heads");
     headCount(coin1, coin2, 10);
     matchCount(coin1, coin2, 10);
     yearMatch(coin1, coin2, 2005);
  }//end main()

}//end class
