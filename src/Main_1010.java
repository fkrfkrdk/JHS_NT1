

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main_1010 {
	static BigInteger[] facto = new BigInteger[30];
	static int calcedFacto = 1;
	
	public static void main(String ars[]) throws Exception {
		facto[0] = new BigInteger("1");
		facto[1] = new BigInteger("1");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int N, M;
		StringBuilder result = new StringBuilder();
		for(int t=0;t<T;t++) {
			String[] input_s = br.readLine().split(" ");
			N = Integer.parseInt(input_s[0]);
			M = Integer.parseInt(input_s[1]);
			int temp = Math.max(N, M-N);
			facto(temp);
			calcedFacto = calcedFacto<temp ? temp:calcedFacto;
			
			result.append(calc(N,M)+"\n");
		}
		System.out.print(result);
	}
	
	private static String calc(int n, int m) {
		return calcDiffMul(m,n,0).divide(facto[m-n]).toString();
	}
	private static BigInteger calcDiffMul(int big, int small, int count) {
		if(big == small) return new BigInteger("1");
		if(big-small == count+1) return new BigInteger(big-count+"");
		return calcDiffMul(big, small, count+1).multiply(new BigInteger(big-count+""));
	}
	
	private static BigInteger facto(int max) {
		if(max<=calcedFacto) return facto[max];
		return facto[max] = facto(max-1).multiply(new BigInteger(max+""));
	}
}
