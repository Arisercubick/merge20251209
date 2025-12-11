import java.util.Scanner;
public class decryption {
	public static void main(String[] args) {
		decryption();
	}
	
	public static void decryption() {
		Scanner reader = new Scanner(System.in);
		final int SIZE_OF_LOWERCASE = 26;
		final int SIZE_OF_UPPERCASE = 26;
		final int SIZE_OF_NUMBER = 10;
		char [] alphabetArray = fillTheAlphabet(SIZE_OF_LOWERCASE + SIZE_OF_NUMBER + SIZE_OF_UPPERCASE);
		char[] ourAlphabet = new char[SIZE_OF_LOWERCASE + SIZE_OF_NUMBER + SIZE_OF_UPPERCASE];
		int[] indexArr = new int[SIZE_OF_LOWERCASE + SIZE_OF_NUMBER + SIZE_OF_UPPERCASE];
		
		System.out.println();
		System.out.print("Put your uncoded text: ");
		String uncodedText = reader.next();
		System.out.println();
		System.out.print("Put your key here: ");
		String key = reader.next();
		System.out.println();
		
		String temp = ""
		for (int i = 0, j = 0; i < 372; i++) {
			if (temp.equals("0100")) {
				int ourVal = (int) (key.charAt(i) - '0') * 10;
				ourVal = ourVal + (key.charAt(i+1) - '0');
				i++;
				temp = "";
				indexArr[j] = ourVal;
				j++;
			} else {
				temp = temp + key.charAt(i);
			}
		}
		shift(indexArr, key);
		
		String message = "";
		for (int i = 372;
		
	}
	
	public static String translate(char[] alpha, int[] index, String word) { 
		char checkAlpha = new char[alpha.length];
		for (int i = 0; i < alpha.length; i++) {
			checkAlpha[i] = alpha[index[i]];
		}
		String sent = "";
		
		for (int i = 0; i < word.length()-2; i++) {
			char let = word.charAt(i);
			boolean found = false;
			for (int j = 0; j < index.length && !found; j++) {
				if (let == checkAlpha[i]) {
					sent = sent + alpha[j];
					found = true;
				}
			}
			
			sent = sent + " ";
		}
		return sent;
	}
	
	public static void shift2(int[] arr, int val) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] + val >= arr.length) {
				arr[i] = arr[i] - arr.length + val;
			} else {
				arr[i] = arr[i] + val;
			}
		}
	}
	
	public static void shift(int[] arr, String key) {
		String keyCh = "";
		for (int i = key.length; i > 372; i--) {
			keyCh = keyCh + key.charAt(i);
			if (keyCh.equals("00") && keyCh.charAt(i-1) == '2') {
				i -= 2;
				keyCh = "";
			} else if (keyCh.equals("00")) {
				i -= 4;
				keyCh = "";
			} else if (keyCh.length() == 2) {
				int ourVal = (int) (keyCh.charAt(0) - '0') * 10;
				ourVal = ourVal + (keyCh.charAt(i+1) - '0');
				i++;
				keyCh = "";
				for (int j = 0; j < arr.length; j++) {
					if (0 > arr[j] - ourVal) {
						arr[j] = arr.length - ourVal + arr[j];
					} else {
						arr[j] = arr[j] - ourVal;
					}
				}
			}
		}
	
	public static char[] fillTheAlphabet(int size) {
		char[] alphabetArray = new char[size];
		int index = 0;
		int count = 'a';
		System.out.println("Filling Alphabet");
		while (count >= 'a' && count <= 'z') {
			alphabetArray[index] = (char) count;
			if (count == 'z') {
				count = 'A';
			} else {
				count++;
			}
			index++;
		}
		System.out.println("Lowecase done");
		while (count >= 'A' && count <= 'Z') {
			alphabetArray[index] = (char) count;
			if (count == 'Z') {
				count = '0';
			} else {
				count++;
			}
			index++;
		}
		System.out.println("Uppercase done");
		while (count >= '0' && count <= '9') {
			alphabetArray[index] = (char) count;
			if (count <= '9') {
				count++;
				index++;
			}
		}
		System.out.println("Done done Alphabet");
		return alphabetArray;
	}
	
	public static int valToInt(String ch) {
		int val = 0;
		for (int i = 0; i < ch.length; i++) {
			val += (int) ch.charAt(i) - '0';
		}
		return val;
	}
}