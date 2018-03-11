import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1316 {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int count = 0;
		for(int i=0;i<N;i++) {
			if(check(br.readLine())) count++;
		}
		System.out.println(count);
	}
	
	private static boolean check(String input) {
		boolean[] alpha = new boolean[26];
		for(int i=0;i<input.length();i++) {
			int ch = input.charAt(i)-97;
			if(!alpha[ch]) alpha[ch] = true;
			else return false;
			while(i+1 < input.length()) {
				if(input.charAt(i) == input.charAt(i+1)) i++;
				else break;
			}
		}
		return true;
	}
}
