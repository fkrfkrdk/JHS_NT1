

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_14488 {
	private static int N;
	private static float T;
	private static int[] pos, speed;
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input_temp = br.readLine().split(" ");
		N = Integer.parseInt(input_temp[0]);
		T = Float.parseFloat(input_temp[1]);
		input_temp = br.readLine().split(" ");
		pos = new int[N];
	
		speed = new int[N];
		for(int i=0;i<N;i++) {
			pos[i] = Integer.parseInt(input_temp[i]);
		}
		input_temp = br.readLine().split(" ");
		for(int i=0;i<N;i++) {
			speed[i] = Integer.parseInt(input_temp[i]);
		}
		
		float[][] data = new float[N][2];
		float min = Float.MIN_VALUE;
		float max = Float.MAX_VALUE;
		for(int i=0;i<N;i++) {
			float diff = T*(float)speed[i];
			data[i][0] = (float)pos[i] - diff;
			data[i][1] = (float)pos[i] + diff;
			min = Math.max(min,data[i][0]);
			max = Math.min(max,data[i][1]);
		}
		int result = 0;
		if(min<=max) result = 1;
		else result = 0;
		System.out.println(result);
	}
}
