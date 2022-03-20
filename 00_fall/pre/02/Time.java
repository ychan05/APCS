public class Time{
  public static void main(String[] args){
    int hour, minute, second;
    hour = 17;
    minute = 16;
    second = 10;

    int min_to_sec, hr_to_sec, secs_passed, secs_in_day;
    min_to_sec = minute * 60;
    hr_to_sec = hour * 3600;
    secs_passed = min_to_sec + hr_to_sec + second;
    secs_in_day = 24 * 3600;
    System.out.println("Time from midnight: " + secs_passed + " seconds");
    System.out.println("Time left in day: " + (secs_in_day - secs_passed) + " seconds");

    hour = 17;
    minute = 21;
    second = 10;
    min_to_sec = minute * 60;
    hr_to_sec = hour * 3600;
    secs_passed = (min_to_sec + hr_to_sec + second) - secs_passed;
    System.out.println("Time elapsed: " + secs_passed + " seconds");
  }
}
