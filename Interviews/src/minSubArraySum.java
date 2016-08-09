import java.util.*;

public class minSubArraySum {

	public static void main(String[] args) {
      int[] arr = {6, 3, 5, 8, 4, 2, 1};
      int[] arr2 = {11, 13, 15, 16};
		System.out.println(minSubArraySum(arr, 100));
      System.out.println(consecSequence(arr));
      System.out.println(consecSequence(arr2));
	}
   
   public static int minSubArraySum(int[] arr, int s) {
      int sum = 0;
      int count = 1;
      Arrays.sort(arr);
      for(int i = arr.length - 1; i >=0; i--) {
         sum += arr[i];
         if(sum >= s) {
            return count;
         }
         count++;
      }
      return 0;
   }
   
   public static int consecSequence(int[] arr) {
      Arrays.sort(arr);
      int consec = 0;
      int currentConsec = 1;
      for(int i = 1; i < arr.length; i++) {
         if(arr[i - 1] == arr[i] - 1) {
            currentConsec++;
         } else {
            currentConsec = 1;
         }
         if(currentConsec > consec) {
            consec = currentConsec;
         }
      }
      return consec;
   }
   
}