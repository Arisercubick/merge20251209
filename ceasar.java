public class ceasar { 
	public static void main(String[] args) {
		String as = "abced";
		System.out.println(ceasar(as));
	}
	
	public static String ceasar(String word) {
		String newWord = "";
		for (int i = 0; i < word.length(); i++) {
			char let = word.charAt(i);
			if (let >= 'a' && let <= 'z') {
				newWord = newWord + small(let);
			} else if (let >= 'A' && let <= 'Z') {
				newWord = newWord + large(let);
			} else {
				newWord = newWord + num(let);
			}
		}
		return newWord;
	}
	
	public static char small(char letter) {
		if (letter < 'w') {
			letter = (char) (letter - 'w');
		}
		return (char)(letter + ('c' - 'a'));
	}
	
	public static char large(char letter) {
		if (letter < 'W') {
			letter = (char) (letter - 'W');
		}
		return (char)(letter + ('C' - 'A'));
	}
	
	public static char num(char num) {
		if (num < '6') {
			num = (char) (num - '6');
		}
		return (char)(num + ('3'-'1'));
	}
}