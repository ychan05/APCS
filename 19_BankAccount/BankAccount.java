/*
Quad Puffs -- David Deng / Yat long Chan / Samantha Hua / Lindsay Phung
APCS
HW19 -- Mo Money Mo Problems ...MORE AWESOME / add conditionals to BankAccount
2021-10-14
DISCO
- 
QCC
- 
*/

public class BankAccount {
  private String holderName;
  private String password;
  private short PIN;
  private int accNum;
  private double balance;

  public void setName(String name) {
    holderName = name;
  }
  public void setPass(String pass) {
    password = pass;
  }
  public void setPIN(short p) {
    if (p >= 1000 && p <= 9998) {
      PIN = p;
    } else {
      PIN = 9999;
      System.out.println("You PIN is invalid. Please set a 4 digit number less than 9999");
    }
  }
  public void setAccNum(int num) {
    if (num >= 100000000 && num <= 999999998) {
      accNum = num;
    } else {
      accNum = 999999999;
      System.out.println("You account number is invalid. Please set a 9 digit number less than 999999999");
    }
  }
  public void setBalance(double bal) {
    balance = bal;
  }

  public String toString() {
    String infoStr = "\nAccount info:\n=======================";
    infoStr = infoStr + "\nName: " + holderName;
    infoStr = infoStr + "\nPassword: " + password;
    infoStr = infoStr + "\nPIN: " + PIN;
    infoStr = infoStr + "\nAccount Number: " + accNum;
    infoStr = infoStr + "\nBalance: " + balance;
    infoStr = infoStr + "\n=======================";
    return infoStr;
  }
  public void deposit(double deposit) {
    balance += deposit;
    System.out.println("Your deposit was successful!");
    System.out.println("Your new balance is: $" + balance);
  }

  public boolean withdraw(double withdrawal) {
    if (withdrawal > balance) {
      return false;
    } else {
      balance -= withdrawal;
      System.out.println("Your withdrawal was successful!");
      System.out.println("Your new balance is: $" + balance);
      return true;
    }
  }

  public boolean authenticate(int authAccNum, String authPass) {
    if (authAccNum != accNum && authPass != password) {
      return false;
    } else if (authPass != password) {
      return false;
    } else if (authAccNum != accNum) {
      return false;
    } else {
      return true;
    }
  }
  public static void main(String[] args) {
    BankAccount outOfBounds = new BankAccount();
    outOfBounds.setName("Out Bounds");
    outOfBounds.setPass("uh oh");
    outOfBounds.setAccNum(100); // out of bounds accNum
    outOfBounds.setPIN((short) 1); //out of bounds PIN
    outOfBounds.setBalance(10.00);
    
    System.out.println(outOfBounds.toString()); // check if PIN and accNum set properly
  
    BankAccount joseph = new BankAccount();
    joseph.setName("Joseph");
    joseph.setPass("password");
    joseph.setAccNum(123456789); 
    joseph.setPIN((short) 1234);
    joseph.setBalance(1000000);
    System.out.println(joseph.toString());
    System.out.println("withdrawTest, over balance (ret false): " + joseph.withdraw(1000001)); // over balance - should print false
    System.out.println(joseph.withdraw(1)); //within balance - should print statement and true
    joseph.deposit(1000000);
    System.out.println("authTest, incorrect pass and accNum (ret false): " + joseph.authenticate(123456780, "pass")); // incorrect pass and accNum - should print false
    System.out.println("authTest, incorrect accNum (ret false): " + joseph.authenticate(123456780, "password")); // incorrect accNum, correct pass - should print false
    System.out.println("authTest, incorrect pass (ret false) " + joseph.authenticate(123456789, "pass")); // incorrect pass, correct accNum - should print false
    System.out.println("authTest, correct pass and accNum (ret true): " + joseph.authenticate(123456789, "password")); // both correct - should print true
  }

}
