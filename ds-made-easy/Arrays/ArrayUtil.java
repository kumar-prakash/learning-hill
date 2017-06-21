
public class ArrayUtil {
	
	/**
	 * Find whether the array contains two number x, y such that, x + y = sum
	 * Uses brute force O(n * n)
	 */
	public static boolean hasSumPairV1(int [] arr, int sum) {
		for(int i = 0; i < arr.length - 1; i++) {
			for(int j = i + 1; j < arr.length; j++) {
				if(arr[i] + arr[j] == sum) {
					return true;
				}
			}
		}
		return false;
	}
	
	public static void swap(int arr[], int x, int y) {
		int temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
	} 
	
	/**
	 * Quick sort
	 * @param arr
	 * @param start
	 * @param end
	 */
	public static void sortArray(int arr[], int start, int end) {
		if(start >= end) {
			return;
		}
		int k = end;
		int pivot = arr[k];
		int i = start - 1;
		for(int j = start; j < end; j++) {
			if(arr[j] < pivot) {
				i++;
				swap(arr, i, j);
			}
		}
		k = i + 1;
		swap(arr, k, end);
		sortArray(arr, start, k - 1);
		sortArray(arr, k + 1, end);
	}
	
	public static boolean hasSumPairV2(int [] arr, int sum) {
		sortArray(arr, 0, arr.length -1);
		int start = 0;
		int end = arr.length - 1;
		while(start < end) {
			if(arr[start] + arr[end] == sum) {
				return true;
			} else if(arr[start] + arr[end] < sum) {
				start++;
			} else {
				end--;
			}
		}
		return false;
	}
	
	public static int findMajorityElementV1(int arr[]) {
		sortArray(arr, 0, arr.length - 1);
		int element = arr[0];
		int count = 0;
		int maxCount = 1;
		for(int i = 1; i < arr.length; i++) {
			if(element == arr[i] ) {
				count++;
			} else {
				element = arr[i];
				if(count > maxCount) {
					maxCount = count;
				}
				maxCount = 1;
			}
		}
		return element;
	}
    
	public static boolean searchSortedPivoted(int [] arr, int target, int start, int end) {
		if(start > end) {
			return false;
		}
		int mid = (start + end) / 2;
		if(arr[mid] == target) {
			return true;
		}
		
		if(arr[mid] > arr[start]) {
			if(target > arr[start] && target < arr[mid]) {
				// go left
				return searchSortedPivoted(arr, target, start, mid -1);
			}
			if(target > arr[start] && target > arr[mid]) {
				// go right
				return searchSortedPivoted(arr, target, mid + 1, end);
			}
			if(target < arr[start] && target < arr[mid] ) {
				// go right
				return searchSortedPivoted(arr, target, mid + 1, end);
			}
		} else {
			if(target > arr[mid] && target < arr[end]) {
				// go right
				return searchSortedPivoted(arr, target, mid + 1, end);
			}
			if(target < arr[mid] && target < arr[start] ) {
				// go left
				return searchSortedPivoted(arr, target, start, mid -1);
			}
			if(target > arr[mid] && target > arr[start]) {
				// go left
				return searchSortedPivoted(arr, target, start, mid -1);
			}
		}
		
		return false;
	}
	
	public static void printArr(int arr[]) {
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println("");
	}
}
