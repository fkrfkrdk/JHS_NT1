

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;

public class Main_14492 {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		boolean[] A = new boolean[N*N];
		boolean[] B = new boolean[N*N];
		int result = 0;
		
		for(int i=0;i<N;i++) {
			String[] temp = br.readLine().split(" ");
			for(int j=0;j<N;j++) {
				A[N*i+j] = temp[j].equals("1")? true : false;
			}
		}
		for(int i=0;i<N;i++) {
			String[] temp = br.readLine().split(" ");
			for(int j=0;j<N;j++) {
				B[N*i+j] = temp[j].equals("1")? true : false;
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N*N;j++) {
				if((A[N*i+j%N] & B[N*(j%N)+(j/N)])==true) {
					result++;
					j = (j/N+1)*N-1;
				}
			}
		}
		System.out.println(result);
	}
}
