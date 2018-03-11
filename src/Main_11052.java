import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11052 {
	private static int[] dp;
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] prices = new int[N+1];
		dp = new int[N+1];
		for(int i=1;i<=N;i++) {
			prices[i] = Integer.parseInt(st.nextToken());
		}
		for(int i=1;i<=N;i++) {
			int temp_max = prices[i];
			for(int j=1;j<=i/2;j++) {
				temp_max = Math.max(temp_max, dp[i-j]+dp[j]);
			}
			dp[i] = temp_max;
		}
		System.out.println(dp[N]);
	}
}
