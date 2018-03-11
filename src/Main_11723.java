

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_11723 {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int M = Integer.parseInt(br.readLine());
		int S = 0;
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<M;i++) {
			String temp = br.readLine();
			if(temp.startsWith("add")) {
				S = S | (1<<Integer.parseInt(temp.substring(4)));
			} else if(temp.startsWith("remove")) {
				S = S & ~(1<<Integer.parseInt(temp.substring(7)));
			} else if(temp.startsWith("check")) {
				int x = Integer.parseInt(temp.substring(6));
				sb.append((S & (1<<x)) >> x);
				sb.append("\n");
			} else if(temp.startsWith("toggle")) {
				S = S ^ (1<<Integer.parseInt(temp.substring(7)));
			} else if(temp.startsWith("all")) {
				S = ~0 - 1;
			} else if(temp.startsWith("empty")) {
				S = 0;
			}
		}
		System.out.println(sb);
	}
}