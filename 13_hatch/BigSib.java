/*
Chicken Noodle Soup: Yat Long Chan and Courtney Huang
APCS
HW13: Where do BigSibs Come From?
2021-10-06

DISCO
Constructors are a special method used to initialize objects/set initial values for objects. 
Should be the first method in class.
QCC
none
*/

public class BigSib{
	String HelloMsg;
 	
	public BigSib(String s){
		setHelloMsg(s);
	}
	public void setHelloMsg(String msg){
		 HelloMsg = msg;
	}
	public String greet(String name){
		return (HelloMsg + " " +  name);
	}

}
