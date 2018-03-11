

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1003 {
	static int[][] database = new int[41][2];
	
	
	public static void main(String args[]) throws Exception {
		database[0][0] = 1;
		database[0][1] = 0;
		database[1][0] = 0;
		database[1][1] = 1;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		calc(2);
		for(int t=0;t<T;t++) {
			int[] temp = database[Integer.parseInt(br.readLine())];
			sb.append(temp[0]+" "+temp[1]+"\n");
		}
		System.out.println(sb);
	}
	
	private static void calc(int n) {
		if(n >= database.length) return;
		database[n][0] = database[n-1][0] + database[n-2][0];
		database[n][1] = database[n-1][1] + database[n-2][1];
		calc(++n);
	}
}
