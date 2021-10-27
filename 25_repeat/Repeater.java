/*
<PENDING TNPG> Yat Long Chan, Samantha Hua, Lindsay Phung
APCS
HW25 -- Do I repeat myself?
2021-10-26
time spent: 0.5 hours
DISCO 
- You can call a method inside a return statement. This allows you to retain the value of a variable without using a instance variable
- We broke up the fence into different portions depending on the type of loop we used. (ex: |-- vs --|) Both created the same exact output.
- To intialize a String without giving it a value, you can set it equal to quotations without any value between them ("")
QCC
- Which is better to prioritize: readable and easy to understand code or more efficient code?
*/

public class Repeater {

  public static String fenceW(int numPosts) {
    int counter = 1;
    String fence = "|";
    while (counter < numPosts) {
      fence += "--|";
      counter++;
    }
  }
  return fence;
}

public static String fenceR(int numPosts) {
  String fence = "";
  if (numPosts == 1) {
    fence += "|";
    return fence;
  } else {
    fence += "|--";
    return fence + fenceR(numPosts - 1);
  }

}
public static void main(String[] args) {
  System.out.println("===while loop testing===");
  System.out.println(fenceW(1));
  System.out.println(fenceW(2));
  System.out.println(fenceW(3));

  System.out.println("===recursive testing===");
  System.out.println(fenceR(1));
  System.out.println(fenceR(2));
  System.out.println(fenceR(3));
}

}
