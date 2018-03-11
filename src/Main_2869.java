import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2869 {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		
		int unit = A-B;
		int cnt = 0;
		
		int cur = V;
		while(true) {
			if(cur>A) {
				cur -= unit;
				cnt++;
			} else {
				cnt++;
				break;
			}
		}
		System.out.println(cnt);
	}
}
