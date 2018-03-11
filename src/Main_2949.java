import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main_2949 {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		BigInteger N = new BigInteger(br.readLine());
		
		BigInteger ONE = new BigInteger("1");
		BigInteger T = new BigInteger("1000000");
		
		BigInteger N_2 = new BigInteger("0");
		BigInteger N_1 = new BigInteger("1");
		
		if(N.equals(N_2)) System.out.println("0");
		else if(N.equals(N_1)) System.out.println("1");
		
		BigInteger temp = null;
		for(BigInteger i=new BigInteger("2");i.compareTo(N)<=0;i=i.add(ONE) ) {
			temp = N_2.add(N_1).mod(T);
			N_2 = N_1;
			N_1 = temp;
		}
		System.out.println(temp.toString());
	}
}
