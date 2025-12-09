public class mergeSort {
	public static void main(String[] args) {
		int[] arr = {4, 5, 9, 11, 15};
		int[] arr2 = {6, 5, 4};
		print(merge(arr, arr2));
	}
	
	public static int[] merge(int[] arr1, int[] arr2) {
		int[] arr = new int[arr1.length + arr2.length];
		
		for (int i = 0, j = 0, k = 0; i < arr.length; i++) {
			if (j < arr1.length && arr1[j] < arr2[k]) {
				arr[i] = arr1[j];
				j++;
			}
			if (k < arr2.length && arr1[j] > arr[k]) {
				arr[i] = arr2[k];
				if (k == arr2.length) {
				k++;
			}
		}
		
		return arr;
	}
	
	public static void print(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ", ");
		}
	}
}