/*
Yat Long Chan and ?
APCS
HW12: On Elder Individuality and the Elimination of Radio Fuzz
2021-10-05

DISCO
Instance vars can only be used in non static methods.
QCC
none
*/

public class BigSib{
	String HelloMsg;
 
	public void setHelloMsg(String msg){
		 HelloMsg = msg;
	}
	public String greet(String name){
		return (HelloMsg + " " +  name);
	}

}
