/*
RAINBOW DRAGON: Yat Long Chan, Lawrence Joa, Faiyaz Rafee
APCS
HW 27 -- FOR the Love of Strings // Recursive and for loop for reversing and fence methods
2021-10-28
time spent: 0.5 hours
DISCO
You have to be careful about where you are changing the counter values.
QCC
Are there situations where we must use forloop instead of recursion or vice versa?
*/

public class Rof {
  public static String fenceF(int posts){
    String fence = "|";

    for(int i = 1; i < posts; i++){
      fence = fence + "--|";
    }
    return fence;
  }

  public static String reverseF(String s){
    String a = "";
    for(int i=s.length()-1; i>=0; i--){
      a += s.substring(i);
      s = s.substring(0,i);
    }
    return a;
  }

  public static String reverseR(String s){
    String a = "";
    int length = s.length();
    if(s.length()==1){
      a += s;
      return a;
    }
    a += s.substring(length - 1);
    return a + reverseR(s.substring(0, length - 1));
  }

  public static void main( String [] args) {
    System.out.println(fenceF(5));
    System.out.println(reverseF("stressed"));
    System.out.println(reverseR("stressed"));
  }
}
