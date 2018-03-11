import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10451 {
	private static int[] data;
	private static boolean[] checked;
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			data = new int[N+1];
			checked = new boolean[N+1];
			for(int i=1;i<=N;i++) {
				data[i] = Integer.parseInt(st.nextToken());
			}
			
			int count = 0;
			for(int i=1;i<=N;i++) {
				if(!checked[i]) {
					count++;
					setting(i);
				}
			}
			System.out.println(count);
		}
	}
	private static void setting(int i) {
		checked[i] = true;
		if(data[i] != i && !checked[data[i]]) setting(data[i]);
	}
}
