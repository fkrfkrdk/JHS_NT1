

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_10992 {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		printStar(N);
	}
	
	static void printStar(int n) {
		StringBuilder sb = new StringBuilder();
		for(int i=1;i<=n;i++) {
			if(i == 1) {
				sb.append(multiplyChar(n-1,' ')).append("*\n");
			} else if(i == n) {
				sb.append(multiplyChar(n*2-1,'*')).append('\n');
			} else {
				sb.append(multiplyChar(n-i,' ')).append('*');
				sb.append(multiplyChar(2*(i-1)-1,' ')).append("*\n");
			}
		}
		System.out.println(sb);
	}
	
	private static String multiplyChar(int x, char c) {
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<x;i++) {
			sb.append(c);
		}
		return sb.toString();
	}
}