

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1463 {
	private static int N;
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		int temp = N;
		int count = 0;
		while(true) {
			if(temp == 1) {
				System.out.println(count);
				break;
			}
			temp = Math.max(temp%3==0 ? temp/3 : -1,Math.max(temp%2==0 ? temp/2 : -1, temp-1));
			count++;
		}
		
	}
}