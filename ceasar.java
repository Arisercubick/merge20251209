import java.util.Scanner;
public class ceasar { 
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		boolean continueOn = true;
		while (continueOn) {
			System.out.print("Give a word to decipher (Type yes to end the loop): ");
			String as = reader.nextLine();
			if (as.toUpperCase().equals("YES")) {
				continueOn = false;
			} else {
				System.out.println();
				System.out.println();
				System.out.println(ceasar(as));
			}
		}
	}
	
	public static String ceasar(String word) {
		String newWord = "";
		for (int i = 0; i < word.length(); i++) {
			if ((word.charAt(i) >= 'a' && word.charAt(i) <= 'z') || (word.charAt(i) >= 'A' && word.charAt(i) <= 'Z') || (word.charAt(i) >= '0' && word.charAt(i) <= '9')) {
				char let = word.charAt(i);
				if (let >= 'a' && let <= 'z') {
					newWord = newWord + small(let);
				} else if (let >= 'A' && let <= 'Z') {
					newWord = newWord + large(let);
				} else {
					newWord = newWord + num(let);
				}
			} else {
				newWord = newWord + word.charAt(i);
			}
		}
		return newWord;
	}
	
	public static char small(char letter) {
		if (letter > 'w') {
			return (char) (letter - ('x' - 'a'));
		}
		return (char)(letter + ('d' - 'a'));
	}
	
	public static char large(char letter) {
		if (letter > 'W') {
			return (char) (letter - ('X' - 'A'));
		}
		return (char)(letter + ('D' - 'A'));
	}
	
	public static char num(char num) {
		if (num > '6') {
			return (char) (num - ('7' - '0'));
		}
		return (char)(num + ('3'-'0'));
	}
}