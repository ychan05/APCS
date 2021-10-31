public class string2 {
  /* Given a string, return a string where for every char in the original,
  there are two chars. */

  public static String doubleChar(String str) {
    String newStr = "";
    for (int i = 0; i < str.length(); i++) {
      newStr += (str.substring(i, i + 1)) + (str.substring(i, i + 1));
    }
    return newStr;
  }

  /* Return the number of times that the string "hi"
  appears anywhere in the given string. */
  public static int countHi(String str) {
    int ans = 0;
    for (int i = 0; i < str.length() - 1; i++) {
      if (str.substring(i, i + 2).equals("hi")) {
        ans++;
      }
    }
    return ans;
  }
  /* Return true if the string "cat" and "dog"
  appear the same number of times in the given string. */

  public static boolean catDog(String str) {
    int catCount = 0;
    int dogCount = 0;
    for (int i = 0; i < str.length() - 2; i++) {
      if (str.substring(i, i + 3).equals("cat")) {
        catCount++;
      } else if (str.substring(i, i + 3).equals("dog")) {
        dogCount++;
      }
    }
    if (catCount == dogCount) {
      return true;
    } else {
      return false;
    }
  }
  /* Return the number of times that the string "code" appears
  anywhere in the given string,
  except we'll accept any letter for the 'd', so "cope" and "cooe" count. */
  public static int countCode(String str) {
    int ans = 0;
    for (int i = 0; i < str.length() - 3; i++) {
      if (str.substring(i, i + 2).equals("co") && str.substring(i + 3, i + 4).equals("e")) {
        ans++;
      }
    }
    return ans;
  }

  /*
  Given two strings, return true if either of the strings appears at the very end of the other string,
  ignoring upper/lower case differences (in other words, the computation should not be "case sensitive").
  Note: str.toLowerCase() returns the lowercase version of a string.
  */

  public static boolean endOther(String a, String b) {
    String lowerA = a.toLowerCase();
    String lowerB = b.toLowerCase();
    int bLength = b.length();
    int aLength = a.length();
    if (aLength < bLength) {
      if (lowerB.substring(bLength - aLength, bLength).equals(lowerA)) {
        return true;
      } else {
        return false;
      }
    } else if (bLength < aLength) {
      if (lowerA.substring(aLength - bLength, aLength).equals(lowerB)) {
        return true;
      } else {
        return false;
      }
    } else {
      if (lowerA.equals(lowerB)) {
        return true;
      } else {
        return false;
      }
    }
  }
  /* Return true if the given string contains an appearance of "xyz"
  where the xyz is not directly preceeded by a period (.).
  So "xxyz" counts but "x.xyz" does not.
  */
  public static boolean xyzThere(String str) {
    boolean ans = false;
    for (int i = 0; i < str.length() - 2; i++) {
      if (i == 0) {
        if (str.substring(i, i + 3).equals("xyz")) {
          ans = true;
        }
      } else if (str.substring(i, i + 3).equals("xyz") && !str.substring(i - 1, i).equals(".")) {
        ans = true;
      }
    }
    return ans;
  }
  // Return true if the given string contains a "bob" string, but where the middle 'o' char can be any char.

  public static boolean bobThere(String str) {
    boolean ans = false;
    for (int i = 0; i < str.length() - 2; i++) {
      if (str.substring(i, i + 1).equals("b") && str.substring(i + 2, i + 3).equals("b")) {
        ans = true;
      }
    }
    return ans;
  }
  /*We'll say that a String is xy-balanced if for all the 'x' chars in the string, 
  there exists a 'y' char somewhere later in the string. So "xxy" is balanced, but "xyx" is not. 
  One 'y' can balance multiple 'x's. Return true if the given string is xy-balanced.
  */
  public boolean xyBalance(String str) {
    int y = -1;
    for (int i = 0; i < str.length(); i++) {
      if (str.substring(i, i + 1).equals("y")) {
        y = i;
      }
    }

    for (int i = 0; i < str.length(); i++) {
      if (str.substring(i, i + 1).equals("x") && i > y) {
        return false;
      }
    }
    return true;
  }

  /* Given two strings, a and b, create a bigger string made of the first char of a, the first char of b, the second char of a, 
  the second char of b, and so on. Any leftover chars go at the end of the result. */

  public String mixString(String a, String b) {
    String newStr = "";
    int len = Math.min(a.length(), b.length());
    for (int i = 0; i < len; i++) {
      newStr += a.substring(i, i + 1) + b.substring(i, i + 1);
    }
    return newStr + a.substring(len) + b.substring(len);
  }

  public static void main(String[] args) {
    //doubleChar test
    System.out.println(doubleChar("The"));
    System.out.println(doubleChar("AAbb"));
    System.out.println(doubleChar("Hi-There"));
    //countHi test
    System.out.println(countHi("abc hi ho"));
    System.out.println(countHi("ABChi hi"));
    System.out.println(countHi("hihi"));
    //catDog test
    System.out.println(catDog("catdog"));
    System.out.println(catDog("catcat"));
    System.out.println(catDog("1cat1cadodog"));
    //countCode test
    System.out.println(countCode("aaacodebbb"));
    System.out.println(countCode("codexxcode"));
    System.out.println(countCode("cozexxcope"));
    //endOther test
    System.out.println(endOther("Hiabc", "abc"));
    System.out.println(endOther("AbC", "HiaBc"));
    System.out.println(endOther("abc", "abXabc"));
    //xyzthere test
    System.out.println(xyzThere("abcxyz"));
    System.out.println(xyzThere("abc.xyz"));
    System.out.println(xyzThere("xyz.abc"));
  }
}
