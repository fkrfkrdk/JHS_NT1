import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2292 {
	private static long N;
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Long.parseLong(br.readLine());
		br.close();
		if(N == 1) {
			System.out.println(0);
			System.exit(0);
		}
		
		long temp = N-1;
		int count = 1;
		while(temp > 0) {
			temp -= 6*count;
			count++;
		}
		
		System.out.println(count-1);
	}
}
