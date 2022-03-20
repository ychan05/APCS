public class valmethods{

  public static boolean isDivisible(int n, int m){
    if (n % m == 0){
      return true;
    } else{
      return false;
    }
  }

  public static boolean isTriangle(int s1, int s2, int s3){
    if (s1 > (s2 + s3) || (s2 > (s1 + s3)) || (s3 > (s1 + s2))) {
      return false;
    }
     else {
      return true;
    }
  }

  public static int ack(int m, int n) {
    if (m == 0){
      return (n + 1);
    } else if (m > 0 && n == 0) {
      return ack(m - 1, 1);
    } else if (m > 0 && n > 0) {
      return ack(m - 1, ack(m, n - 1));
    } else {
      return (n + 1);
    }
  }
  public static void main(String[] args){
    System.out.println(isDivisible(4, 2));
    System.out.println(isTriangle(12, 12, 13));
    System.out.print(ack(1,2));
  }
}
