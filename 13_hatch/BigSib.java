/*
Chicken Noodle Soup: Yat Long Chan and Courtney Huang
APCS
HW12: On Elder Individuality and the Elimination of Radio Fuzz
2021-10-05

DISCO
Constructors are used to initialize objects/set initial values for objects.
QCC
none
*/

public class BigSib{
	String HelloMsg;
 	
	public BigSib(){
		setHelloMsg("Word up");
	}
	public void setHelloMsg(String msg){
		 HelloMsg = msg;
	}
	public String greet(String name){
		return (HelloMsg + " " +  name);
	}

}
