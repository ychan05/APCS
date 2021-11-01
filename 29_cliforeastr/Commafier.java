public class Commafier{

  public static String commafyF(int n){
    String ans = "";
    String strInt = Integer.toString(n);

    if (strInt.length() < 4){
      ans += n;
    } else {
      for (int i = 0; i < strInt.length(); i ++){
        if ((strInt.length() - i) % 3 == 0 && i != 0){
          ans += ",";
        }
        ans += strInt.substring(i, i + 1);
      }
    }
    return ans;
  }

  public static String commafyR(int n){
    String strInt = Integer.toString(n);
    if (strInt.length() < 4){
      return strInt;
    }
    int newN = Integer.parseInt(strInt.substring(0, strInt.length() - 3));
    return commafyR(newN) + "," + strInt.substring(strInt.length() - 3);
  }
  public static void main (String[] args){
    /* System.out.println(commafyF(1));
    System.out.println(commafyF(101));
    System.out.println(commafyF(1000));
    System.out.println(commafyF(12345));
    System.out.println(commafyF(4598765));
    System.out.println(commafyF(100000000));
    System.out.println("---RECURSIVE TESTING---");
    System.out.println(commafyR(1));
    System.out.println(commafyR(101));
    System.out.println(commafyR(1000));
    System.out.println(commafyR(12345));
    System.out.println(commafyR(4598765));
    System.out.println(commafyR(100000000)); */
    for(String s : args){
      System.out.println("RECURSIVE TEST: " + commafyR(Integer.parseInt(s)) + "\n");
      System.out.println("ITERATIVE TEST: " + commafyR(Integer.parseInt(s)) + "\n");
    }
  }
}
