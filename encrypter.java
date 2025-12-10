import java.util.Scanner;
import java.util.Random;
public class encrypter {
	public static void main(String[] args) {
		encrypter();
	}
	
	private static int indexCount = 0;
	
	public static void encrypter() {
		Scanner reader = new Scanner(System.in);
		final int SIZE_OF_LOWERCASE = 26;
		final int SIZE_OF_UPPERCASE = 26;
		final int SIZE_OF_NUMBER = 10;
		boolean continueOn = true;
		while (continueOn) {
			char[] ourArray = fillTheAlphabet(SIZE_OF_LOWERCASE + SIZE_OF_NUMBER + SIZE_OF_UPPERCASE);
			System.out.println("Go into indexArray");
			int[] arrCode = indexArray(SIZE_OF_LOWERCASE + SIZE_OF_NUMBER + SIZE_OF_UPPERCASE);
			char[] finalArray = new char[SIZE_OF_LOWERCASE + SIZE_OF_NUMBER + SIZE_OF_UPPERCASE];
			String phrase = "";
			System.out.println("Arrays are finished");
			
			for (int i = 0; i < finalArray.length; i++) {
				finalArray[i] = ourArray[arrCode[i]];
			}
			System.out.println("Final Arrya is finished");
			
			System.out.print("Put your text to decipher (say -1YES to end the loop): ");
			String text = reader.nextLine();
			if (text.toUpperCase().equals("-1YES")) {
				continueOn = false;
			}
			int[] shiftcode = new int[lengthOfTest(text)];
			
			if (continueOn) {
				System.out.println("Managing the system");
				for (int i = 0; i < text.length(); i++) {
					char let = text.charAt(i);
					System.out.println(let);
					if ((let >= 'a' && let <= 'z') || (let >= 'A' && let <= 'Z') || (let >= '0' && let <= '9')) {
						boolean found = false;
						for (int j = 0; j < finalArray.length && !found; j++) {
							System.out.println("verifying if " + let + " equals to " + finalArray[j]);
							if (let == ourArray[j]) {
								phrase = phrase + finalArray[j];
								found = true;
							}
						}
					} else {
						String temp = "" + (int) let;
						for (int k = 0; k < temp.length(); k++) {
							char wod = temp.charAt(k);
							System.out.println(wod);
							boolean found = false;
							for (int j = 0; j < finalArray.length && !found; j++) {
								System.out.println("verifying if " + wod + " equals to " + finalArray[j]);
								if (wod == ourArray[j]) {
									phrase = phrase + finalArray[j];
									found = true;
								}
							}
						}
						shift(arrCode, shiftcode);
						for (int k = 0; k < finalArray.length; k++) {
							finalArray[k] = ourArray[arrCode[k]];
						}
					}
				}
				
				System.out.println();
				System.out.println();
				System.out.println(phrase);
				System.out.println();
				System.out.println();
				
				System.out.print("Do you want to continue (Yes to continue): ");
				String response = reader.next();
				if (!(response.toUpperCase().equals("YES"))) {
					continueOn = false;
				}
				reader.nextLine();
			}
		}
	}
	
	public static void shift(int[] arr, int[] index2) {
		Random rand = new Random();
		int shift = rand.nextInt(arr.length);
		index2[indexCount] = shift;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] + shift >= arr.length) {
				arr[i] = arr[i] - arr.length + shift;
			} else {
				arr[i] = arr[i] + shift;
			}
		}
	}
	
	public static void printCode(int[] index, int[] index2) {
		System.out.println();
		for (int i = 0; i < index.length; i++) {
			System.out.print(index[i]);
		}
		System.out.print("|||||");
		for (int i = 0; i < index.length; i++) {
			System.out.print(index2[i]);
		}
	}
	
	public static int lengthOfTest(String text) {
		int count = 0;
		for (int i = 0; i < text.length(); i++) {
			char let = text.charAt(i);
			if (!((let >= 'a' && let <= 'z') || (let >= 'A' && let <= 'Z') || (let >= '0' && let <= '9'))) {
				count++;
			}
		}
		return count;
	}
				
	
	public static int[] indexArray(int size) {
		Random rand = new Random();
		int[] arrCode = new int[size];
		System.out.println("Filling index");
		for (int i = 0; i < arrCode.length;) {
			boolean gotIt = true;
			arrCode[i] = rand.nextInt(arrCode.length);
			for (int j = 0; j < i; j++) {
				System.out.println("checking if " + arrCode[i] + " equals to " + arrCode[j]);
				if (arrCode[i] == arrCode[j]) {
					gotIt = false;
				}
			}
			if (gotIt) {
				i++;
			}
		}
		System.out.println("Index done");
		return arrCode;
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
}