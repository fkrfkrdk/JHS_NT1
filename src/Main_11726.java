

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main_11726 {
	private static int N;
	private static BigInteger[] data;
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		data = new BigInteger[N];
		if(N>=1) data[0] = new BigInteger("1");
		if(N>=2) data[1] = new BigInteger("2");
		for(int i=2;i<N;i++) {
			calc(i);
		}
		System.out.println(data[N-1].mod(new BigInteger("10007")));
	}
	
	private static void calc(int n) {
		data[n] = data[n-1].add(data[n-2]);
	}
}
