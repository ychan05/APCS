import java.util.Arrays;

public class array1{
  public static boolean firstLast6(int[] nums) {
    if(nums[0] == 6 || nums[nums.length-1] == 6){
      return true;
    }
    return false;
  }

  public static boolean sameFirstLast(int[] nums) {
    if(nums.length >= 1 && nums[0] == nums[nums.length-1]){
      return true;
    }
    return false;
  }

  public static int[] makePi() {
    int[] arr = new int[]{3,1,4};
    return arr;
  }

  public static boolean commonEnd(int[] a, int[] b) {
    if(a.length >= 1 && b.length >= 1){
      if(a[0] == b[0] || a[a.length-1] == b[b.length-1]){
        return true;
      }
    }
    return false;
  }

  public static int sum3(int[] nums) {
    int sum = 0;
    for(int x : nums){
      sum += x;
    }
    return sum;
  }

  public static int[] rotateLeft3(int[] nums) {
    int[] arr3 = new int[3];
    arr3[0] = nums[1];
    arr3[1] = nums[2];
    arr3[2] = nums[0];
    return arr3;
  }


  public static void main(String[] args){
    int[] arr = new int[]{1,3,5,7,6};
    int[] arr2 = new int[]{2,4,6,8,6};
    System.out.println(firstLast6(arr));
    System.out.println(sameFirstLast(arr));
    System.out.println(Arrays.toString(makePi()));
    System.out.println(commonEnd(arr, arr2));
    System.out.println(sum3(makePi()));
    System.out.println(Arrays.toString(rotateLeft3(makePi())));
  }
}
