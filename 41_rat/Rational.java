/*
  Yat Long Chan, Lawrence Joa, Joshua Gao.
  APCS pd7
  HW41 -- Be Rational -- Creating methods for rational numbers
  2021-12-01
  Time spent: 0.3 hours (class time)
  DISCOs
  nothing new
  QCCs
  none
*/

public class Rational{
  protected int numerator;
  protected int denominator;

  public String toString(){
    return numerator + "/" + denominator;
  }

  public Rational(){
    numerator=0;
    denominator=1;
  }

  public Rational(int x, int y){
    this();
    if (y == 0){
      System.out.println("ERROR: denominator cannot be 0");
    } else {
      numerator = x;
      denominator = y;
    }
  }

  public double floatVal(){
    return (double)numerator/denominator;
  }

  public void multiply(Rational n){
    this.numerator *= n.numerator;
    this.denominator *= n.denominator;
  }

  public void divide(Rational n){
    if (n.numerator == 0){
      System.out.println("ERROR: Dividing by 0");
    } else {
      this.numerator *= n.denominator;
      this.denominator *= n.numerator;
    }
  }

  public static void main(String[] args){
    Rational r = new Rational(4,5);
    Rational s = new Rational(1,3);
    Rational t = new Rational();
    System.out.println("=====TEST toString()=====");
    System.out.println(r.toString());
    System.out.println(s.toString());
    System.out.println(t.toString());
    System.out.println("=====TEST FLOATING POINT CONVERSION=====");
    System.out.println(r.floatVal());
    System.out.println(s.floatVal());
    System.out.println("=====TEST multiply()=====");
    r.multiply(s);
    System.out.println(r.toString());
    System.out.println("=====TEST divide()=====");
    r.divide(s);
    System.out.println(r.toString());
    r.divide(t);
    System.out.println(r.toString());
  }
}
