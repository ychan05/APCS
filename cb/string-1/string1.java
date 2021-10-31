public class string1 {
  //Given a string name, e.g. "Bob", return a greeting of the form "Hello Bob!".
  
  public static String helloName(String name) {
    return ("Hello " + name + "!");
  }

  /* Given two strings, a and b,
  return the result of putting them together in the order abba,
  e.g. "Hi" and "Bye" returns "HiByeByeHi". */
  
  public static String makeAbba(String a, String b) {
    return (a + b + b + a);
  }
  /* The web is built with HTML strings like "<i>Yay</i>" which draws Yay as italic text. 
  In this example, the "i" tag makes <i> and </i> which surround the word "Yay". 
  Given tag and word strings, create the HTML string with tags around the word, e.g. "<i>Yay</i>".
  */
  
  public String makeTags(String tag, String word) {
    return "<" + tag + ">" + word + "</" + tag + ">";
  }

  /* Given an "out" string length 4, such as "<<>>", and a word, 
  return a new string where the word is in the middle of the out string, e.g. "<<word>>". */

  public static String makeOutWord(String out, String word) {
    return out.substring(0, 2) + word + out.substring(2);
  }
  /* Given a string, return a new string made of 3 copies of the last 2 chars of the original string. 
  The string length will be at least 2. */

  public static String extraEnd(String str) {
    String lastChars = str.substring(str.length() - 2);
    return lastChars + lastChars + lastChars;
  }
  
  /*Given a string, return the string made of its first two chars, so the String "Hello" yields "He". 
  If the string is shorter than length 2, return whatever there is */
  
  public static String firstTwo(String str) {
    if (str.length() < 2) {
      return str;
    } else {
      return str.substring(0, 2);
    }
  }

  public static void main(String[] args) {
    //helloName test
    System.out.println(helloName("Bob"));
    System.out.println(helloName("Alice"));
    System.out.println(helloName("X"));
    //makeAbba test
    System.out.println(makeAbba("Hi", "Bye"));
    System.out.println(makeAbba("Yo", "Alice"));
    System.out.println(makeAbba("What", "Up"));
    //makeTags test
    System.out.println(makeTags("i", "Yay"));
    System.out.println(makeTags("i", "Hello"));
    System.out.println(makeTags("cite", "Yay"));
  }
}
