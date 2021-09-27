public class Loops {
  public static double Power(double x, int n){
    double ans = 1;
    for(int i = 0; i < n; i ++){
      ans *= x;
    }
    return ans;
  }

  public static int factorial(int n) {
    int ans = 1;
    while(n > 1){
      ans *= n;
      n -= 1;
    }
    return ans;
  }

  public static double myexp(double x, int n){
    double ans = 1;
    double numerator = 1;
    for (int i = 1; i < n; i ++){
      ans += (numerator *= x) / (factorial(i));
    }
    return ans;
  }

  public static void check(double x){
      int i = 28;

      System.out.println(x+"\t"+myexp(x, i)+"\t"+Math.exp(x));
   }

  public static void main(String[] args){
    System.out.println(Power(2.0, 8));
    System.out.println(factorial(5));

   // for (double i=0.1; i<=100; i*=10){
    //  check(i);
  // }

   for(double i = -0.1; i >= -100; i *= 10){
     check(i); 
   }
  }
}
