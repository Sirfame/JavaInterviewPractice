
public class searchIndexPosition {

	public static void main(String[] args) {
		int[] arr3 = {1, 3, 5, 6};
		System.out.println(indexPosition(arr3, 5));
	    System.out.println(indexPosition(arr3, 2));
	    System.out.println(indexPosition(arr3, 7));
	    System.out.println(indexPosition(arr3, 0));
	    System.out.println(indexPosition(arr3, 4));
	}
	
	public static int indexPosition(int[] arr, int num) {
		int low = 0;
		int high = arr.length - 1;
		int middle = 0;
		while(low <= high) {
			middle = (low + high) / 2;
			if(arr[middle] == num) {
				return middle;
			}
			if(arr[middle] > num) {
				high = middle - 1;
			} else {
				low = middle + 1;
			}
		}
		if(arr[middle] < num) {
			return middle + 1;
		} else {
			return middle;
		}
	}
		

}
