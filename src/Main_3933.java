import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_3933 {
	private static long[] powers = new long[(int)Math.sqrt(2<<15)+2];
	private static int[][] data = new int[2<<15+1][4];
	static {
		for(int i=0;i<powers.length;i++) {
			powers[i] = (long)i*(long)i;
		}
		data[1] = new int[] {1, 0, 0, 0};
		data[2] = new int[] {0, 1, 0, 0};
		data[3] = new int[] {0, 0, 1, 0};
		data[4] = new int[] {1, 0, 1, 0};
		
		for(int n=5;n<data.length;n++) {
			// check square root
			int sqr = (int)Math.sqrt(n);
			if(powers[sqr] == n) data[n][1]++;
			
			// check unders
			for(int u=n-1;u>=(n%2==0?n/2:n/2+1);u--) {
				int op = n-u;
				data[n][1] += data[u][0] * data[op][0];
				data[n][2] += data[u][0]*data[op][1] + data[u][1]*data[op][0];
			}
		}
	}
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int input = Integer.parseInt(br.readLine());
		
		while(input != 0) {
			
			
			
			input = Integer.parseInt(br.readLine());
		}
	}
}
