

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.Scanner;

import javax.rmi.ssl.SslRMIClientSocketFactory;

public class Main_1722 {
	static int N;
	static BigInteger[] facto;
	static LinkedList<Integer> refer;
	
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		
		N = scan.nextInt();
		
		facto = new BigInteger[N];
		calcFact();
		
		refer = new LinkedList<Integer>();
		for(int i=1;i<=N;i++) {
			refer.add(i);
		}
		
		int prob = scan.nextInt();
		if(prob == 1) prob1(scan.nextBigInteger(), new StringBuilder());
		else {
			int[] input = new int[N];
			for(int i=0;i<N;i++) {
				input[i] = scan.nextInt();
			}
			prob2(input);
		}
		scan.close();
	}
	
	private static void prob1(BigInteger k, StringBuilder sb) {
		if(N == 1) {
			System.out.println(1);
			return;
		}
		int quotient = Integer.parseInt(k.divide(facto[N-1-sb.length()]).toString());
		BigInteger remainder = k.remainder(facto[N-1-sb.length()]);
		
		if(sb.length() == N-2) {
			
			sb.append(refer.removeFirst()).append(refer.removeLast());
			for(int i=0;i<sb.length();i++) {
				System.out.print(sb.charAt(i)+" ");
			}
		} else {
			prob1(remainder, sb.append(refer.remove(quotient)));
		}
	}
	
	private static void prob2(int[] input) {
		if(N == 1) {
			System.out.println(1);
			return;
		}
		BigInteger result = new BigInteger("1");
		
		for(int i=0;i<N-2;i++) {
			int t = 0;
			
			for(int j=0;j<refer.size();j++) {
				if(refer.get(j) == input[i]) t = j;
			}
			
			result = result.add(new BigInteger(""+t).multiply(facto[N-1-i]));
			refer.remove(t);
		}
		System.out.println(result);
	}
	
	private static void calcFact() {
		facto[0] = new BigInteger("1");
		
		for(int i=1;i<N;i++) {
			facto[i] = new BigInteger(""+i).multiply(facto[i-1]);
		}
	}
}