

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2156 {
	private static int N;
	private static int[] input;
	private static int[][] data;
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		input = new int[N];
		for(int i=0;i<N;i++) {
			input[i] = Integer.parseInt(br.readLine());
		}
		data = new int[N][3];
		data[0][0] = 0;
		data[0][1] = input[0];
		data[0][2] = input[0];
		
		for(int i=1;i<N;i++) {
			data[i][0] = Math.max(data[i-1][0],Math.max(data[i-1][1],data[i-1][2]));
			data[i][1] = data[i-1][0] + input[i];
			data[i][2] = data[i-1][1] + input[i];
		}
		System.out.println(Math.max(data[N-1][0],Math.max(data[N-1][1],data[N-1][2])));
	}
}
