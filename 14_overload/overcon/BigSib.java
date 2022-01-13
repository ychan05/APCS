/*
Chicken Noodle Soup: Yat Long Chan and Courtney Huang
APCS
HW14: Customize Your Creation
2021-10-07
DISCO
Args can be used in constructor methods so different instances of a class have different initializations.
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
