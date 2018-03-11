

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_11721 {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<=s.length()/10;i++) {
			sb.append(s.substring(i*10, i==s.length()/10 ? s.length():(i*10+10)));
			if(i!=s.length()/10) sb.append('\n');
		}
		System.out.print(sb);
	}
}
