

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_1963 {
	final static int MAX = 10000;
	static boolean[] primes = new boolean[MAX];
	static int[] check = new int[MAX];
	static Queue<Integer> q = new LinkedList<Integer>();
	
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		setPrimes();
		
		for(int testCase=0;testCase<T;testCase++) {
			int input = scan.nextInt();
			int target = scan.nextInt();
			
			
			if(!primes[target]) {
				System.out.println("Impossible");
				continue;
			} else if(target == input) {
				System.out.println(0);
				continue;
			}
			
			q.add(input);
			check[input] = 1;
			int temp = 0;
			
			QueueLoop : while(!q.isEmpty()) {
				// check next queue item
				temp = q.remove();
				System.out.println(temp);
				
				// find & put next primes
				StringBuilder check_s = new StringBuilder(""+temp);
				StringBuilder temp_s;
				int temp_int;
				for(int digit=0;digit<4;digit++) {
					for(char i='0';i<='9';i++) {
						if(digit == 0 && i == '0') continue;
						temp_s = new StringBuilder(""+temp);
						temp_s.setCharAt(digit, i);
						temp_int = Integer.parseInt(temp_s.toString());
						
						if(check[temp_int]==0 && !temp_s.equals(check_s)) {
							q.add(temp_int);
							check[temp_int] = check[temp] + 1;
							if(temp_int == target) {
								System.out.println("\nHERE! : "+temp_int);
								System.out.println(check[temp_int]-1);
								break QueueLoop;
							}
						}
					}
				}
			}
		}
		scan.close();
	}
	
	private static void setPrimes() {
		for(int i=2;i<MAX;i++) {
			if(!primes[i]) {
				for(int j=i*i;j<MAX;j+=i) {
					primes[j] = true;
				}
			}
		}
		
		for(int i=0;i<MAX;i++) {
			primes[i] = !primes[i];
		}
	}
	
	private static LinkedList<Integer> nextPrimes(int input) {
		LinkedList<Integer> result = new LinkedList<Integer>();
		
		for(int digit=0;digit<4;digit++) {
			for(int i=0;i<=9;i++) {
				
			}
		}
		
		return result;
	}
}
