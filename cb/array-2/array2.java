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

  public int centeredAverage(int[] nums) {
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
      if(nums[i] != 13){
        sum+= nums[i];
      } else {
        i++;
      }
      i++;
    }
    return sum;
  }

  public static void main(String[] args){
    int[] arr = new int[]{1,2,3,4,5,6};
    System.out.println(countEvens(arr));
    System.out.println(bigDiff(arr));
  }
}
