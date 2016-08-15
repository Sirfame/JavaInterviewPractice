
public class searchIndexPosition {

	public static void main(String[] args) {
		int[] arr = {6, 3, 5, 8, 4, 2, 1};
		int[] arr2 = {11, 13, 15, 16};
		int[] arr3 = {1, 3, 5, 6};
		System.out.println(indexPosition(arr3, 5));
	    System.out.println(indexPosition(arr3, 2));
	    System.out.println(indexPosition(arr3, 7));
	    System.out.println(indexPosition(arr3, 0));
	}
	
	public static int indexPosition(int[] arr, int num) {
	   for(int i = 0; i < arr.length; i++) {
		   if(arr[i] >= num) {
			   return i;
		   }
	   }
	   return arr.length;
	}
		

}
