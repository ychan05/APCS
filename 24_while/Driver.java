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
  public static void loop(Coin c1, Coin c2, int x, int y, int birthyear){
     int matchCtr = 0;
     boolean start = true;
     int headsCt = c1.getHeadsCtr() + c2.getHeadsCtr();
     int flips = 0;
     while (start)
     {
	if ((matchCtr > 65536) && (matchCtr % birthyear == 0) && headsCt >= x && matchCtr >= y){
	 start = false;
	}
        c1.flip();
        c2.flip();
	if (c1.equals(c2)){
         matchCtr += 1;
	}
	headsCt = c1.getHeadsCtr() + c2.getHeadsCtr();     
	flips += 1;
     }
    System.out.println("It took " + flips + " flips for all conditions to be fullfilled.");
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
     loop(coin1, coin2, 70000, 69000, 2005);
  }//end main()

}//end class
