import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2606_2 {
	private static int N, P;
	private static int[] data;
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		P = Integer.parseInt(br.readLine());
		data = new int[N+1];
		for(int i=1;i<=N;i++) {
			data[i] = i;
		}
		StringTokenizer st = null;
		int a, b;
		for(int i=0;i<P;i++) {
			st = new StringTokenizer(br.readLine()," ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			calc(a,b);
		}
		for(int i=1;i<=N;i++) {
			find(i);
		}
		int count = 0;
		for(int i=2;i<=N;i++) {
			if(data[i] == 1) count++;
		}
		System.out.println(count);
	}
	
	private static int find(int n) {
		if(data[n] == n) return n;
		int t = find(data[n]);
		data[n] = t;
		return t;
	}
	
	private static void calc(int a, int b) {
		int x = find(a);
		int y = find(b);
		if(x>y) {
			data[x] = y;
		} else {
			data[y] = x;
		}
	}
}
