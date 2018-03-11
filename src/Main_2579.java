

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2579 {
	private static int[] input;
	private static int[][] data;
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		input = new int[N];
		data = new int[N][2];
		for(int i=0;i<N;i++) {
			input[i] = Integer.parseInt(br.readLine());
			data[i][0] = input[i];
			data[i][1] = input[i];
		}
		if(N>1) {
			data[1][1] += input[0];
		}
		for(int i=2;i<N;i++) {
			data[i][0] += Math.max(data[i-2][0],data[i-2][1]);
			data[i][1] += data[i-1][0];
		}
		System.out.println(Math.max(data[N-1][0],data[N-1][1]));
	}
}
