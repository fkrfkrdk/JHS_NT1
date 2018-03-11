

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_11053 {
	private static int N;
	private static int[] A;
	private static int[] D;
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		A = new int[N];
		D = new int[N];
		D[0] = 1;
		String[] input = br.readLine().split(" ");
		for(int i=0;i<N;i++) {
			A[i] = Integer.parseInt(input[i]);
		}
		
		for(int i=0;i<N;i++) {
			int temp = 1;
			for(int j=0;j<i;j++) {
				temp = Math.max(A[j]<A[i]?D[j]+1:1,temp);
			}
			D[i] = temp;
		}
		
		int result = 0;
		for(int i=0;i<N;i++) {
			result = Math.max(result, D[i]);
		}
		System.out.println(result);
	}
}
