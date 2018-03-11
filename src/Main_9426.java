import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_9426 {
	private static int N, K;
	private static int[] data;
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		data = new int[N];
		for(int i=0;i<N;i++) {
			data[i] = Integer.parseInt(br.readLine());
		}
		LinkedList<Integer> sorted = new LinkedList<>();
		for(int i=0;i<K-1;i++) {
			sorted.add(data[i]);
			sorted.sort(null);
		}
		
		
		
	}
}
