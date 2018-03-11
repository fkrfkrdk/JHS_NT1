import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_5622 {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine().toUpperCase();
		int count = 0;
		for(int i=0;i<input.length();i++) {
			count += convertToInt(input.charAt(i));
		}
		System.out.println(count);
	}
	
	private static int convertToInt(char c) {
		int charInt = c-65;
		if(charInt < 15) return charInt/3 + 3;
		else {
			charInt -= 15;
			if(charInt<=3) return 8;
			else if(charInt <= 6) return 9;
			else if(charInt <= 10) return 10;
			else {
				return 11;
			}
		}
	}
}
