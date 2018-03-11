

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1932 {
	static int n;
	static int[][] data;
	
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		data = new int[n][];
		for(int i=1;i<=data.length;i++) {
			data[i-1] = new int[i];
			String[] temp = br.readLine().split(" ");
			for(int j=0;j<temp.length;j++) {
				data[i-1][j] = Integer.parseInt(temp[j]);
			}
		}
		
		if(n == 1) {
			System.out.println(data[0][0]);
		} else {
			int[] prev = data[n-1];
			for(int i=n-1;i>0;i--) {
				prev = calcStep(i,prev);
			}
			System.out.println(prev[0]);
		}
	}
	
	private static int[] calcStep(int depth, int[] prev) { // starts with N-1
		int[] result = new int[depth];
		
		for(int i=0;i<depth;i++) {
			result[i] = data[depth-1][i] + Math.max(prev[i],prev[i+1]);
		}
		return result;
	}
}
