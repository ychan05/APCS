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
  private int numerator;
  private int denominator;

  public String toString(){
    return numerator + "/" + denominator;
  }

  public Rational(){
    numerator=0;
    denominator=1;
  }

  public Rational(int x, int y){
    numerator = x;
    denominator = y;
  }

  public double floatVal(){
    return (double)numerator/denominator;
  }

  public int getNum(){
    return numerator;
  }

  public int getDen(){
    return denominator;
  }

  public void multiply(Rational n){
    this.numerator *= n.getNum();
    this.denominator *= n.getDen();
  }

  public void divide(Rational n){
    this.numerator *= n.getDen();
    this.denominator *= n.getNum();
  }

  public static void main(String[] args){
    Rational r = new Rational(4,5);
    Rational s = new Rational(1,3);
    System.out.println(r.toString());
    System.out.println(s.toString());
    System.out.println(r.floatVal());
    System.out.println(s.floatVal());
    r.multiply(s);
    System.out.println(r.toString());
    r.divide(s);
    System.out.println(r.toString());
  }
}
