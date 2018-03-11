import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main_2748 {
	private static BigInteger[] data;
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		if(n==0) {
			System.out.println(0);
			System.exit(0);
		}
		
		data = new BigInteger[n+1];
		data[0] = new BigInteger("0");
		data[1] = new BigInteger("1");
		
		for(int i=2; i<=n; i++) {
			data[i] = data[i-1].add(data[i-2]);
		}
		System.out.println(data[n]);
	}
}
