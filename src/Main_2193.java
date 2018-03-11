

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main_2193 {
	private static int N;
	private static BigInteger[] data;
	private static BigInteger sum = new BigInteger("1");
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		data = new BigInteger[N];
		
		data[0] = new BigInteger("1");
		if(N>1) data[1] = new BigInteger("1");
		
		for(int i=2;i<N;i++) {
			sum = sum.add(data[i-2]);
			data[i] = sum;
		}
		System.out.println(data[N-1]);
	}
}
