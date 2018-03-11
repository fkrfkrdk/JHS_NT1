import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_6064 {
	public static void main(String arg[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		TestCase : for(int t=0;t<T;t++) {
			String[] input_s = br.readLine().split(" ");
			int M = Integer.parseInt(input_s[0]);
			int N = Integer.parseInt(input_s[1]);
			int x = Integer.parseInt(input_s[2]);
			int y = Integer.parseInt(input_s[3]);
			
			int result = 0;
			if(M == N) {
				if(x==y) result = x;
				else result = -1;
			} else {
				if(M > N) {
					int temp = N;
					N = M;
					M = temp;
					temp = y;
					y = x;
					x = temp;
				}
				
				int sum = 0;
				int temp_m = 0;
				int temp_n = 0;
				
				while(true) {
					temp_m = sum%M;
					temp_n = sum%N;
					
					if(temp_n-temp_m == y-x) break;
					if(sum!=0 && temp_m == 0 && temp_n == 0) {
						System.out.println(-1);
						continue TestCase;
					}
					temp_m = M - temp_m;
					temp_n = N - temp_n;
					sum += temp_m < temp_n ? temp_m : temp_n;
				}
				sum += Math.min(x, y);
				result = sum;
			}
			System.out.println(result);
		}
	}
}
