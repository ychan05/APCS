/*
  Yat Long Chan, Lawrence Joa, Joshua Gao.
  APCS pd7
  HW42 -- Rational Standards Compliance -- equals() and compareTo()
  2021-12-21
  Time spent: 0.5 hours + class time
  DISCOs
   - Use cross product to compare two rationals as they are exact values.
   - Floating point value will not be as acurate as it is an approximation.  
  QCCs
  none
*/

public class Rational implements Comparable{
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
      while (n != d){
        if (n > d){
          n -= d;
        } else {
          d -= n;
        }
      }
      return n;
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
  
    public int compareTo(Object other){
      if (other instanceof Rational) {
        Rational r = (Rational) other;
        //use cross multiplication
        return (this.numerator * r.denominator) - (this.denominator * r.numerator);
      }
      throw new ClassCastException("\n CompareTo() input not a Rational");
    }
  
    public boolean equals(Object other) {
      if (other instanceof Rational) {
        Rational r = (Rational) other;
        // check if values are equal
        return this.compareTo(r) == 0;
      }
      return false;
    }
  }
  
  