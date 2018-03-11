

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_11655 {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		StringBuilder result = new StringBuilder();
		for(int i=0;i<input.length();i++) {
			char temp = input.charAt(i);
			temp = ('a'<=temp&&temp<='z')||('A'<=temp&&temp<='Z') ? ROT13(temp) : temp;
			result.append(temp);
		}
		System.out.println(result);
	}
	
	private static char ROT13(char input) {
		boolean lower = input>='a';
		input+=13;
		if(lower && input>'z') input-='z'-'a'+1;
		else if(!lower && input>'Z') input-='Z'-'A'+1;
		return input;
	}
}
