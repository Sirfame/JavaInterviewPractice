import java.util.*;

public class minSubArraySum {

	public static void main(String[] args) {
      int[] arr = {6, 3, 5, 8, 4, 2, 1};
		System.out.println(minSubArraySum(arr, 100));
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
   
}
