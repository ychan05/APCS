/*
  Yat Long Chan, Lawrence Joa, Joshua Gao.
  APCS pd7
  HW42 -- Be More Rational -- Creating more methods for rational numbers
  2021-12-02
  Time spent: 0.5 hours (class time)
  DISCOs
  nothing new
  QCCs
  none
*/

public class Rational{
  private int numerator;
  private int denominator;


  public static int gcd(int x, int y){
    while (x != y){
      if (x > y){
        x -= y;
      } else {
        y -= x;
      }
    }
    return x;
  }

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

  public double floatValue(){
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

  public int gcd(){
    int n = this.numerator;
    int d = this.denominator;
    return gcd(n,d);
  }

  public void add(Rational r){
     this.numerator = (this.numerator * r.denominator) + (r.numerator * this.denominator);
     this.denominator = this.denominator * r.denominator;
  }

  public void subtract(Rational r){
     this.numerator = (this.numerator * r.denominator) - (r.numerator * this.denominator);
     this.denominator = this.denominator * r.denominator;
  }

  public void reduce(){
    int tempGCD = gcd();
     this.numerator = this.numerator / tempGCD;
     this.denominator = this.denominator / tempGCD;
  }

  public int compareTo(Rational r){
    int greater = 0;
     if (this.floatValue() > r.floatValue()){
      greater = 1;
    } else if (this.floatValue() > r.floatValue()){
      greater = -1;
    }
    return greater;
  }
  public static void main(String[] args){
    Rational r = new Rational(4,5);
    Rational s = new Rational(1,3);
    Rational t = new Rational(10, 25);
    System.out.println("=====TEST toString()=====");
    System.out.println(r.toString());
    System.out.println(s.toString());
    System.out.println(t.toString());
    r.add(s);
    System.out.println(r.toString());
    t.reduce();
    System.out.println(t.toString());
    System.out.println(r.compareTo(t));
    /*
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
    System.out.println(t.gcd()); */
  }
}
