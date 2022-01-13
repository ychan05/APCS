public class Driver{
    public static void main(String[] args){
      Rational r = new Rational(4,5);
      Rational s = new Rational(5,3);
      Rational t = new Rational(10, 25);
      Rational r1 = new Rational(4,5);
      Rational r2 = r;
      Integer i = 2;
      System.out.println(r.compareTo(t)); // +
      System.out.println(r.compareTo(s)); // - 
      //System.out.println(r.compareTo(i)); throw error
      System.out.println(r.equals(t)); // false
      System.out.println(r.equals(i)); // false
      System.out.println(r.equals(r1)); // true 
      System.out.println(r.equals(null)); // false
      System.out.println(r.equals(r2)); // true
    }
  }