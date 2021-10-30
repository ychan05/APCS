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

  public static void main(String[] args) {
    //helloName test
    System.out.println(helloName("Bob"));
    System.out.println(helloName("Alice"));
    System.out.println(helloName("X"));
    //makeAbba test
    System.out.println(makeAbba("Hi", "Bye"));
    System.out.println(makeAbba("Yo", "Alice"));
    System.out.println(makeAbba("What", "Up"));
  }
}
