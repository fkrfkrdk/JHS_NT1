

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_9498 {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] data_S = br.readLine().split(" ");
		int[] data = new int[data_S.length];
		for(int i=0;i<data_S.length;i++) {
			data[i] = Integer.parseInt(data_S[i]);
		}
		Arrays.sort(data);
		System.out.println(data[1]);
	}
}
