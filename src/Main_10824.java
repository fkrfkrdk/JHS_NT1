

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main_10824 {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input_ = br.readLine().split(" ");
		BigInteger[] input = new BigInteger[2];
		for(int i=0;i<input.length;i++) {
			input[i] = new BigInteger(input_[2*i]+input_[2*i+1]);
		}
		System.out.println(input[0].add(input[1]));
		
	}
}
