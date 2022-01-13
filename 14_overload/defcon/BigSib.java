/*
Chicken Noodle Soup: Yat Long Chan and Courtney Huang
APCS
HW14: Customize Your Creation
2021-10-07
DISCO
If a constructor has no args, all instances of a class will have the same initialization.
QCC
none
*/

public class BigSib{
	String HelloMsg;
 	
	public BigSib(){
		HelloMsg = "Word up";
	}
	public void setHelloMsg(String msg){
		 HelloMsg = msg;
	}
	public String greet(String name){
		return (HelloMsg + " " +  name);
	}

}
