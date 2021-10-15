/* Quad Puffs: Yat Long Chan, David Deng, Samantha Hua, Lindsay Phung
APCS
HW18 -- CPA-One/Codify bank account
2021-10-14

DISCO
New instances of the class must still be created even if method is in the same class.

QCC
none

Q2: How do you know BEFORE you wrote your own constructor, that Java provides one for you?

A2: A .java file will still compile correctly if you create an instance of a class without having a constructor in said class.

Q3: Describe a test to determine whether Java provides a mean of outping a STRING REPRESENTATION of an OBJECT?

A3: Print the object. */

public class BankAccount {
	private String holderName;
	private String password;
	private int PIN;
	private int accNum;
	private float balance;
	public BankAccount(String n, String p, int pin, int an, float b) {
		setName(n);
		setPass(p);
		setPIN(pin);
		setAccNum(an);
		setBalance(b);

	}
	private void setName (String name) {
		holderName = name;
	}
	private void setPass (String pass) {
		password = pass;
	}
	private void setPIN (int p) {
		PIN = p;
	}
	private void setAccNum (int num) {
		accNum = num;
	}
	private void setBalance (float bal) {
		balance = bal;
	}

	public void printInfo() {
		System.out.println("Full name: " + holderName);
		System.out.println("Account Number: " + accNum);
		System.out.println("Your PIN: " + PIN);
		System.out.println("Password: " + password);
		System.out.println("Balance: $" + balance);
	}

	public void deposit(float deposit) {
		balance += deposit;
		System.out.println("Your deposit was successful!");
		System.out.println("Your new balance is: $" + balance);
	}

	public void withdraw(float withdrawal) {
		balance -= withdrawal;
		System.out.println("Your withdrawal was successful!");
		System.out.println("Your new balance is: $" + balance);
	}

	public static void main(String[] args) {
		BankAccount joseph = new BankAccount("joseph","password", 1234, 123456789, 1000000);	
		joseph.printInfo();
		joseph.deposit(1000000);
		joseph.withdraw(1);
	}
}
