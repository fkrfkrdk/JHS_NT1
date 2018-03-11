

import java.math.BigInteger;
import java.util.Scanner;

public class Main_11561 {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		
		int T = Integer.parseInt(scan.nextLine());
		
		for(int i=0;i<T;i++) {
			BigInteger N = new BigInteger(""+scan.nextLine());
			if(N.compareTo(new BigInteger("1"))==0) {
				System.out.println(1);
				continue;
			}
			
			BigInteger temp = new BigInteger("0");
			BigInteger step = new BigInteger("0");
			while(true) {
				int comp = temp.compareTo(N);
				if(comp>0) break;
				else {
					temp = temp.add(step);
					step = step.add(new BigInteger("1"));
				}
			}
			
			System.out.println(step.subtract(new BigInteger("2")));
		}
		scan.close();
	}
}
