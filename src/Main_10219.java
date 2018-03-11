import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_10219 {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++) {
			String[] input_s = br.readLine().split(" ");
			int H = Integer.parseInt(input_s[0]);
			int W = Integer.parseInt(input_s[1]);
			char[][] plate = new char[H][W];
			char[][] new_plate = new char[H][W];
			for(int h=0;h<H;h++) {
				String input_temp = br.readLine();
				for(int w=0;w<W;w++) {
					plate[h][w] = input_temp.charAt(w);
				}
			}
			
			
		}
	}
	
	private static void dfs(int count, ) {
		
	}
}
