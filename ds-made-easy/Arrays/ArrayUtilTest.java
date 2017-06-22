package pack;

import java.util.Random;

public class ArrayUtilTest {
	
	public static int [] makeLargeData(int size) {
		int arr[] = new int[size];
		Random r = new Random(10);
		for(int i = 0; i < size; i++) {
			arr[i] = r.nextInt(16);
		}
		return arr;
	}
	
	public static void hasSumPairTestV1(int arr[]) {
		long startTime = System.currentTimeMillis();
		
		System.out.println(ArrayUtil.hasSumPairV1(arr, arr[arr.length - 2] + arr[arr.length - 1]));
		
		long endTime = System.currentTimeMillis();
		System.out.println("Execution time: " + (endTime - startTime));
	}
	
	public static void hasSumPairTestV2(int arr[]) {
		long startTime = System.currentTimeMillis();
		System.out.println(ArrayUtil.hasSumPairV2(arr, arr[arr.length - 2] + arr[arr.length - 1]));
		long endTime = System.currentTimeMillis();
		System.out.println("Execution time: " + (endTime - startTime));
	}
	
	public static void searchSortedPivotedTest() {
		int arr[] = new int[] {40, 50, 60, 70, 80, 10, 20, 30};
		int arr1[] = new int[] {40, 41, 20, 30, 35, 36, 37, 38, 39};
		//System.out.println(ArrayUtil.searchSortedPivoted(arr, 60, 0, arr.length - 1));
		System.out.println(ArrayUtil.searchSortedPivoted(arr1, 36, 0, arr1.length - 1));
		System.out.println(ArrayUtil.searchSortedPivoted(arr1, 20, 0, arr1.length - 1));
		System.out.println(ArrayUtil.searchSortedPivoted(arr1, 41, 0, arr1.length - 1));
	}
	
	public static void searchSortedPivotedArrayTestV2() {
		int arr[] = new int[] {40, 50, 60, 70, 80, 10, 20, 30};
		int arr1[] = new int[] {40, 41, 20, 30, 35, 36, 37, 38, 39};
		System.out.println(ArrayUtil.searchSortedPivotedV2(arr1, 0, arr1.length - 1, 36));
		System.out.println(ArrayUtil.searchSortedPivotedV2(arr, 0, arr.length - 1, 20));
		System.out.println(ArrayUtil.searchSortedPivotedV2(arr1, 0, arr1.length - 1, 39));
	    }
	
	public static void main(String[] args) {
		int arr[] = makeLargeData(1000000);
		hasSumPairTestV1(arr);
		hasSumPairTestV2(arr);
	}
}
