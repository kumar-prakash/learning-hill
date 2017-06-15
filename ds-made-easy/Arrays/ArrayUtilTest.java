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
	public static void main(String[] args) {
		int arr[] = makeLargeData(1000000);
		hasSumPairTestV1(arr);
		hasSumPairTestV2(arr);
	}
}
