

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_10808 { //10809
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		int[] result = new int[26];
		for(int i=0;i<result.length;i++) {
			result[i] = -1;
		}
		
		Loop1 : for(int i=0;i<26;i++) {
			char c = (char)(i+'a');
			for(int j=0;j<input.length();j++) {
				if(input.charAt(j)==c) {
					result[i] = j;
					continue Loop1;
				}
			}
		}
		StringBuilder r = new StringBuilder();
		for(int i=0;i<result.length;i++) {
			r.append(result[i]+" ");
		}
		System.out.println(r);
	}
}
