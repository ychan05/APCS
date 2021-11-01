public class Commafier{
  public static String commafyF(int n){
    String ans = "";
    String strInt = "" + n;

    if (n < 1000){
      ans += n;
    } else {
      for (int i = 0; i < strInt.length(); i ++){
        if ((strInt.length() - i) % 3 == 0){
          ans += ",";
        }
        ans += strInt.substring(i, i + 1);
      }
    }
    return ans;
  }
  public static void main (String[] args){
    System.out.println(commafyF(1));
    System.out.println(commafyF(101));
    System.out.println(commafyF(1000));
    System.out.println(commafyF(12345));
  }
}
