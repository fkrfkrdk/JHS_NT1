

import java.util.Scanner;

public class Main_1912 {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int[] input = new int[N];
		for(int i=0;i<N;i++) {
			input[i] = scan.nextInt();
		}
		
		int max = Integer.MIN_VALUE;
		int sum = 0;
		for(int i=0;i<N;i++) {
			sum += input[i];
			max = Math.max(max, sum);
			if(sum<0) sum = 0;
		}
		System.out.println(max);
		scan.close();
	}
}