

import java.util.Scanner;

public class Main_10972 {
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
			int index_largest = N-2;
			while(temp < input[index_largest]) {
				temp = input[index_largest];
				if(index_largest==0) break;
				index_largest--;
			}
			
			if(temp == input[0]) result.append("-1");
			else {
				int index_larger = N-1;				
				temp = input[index_largest];
				while(temp > input[index_larger]) {
					index_larger--;
				}
				input[index_largest] = input[index_larger];
				input[index_larger] = temp;
				
				// reverse
				for(int i=1;i<=(N-1-index_largest)/2;i++) {
					temp = input[index_largest+i];
					input[index_largest+i] = input[N-i];
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
	}
}
