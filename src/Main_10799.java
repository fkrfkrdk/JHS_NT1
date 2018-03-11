

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_10799 {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int result = 0;
		int count = 0;
		char[] input = br.readLine().toCharArray();
		
		for(int i=0;i<input.length;i++) {
			if(input[i] == '(') {
				 count++;
			} else {
				if(input[i-1] == '(') {
					count--;
					result += count;
				} else {
					result++;
					count--;
				}
			}
		}
		
		System.out.println(result);
	}
}
