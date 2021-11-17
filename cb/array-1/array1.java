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
    int[] arr = new int[3];
    arr[0] = nums[1];
    arr[1] = nums[2];
    arr[2] = nums[0];
    return arr;
  }

  public static int[] reverse3(int[] nums) {
    int[] arr = new int[3];
    arr[0] = nums[2];
    arr[1] = nums[1];
    arr[2] = nums[0];
    return arr;
  }

  public static int[] maxEnd3(int[] nums) {
    int[] arr = new int[3];
    if(nums[0] >= nums[2]){
      for(int i=0; i<arr.length; i++){
        arr[i] = nums[0];
      }
    } else {
      for(int i=0; i<arr.length; i++){
        arr[i] = nums[2];
      }
    }
    return arr;
  }

  public static int sum2(int[] nums) {
    int sum = 0;
    if(nums.length==1){
      sum = nums[0];
    }
    if(nums.length>=2){
      sum = nums[0] + nums[1];
    }
    return sum;
  }

  public static int[] middleWay(int[] a, int[] b) {
    int[] arr = new int[2];
    arr[0] = a[1];
    arr[1] = b[1];
    return arr;
  }

  public static int[] makeEnds(int[] nums) {
    int[] arr = new int[2];
    arr[0] = nums[0];
    arr[1] = nums[nums.length-1];
    return arr;
  }

  public static boolean has23(int[] nums) {
    for(int x : nums){
      if(x==2 || x==3){
        return true;
      }
    }
    return false;
  }

  public static void main(String[] args){
    int[] arr = new int[]{1,3,5,7,6};
    int[] arr2 = new int[]{2,4,6,8,6};
    int[] arr3 = new int[]{5,2,9};
    int[] arr4 = new int[]{2,5};
    System.out.println(firstLast6(arr));
    System.out.println(sameFirstLast(arr));
    System.out.println(Arrays.toString(makePi()));
    System.out.println(commonEnd(arr, arr2));
    System.out.println(sum3(makePi()));
    System.out.println(Arrays.toString(rotateLeft3(makePi())));
    System.out.println(Arrays.toString(reverse3(makePi())));
    System.out.println(Arrays.toString(maxEnd3(makePi())));
    System.out.println(sum2(arr));
    System.out.println(Arrays.toString(middleWay(makePi(),arr3)));
    System.out.println(Arrays.toString(makeEnds(arr)));
    System.out.println(has23(arr4));

  }
}
