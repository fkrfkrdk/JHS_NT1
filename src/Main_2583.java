import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main_2583 {
	private static int M, N, K;
	private static int[][] plate;
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input_s = br.readLine().split(" ");
		M = Integer.parseInt(input_s[0]);
		N = Integer.parseInt(input_s[1]);
		K = Integer.parseInt(input_s[2]);
		plate = new int[N][M];
		
		
		for(int i=0;i<K;i++) {
			input_s = br.readLine().split(" ");
			int a_x = Integer.parseInt(input_s[0]);
			int a_y = Integer.parseInt(input_s[1]);
			int b_x = Integer.parseInt(input_s[2]);
			int b_y = Integer.parseInt(input_s[3]);
			
			for(int x=a_x;x<b_x;x++) {
				for(int y=a_y;y<b_y;y++) {
					plate[x][y] = -1;
				}
			}
		}
		
		ArrayList<Integer> list = new ArrayList<>();
		int count = 0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(plate[i][j] == 0) {
					list.add(paint(i, j, ++count)); 
				}
			}
		}
		Object[] result = list.toArray();
		Arrays.sort(result);
		StringBuilder sb = new StringBuilder(""+count).append('\n');
		for(int i=0;i<result.length;i++) {
			sb.append(result[i]).append(' ');
		}
		System.out.println(sb);
	}
	
	private static int paint(int x, int y, int count) {
		if(x<0 || x>=N || y<0 || y>=M) return 0;
		if(plate[x][y] != 0) return 0;
		plate[x][y] = count;
		return 1+paint(x-1,y, count)+paint(x,y-1,count)+paint(x+1,y, count)+paint(x,y+1, count);
	}
}
