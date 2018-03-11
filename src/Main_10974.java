

import java.util.Scanner;

public class Main_10974 {
	public static void main(String args[]) throws Exception {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int[] input = new int[N];
		// init input array
		for(int i=0;i<N;i++) {
			input[i] = i+1;
		}
		
		StringBuilder result = new StringBuilder(intAtoString(input));
		try {
			while(true) {
				input = nextPermutation(input);
				result.append(intAtoString(input));
			}
		} catch(PerException p) {
			System.out.println(result);
		}
		scan.close();
	}
	
	private static String intAtoString(int[] array) {
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<array.length;i++) {
			sb.append(array[i]+(i!=array.length-1?" ":"\n"));
		}
		return sb.toString();
	}
	
	static int[] nextPermutation(int[] input) throws PerException {
		int N = input.length;
		
		if(N>1) {
			int temp = input[N-1];
			int index_largest = N-2;
			while(temp < input[index_largest]) {
				temp = input[index_largest];
				if(index_largest==0) break;
				index_largest--;
			}
			
			if(temp == input[0]) throw new PerException();
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
			}
		} else {
			throw new PerException();
		}
		return input;
	}
}

class PerException extends Exception {
	
}
