public class array2{
  public static int countEvens(int[] nums) {
    int count = 0;
    for(int i : nums){
      if(i%2==0){
        count++;
      }
    }
    return count;
  }

  public static int bigDiff(int[] nums) {
    int max = nums[0];
    int min = nums[0];
    for(int i=0; i<nums.length;i++){
      max = Math.max(nums[i],max);
      min = Math.min(nums[i],min);
    }
    return max - min;
  }

  public static int centeredAverage(int[] nums) {
    int max = nums[0];
    int min = nums[0];
    int sum = 0;
    for(int i=0; i<nums.length;i++){
      max = Math.max(nums[i],max);
      min = Math.min(nums[i],min);
    }
    for(int x : nums){
      sum += x;
    }
    return (sum-max-min)/(nums.length-2);
  }

  public static int sum13(int[] nums) {
      int sum = 0;
      if(nums.length==0){
        return 0;
      }
      int i = 0;
      while(i<nums.length){
        if(nums[i]!=13){
          sum+=nums[i];
        }
        if(nums[i]==13){
          sum+=0;
          i++;
        }
        i++;
      }
      return sum;
    }

    public static int sum67(int[] nums) {
      int counter = 0;
      int sum = 0;
      for(int i=0; i<nums.length; i++){
        if(nums[i] == 6){
          counter = 1;
          continue;
        }
        if(counter == 1 && nums[i] == 7){
          counter--;
          continue;
        }
        if(counter == 0 && nums[i] != 6){
          sum+=nums[i];
        }
      }
      return sum;
    }

    public static boolean has22(int[] nums) {
      for(int i=0; i<nums.length-1; i++){
        if(nums[i] == 2 && nums[i+1] == 2){
          return true;
        }
      }
      return false;
    }

    public static boolean lucky13(int[] nums) {
      for(int x : nums){
        if(x==1 || x==3){
          return false;
        }
      }
      return true;
    }

    public static boolean sum28(int[] nums) {
      int sum = 0;
      for(int x : nums){
        if(x==2){
          sum+=2;
        }
      }
      if(sum==8){
        return true;
      }
      return false;
    }

    public static boolean more14(int[] nums) {
      int count1 = 0;
      int count4 = 0;
      for(int x : nums){
        if(x==1){
          count1++;
        }
        if(x==4){
          count4++;
        }
      }
      if(count1>count4){
        return true;
      }
      return false;
    }

  public static void main(String[] args){
    int[] arr = new int[]{1,2,3,4,5,6};
    int[] arr2 = new int[]{13,1,2,13,2,1,13};
    int[] arr3 = new int[]{1, 6, 2, 6, 2, 7, 1, 6, 99, 99, 7};
    int[] arr4 = new int[]{4,2,4,2,2,5};
    int[] arr5 = new int[]{1,4,1,1,4,4,1,4,1,4,1,1,4};
    System.out.println(countEvens(arr));
    System.out.println(bigDiff(arr));
    System.out.println(centeredAverage(arr));
    System.out.println(sum13(arr2));
    System.out.println(sum67(arr3));
    System.out.println(has22(arr4));
    System.out.println(lucky13(arr4));
    System.out.println(sum28(arr4));
    System.out.println(more14(arr5));
  }
}
