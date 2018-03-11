

import java.util.Scanner;

public class Main_10973 {
	public static void main(String args[]) throws Exception {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int[] input = new int[N];
		for(int i=0;i<N;i++) {
			input[i] = scan.nextInt();
		}
		StringBuilder result = new StringBuilder();
		
		if(N>1) {
			int temp = input[N-1];
			int index_smallgest = N-2;
			while(temp > input[index_smallgest]) {
				temp = input[index_smallgest];
				if(index_smallgest==0) break;
				index_smallgest--;
			}
			
			if(temp == input[0]) result.append("-1");
			else {
				int index_smaller = N-1;				
				temp = input[index_smallgest];
				while(temp < input[index_smaller]) {
					index_smaller--;
				}
				input[index_smallgest] = input[index_smaller];
				input[index_smaller] = temp;
				
				// reverse
				for(int i=1;i<=(N-1-index_smallgest)/2;i++) {
					temp = input[index_smallgest+i];
					input[index_smallgest+i] = input[N-i];
					input[N-i] = temp;
				}
				
				// write
				for(int i=0;i<N;i++) {
					result.append(input[i]+(i!=N-1?" ":""));
				}
			}
		} else {
			result.append("-1");
		}
		System.out.println(result);
		scan.close();
	}
}
