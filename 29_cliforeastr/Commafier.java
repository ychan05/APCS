public class Commafier{

  public static String commafyF(int n){
    String ans = "";
    String strInt = "" + n;

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

  //doesnt work with zeros currently.
  public static String commafyR(int n){
    String strInt = "" + n;
    if (strInt.length() < 4){
      return strInt;
    } else if (strInt.length() % 3 == 0){
      String restNum = strInt.substring(3);
      return strInt.substring(0, 3) + "," + commafyR(Integer.parseInt(restNum));
    } else{
      String restNum = strInt.substring((strInt.length() % 3));
      return strInt.substring(0, (strInt.length() % 3)) + "," + commafyR(Integer.parseInt(restNum));
    }
  }
  public static void main (String[] args){
    System.out.println(commafyF(1));
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
    System.out.println(commafyR(100000000));
  }
}
