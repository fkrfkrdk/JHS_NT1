

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main_1644 {
	static int N;
	static LinkedList<Integer> primes = new LinkedList<Integer>();
	static int result = 0;
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine()); // N >= 2
		
		if(isPrime(N)) result++;
		
		LinkedList<Integer> temps = new LinkedList<Integer>();
		temps.add(nextPrime(N/2));
		int temp_sum = temps.getLast();
		while(true) {
			System.out.println("temp_sum:"+temp_sum);
			if(temp_sum >= N) {
				if(temp_sum == N) result++;
				temp_sum -= temps.getFirst();
				temps.removeFirst();
			} else if(temp_sum < N) {
				int prev = prevPrime(temps.getLast());
				if(prev == -1) break;
				temps.add(prev);
				temp_sum += prev;
			}
		}
		System.out.println(result);
	}
	private static boolean isPrime(int input) {
		if(input == 2) return true;
		if(input%2==0) return false;
		
		int temp = (int)Math.sqrt(input);
		
		for(int i=3;i<=(temp%2==0 ? temp+1:temp);i-=2) {
			if(input%temp==0) return false;
		}
		
		return true;
	}
	
	private static int prevPrime(int prime) { //prime >= 3
		if(prime <= 2) return -1;
		if(prime == 3) return 2;
		
		while(true) {
			prime -=2;
			if(isPrime(prime)) return prime;
		}
	}
	
	private static int nextPrime(int num) { //num >=1
		if(num<2) return 2;
		else if(num == 2) return 3;
		if(isPrime(num)) nextPrime(num+1);
		
		num = num%2==0 ? num+1:num+2;
		
		while(true) {
			if(isPrime(num)) return num;
			num += 2;
		}
	}
}
