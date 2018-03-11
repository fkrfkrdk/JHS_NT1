import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2775 {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			int[][] apart = new int[k][n];
			for(int i=1;i<=n;i++) {
				apart[0][i-1] = i;
			}
			
			int sum = 0;
			for(int j=1;j<k;j++) {
				sum = 0;
				for(int i=0;i<n;i++) {
					sum += apart[j-1][i];
					apart[j][i] = sum;
				}
			}
			
			int result = 0;
			for(int i=0;i<n;i++) {
				result += apart[k-1][i];
			}
			System.out.println(result);
		}
	}
}
