

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1018 {
	static int[] result = new int[2];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input_S = br.readLine().split(" ");
		
		for(int i=0;i<Integer.parseInt(input_S[0]);i++) {
			inspect(br.readLine(), i%2==0);
		}
		//System.out.print(Math.min(result[0], result[1]));
		System.out.println(result[0]);
		System.out.print(result[1]);
	}
	
	private static void inspect(String row,boolean criteria_W) {
		for(int i=0;i<row.length();i++) {
			if(row.charAt(i) == 'W') {
				if(i%2 == 0) result[criteria_W?0:1]++;
				else result[criteria_W?1:0]++;
			} else {
				if(i%2 == 0) result[criteria_W?1:0]++;
				else result[criteria_W?0:1]++;
			}
		}
	}
}
