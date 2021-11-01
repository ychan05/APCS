public class Commafier{
  public static String commafyF(int n){
    String ans = "";
    int reversed = 0;
    int temp = n;

    if (n < 1000){
      ans += n;
    } else {
      //do stuff, not sure what
    }
    return ans;
  }
  public static void main (String[] args){
    System.out.println(commafyF(1));
    System.out.println(commafyF(101));
    System.out.println(commafyF(1000));
  }
}
