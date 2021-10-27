/**
<PENDING TNPG> Yat Long Chan, Samantha Hua, Lindsay Phung
APCS
HW25 -- Do I repeat myself?/ make fence with while loop and recursive fxn.
2021-10-26
time spent: 0.3 hours
DISCO
The recursive method requires less variables than the method using a while loop.
QCC
Which is better to prioritize: readable and easy to understand code or more efficient code
**/
public class Repeater {
  //while loop method
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
  //recursive method
  public static String fenceR(int numPosts) {
    String fence = "|";
    if (numPosts == 1) {
      return fence;
    } 
    fence += "|--";
    return fence + fenceR(numPosts - 1);
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
 
