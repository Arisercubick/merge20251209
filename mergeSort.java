public class mergeSort {
	public static void main(String[] args) {
		int[] arr = {4, 5, 9, 11, 15};
		int[] arr2 = {4, 6, 5};
		print(merge(arr, arr2));
	}
	
	public static int[] merge(int[] arr1, int[] arr2) {
		int[] arr = new int[arr1.length + arr2.length];
		
		for (int i = 0, j = 0, k = 0; i < arr.length; i++) {
			if (j != arr1.length && k != arr2.length) {
				if (arr1[j] < arr2[k]) {
					arr[i] = arr1[j];
					j++;
				}
				else {
					arr[i] = arr2[k];
					k++; 
				}
			} else if (j != arr1.length) {
				arr[i] = arr1[j];
				j++;
			} else if (k != arr2.length) {
				arr[i] = arr2[k];
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