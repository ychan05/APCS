/**
<PENDING TNPG> Yat Long Chan, Samantha Hua, Lindsay Phung
APCS
HW25 -- Do I repeat myself?/ make fence with while loop and recursive fxn.
2021-10-26
time spent: 0.3 hours
DISCO
The recursive method requires less lines than the method using a while loop.
QCC
none
**/
public class Repeater {
 //while loop method
  public static String fenceW(int numPosts) {
    int count = 0;
    String fence = "";
    if (numPosts <= 0) {
      return fence;
    } else {
      while (count < numPosts) {
        count++;
        if (count == 1) {
          fence += "|";
        } else {
          fence += "--|";
        }
      }
    }
    return fence;
  }
 //recursive method
  public static String fenceR(int numPosts) {
    String fence = "";
    if (numPosts <= 0) {
      return fence;
    } else if (numPosts == 1) {
      fence += "|";
    } else {
      fence += "|--";
    }
    return fence + fenceR(numPosts - 1);
  }

  public static void main(String[] args) {
    //While loop testing 
    System.out.println(fenceW(1));
    System.out.println(fenceW(2));
    System.out.println(fenceW(3));

    //recursive testing 
    System.out.println(fenceR(1));
    System.out.println(fenceR(2));
    System.out.println(fenceR(3));
  }
}
