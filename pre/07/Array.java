import java.util.Arrays;

public class Array{

  public static double[] powArray(double[] a, int x){
    for (int i = 0; i < a.length; i++) {
      a[i] = Math.pow(a[i], x);
    }
    return a;
  }

  public static int[] histogram(int[] a, int count){
    int[] hist = new int[count];
    for (int element : a){
      hist[element] ++;
    }
    return hist;
  }
  public static int indexOfMax(int[] a){
    int largest = a[0];
    int largestIndex = 0;
    for (int i = 0; i < a.length; i ++){
      if (a[i] > largest){
        largest = a[i];
        largestIndex = i;
      }
    }
    return largestIndex;
  }

  public static boolean[] sieve(int n){
    boolean[] result = new boolean[n];
    for (int i = 2; i < n; i++){
      result[i] = true;
    }
    for (int i = 2; i < Math.sqrt(n); i ++){
      if (result[i] == true){
        int j = i * 2;
        while (j < n){
          result[j] = false;
          j += i;
        }
      }
    }
    return result;
  }
  public static void main(String[] args){
    double[] a = {1.0, 2.0, 3.0, 4.0};
    double[] powArr = powArray(a, 3);
    int[] histArr = {1, 2, 5, 7, 8, 9, 8, 2, 6, 7, 8, 10};
    int[] maxIndexTest = {1, 10, 2, 3, 4, 5, 6, 7};
    System.out.println(Arrays.toString(powArr));
    System.out.println(Arrays.toString(histogram(histArr, 11)));
    System.out.println(indexOfMax(maxIndexTest));
    System.out.println(Arrays.toString(sieve(121)));
  }
}
