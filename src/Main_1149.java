

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1149 {
	static int N;
	static int[][] data;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		data = new int[N][3];
		
		for(int j=0;j<N;j++) {
			String[] temp = br.readLine().split(" ");
			for(int i=0;i<3;i++) {
				data[j][i] = Integer.parseInt(temp[i]);
			}
		}
		
		int[][] result = new int[N+1][3];
		result[0] = data[0];
		
		for(int j=0;j<result.length;j++) {
			for(int i=0;i<3;i++) {
				int min = 0;
				switch(i) {
				case 0:
					min = Math.min(result[j][1], result[j][2]);
					break;
				case 1:
					min = Math.min(result[j][0], result[j][2]);
					break;
				case 2:
					min = Math.min(result[j][0], result[j][1]);
					break;
				}
				result[j+1][i] = min + data[j+1][i];
			}
		}
		
		int temp = result[N][0];
		for(int i=1;i<result.length;i++) {
			temp = temp < result[N][i] ? temp : result[N][i];
		}
		System.out.println(temp);
	}
}
