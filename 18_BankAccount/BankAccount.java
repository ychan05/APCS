/* Quad Puffs: Yat Long Chan, David Deng, Samantha Hua, Lindsay Phung
APCS
HW18 -- CPA-One/Codify bank account
2021-10-14

DISCO
New instances of the class must still be created even if method is in the same class.

QCC
none

Q2: How do you know BEFORE you wrote your own constructor, that Java provides one for you?

A2: We know that Java provides a default constructor because when we initialized variables without explicitly stating a constructor, the program still ran without error.

Q3: Describe a test to determine whether Java provides a mean of outping a STRING REPRESENTATION of an OBJECT?

A3: Create a method that returns said object and expects String. If there is no error, it means Java converted the object to a String. */

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
