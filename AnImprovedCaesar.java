import java.util.Scanner;
public class AnImprovedCaesar { 
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		boolean continueOn = true;
		System.out.print("Give a number of deciphering (3 digits): ");
		int code = reader.nextInt();
		System.out.println();
		reader.nextLine();
		while (continueOn) {
			System.out.print("Give a word to decipher (Type yes to end the loop): ");
			String as = reader.nextLine();
			if (as.toUpperCase().equals("YES")) {
				continueOn = false;
			} else {
				System.out.println();
				System.out.println();
				System.out.println(ceasar(as, code));
			}
		}
	}
	
	public static String ceasar(String word, int code) {
		String newWord = "";
		for (int i = 0; i < word.length(); i++) {
			if ((word.charAt(i) >= 'a' && word.charAt(i) <= 'z') || (word.charAt(i) >= 'A' && word.charAt(i) <= 'Z') || (word.charAt(i) >= '0' && word.charAt(i) <= '9')) {
				char let = word.charAt(i);
				if (let >= 'a' && let <= 'z') {
					newWord = newWord + small(let, code);
				} else if (let >= 'A' && let <= 'Z') {
					newWord = newWord + large(let, code);
				} else {
					newWord = newWord + num(let, code);
				}
			} else {
				newWord = newWord + word.charAt(i);
			}
		}
		return newWord;
	}
	
	public static char small(char letter, int code) {
		int co = ((""+code).charAt(0)%'0');
		if (letter > ('z' - co)) {
			return (char) (letter - (('z' -co) - 'a'));
		}
		return (char)(letter + co);
	}
	
	public static char large(char letter, int code) {
		int co = ((""+code).charAt(1)%'0');
		if (letter > ('Z' - co)) {
			return (char) (letter - (('Z' - co) - 'A'));
		}
		return (char)(letter + co);
	}
	
	public static char num(char num, int code) {
		int co = ((""+code).charAt(2)%'0');
		if (num > ('9' - co)) {
			return (char) (num - (('9' - co) - '0'));
		}
		return (char)(num + co);
	}
}