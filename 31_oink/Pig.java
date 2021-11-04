/***
 * QUAD PUFFS - Yat Long Chan, Samantha Hua, Lindsay Phung, David Deng
 * APCS
 * HW31 -- Otnay Ybay ethay Airhay Onway Ymay Inneechay Inchay Inchay
 * 2021-11-03
 * time spent: 0.2 hrs
 * DISCO
 * The keyword final indicates that the variable can no longer be changed.
 *
 * QCC
 * No questions unresolved
 *
 * class Pig
 * a Pig Latin translator
 * ~~~~~~~~~~~~~~~~~~~ SKELETON ~~~~~~~~~~~~~~~~~~~
 *           9
 *     ,--.-'-,--.
 *     \  /-~-\  /
 *    / )' a a `( \
 *   ( (  ,---.  ) )
 *    \ `(_o_o_)' /
 *     \   `-'   /
 *      | |---| |
 *      [_]   [_]
 *      PROTIP: Make this class compilable first,
 *      then develop and test one method at a time.
 *      NEVER STRAY TOO FAR FROM COMPILABILITY/RUNNABILITY!
 ***/

public class Pig{
  //Q: How does this initialization make your life easier?
  private static final String VOWELS = "aeiou";


  /*=====================================
    boolean hasA(String,String) -- checks for a letter in a String
    pre:  w != null, letter.length() == 1
    post: hasA("cat", "a") -> true
    hasA("cat", "p")       -> false
    =====================================*/
  public static boolean hasA( String w, String letter ){
    return (w.indexOf(letter) != -1);
  }//end hasA()


  /*=====================================
    boolean isAVowel(String) -- tells whether a letter is a vowel
    precondition: letter.length() == 1
    =====================================*/
  public static boolean isAVowel( String letter ){
    return (hasA(VOWELS, letter));
  }


  /*=====================================
    int countVowels(String) -- counts vowels in a String
    pre:  w != null
    post: countVowels("meatball") -> 3
    =====================================*/
  public static int countVowels( String w ){
    int count = 0;
    for(int i = 0; i < w.length(); i++){
      if(isAVowel(w.substring(i, i + 1))){
        count ++;
      }
    }
    return count;
  }


  /*=====================================
    boolean hasAVowel(String) -- tells whether a String has a vowel
    pre:  w != null
    post: hasAVowel("cat") -> true
    hasAVowel("zzz")       -> false
    =====================================*/
  public static boolean hasAVowel( String w ){
      for (int i = 0; i < w.length(); i ++){
        if (isAVowel(w.substring(i, i + 1))){
          return true;
        }
      }
     return false;
  }


  /*=====================================
    String allVowels(String) -- returns vowels in a String
    pre:  w != null
    post: allVowels("meatball") -> "eaa"
    =====================================*/
  public static String allVowels( String w ){
    String ans = "";
      for (int i = 0; i < w.length(); i ++){
        if (isAVowel(w.substring(i, i + 1))){
          ans += w.substring(i, i + 1);
        }
      }
    return ans;
  }

  public static void main( String[] args ){
    System.out.println(hasA("cat", "a"));
    System.out.println(hasA("cat", "p"));
    System.out.println(isAVowel("c"));
    System.out.println(isAVowel("a"));
    System.out.println(countVowels("meetbaall"));
    System.out.println(countVowels("meatball"));
    System.out.println(hasAVowel("cat"));
    System.out.println(hasAVowel("zzz"));
    System.out.println(allVowels("meatball"));
    System.out.println(allVowels("meetbaall"));
  }//end main()

}//end class Pig
