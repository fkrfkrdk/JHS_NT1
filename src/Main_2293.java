

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_2293 {
	static int[] coins;
	static int[][] plate;
	static int result = 0;
	static int N, K;
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input_ = br.readLine().split(" ");
		N = Integer.parseInt(input_[0]);
		K = Integer.parseInt(input_[1]);
		plate = new int[10001][N];
		for(int i=0;i<plate.length;i++) {
			for(int j=0;j<N;j++) {
				plate[i][j] = -1;
			}
		}
		coins = new int[N];
		for(int i=0;i<N;i++) {
			coins[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(coins);
		System.out.println(calc(K,coins.length-1));
	}
	
	private static int calc(int value, int max_coin_index) throws Exception {
		if(value<0) return 0;
		else if(value == 0) return 1;
		
		if(plate[value][max_coin_index] != -1) return plate[value][max_coin_index];
		
		int result = 0;
		if(max_coin_index==0) result = value%coins[0]==0 ? 1:0;
		else {
			for(int i=max_coin_index;i>=0;i--) {
				result += calc(value-coins[i], i);
			}
		}
		plate[value][max_coin_index] = result;
		return result;
	}
}
