

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_14487 {
	private static int N;
	private static int[] value;
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		value = new int[N];
		String[] temp = br.readLine().split(" ");
		for(int i=0;i<N;i++) {
			value[i] = Integer.parseInt(temp[i]);
		}
		
		int max = 0;
		int sum = 0;
		for(int i=0;i<N;i++) {
			max = Math.max(max,value[i]);
			sum += value[i];
		}
		sum -= max;
		System.out.println(sum);
	}
}
