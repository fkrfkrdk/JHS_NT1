import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1012 {
	private static int N,M;
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++) {
			String[] temp = br.readLine().split(" ");
			M = Integer.parseInt(temp[0]);
			N = Integer.parseInt(temp[1]);
			int K = Integer.parseInt(temp[2]);
			
			int[][] place = new int[N][M];
			int count = 0;
			for(int k=0;k<K;k++) {
				temp = br.readLine().split(" ");
				place[Integer.parseInt(temp[1])][Integer.parseInt(temp[0])] = -1;
			}
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(place[i][j] == -1) fill(i,j, place, ++count);
				}
			}
			System.out.println(count);
		}
	}
	
	private static void fill(int x, int y, int[][] p, int count) {
		if(x<0 || x>=N || y<0 || y>=M) {
			return;
		}
		if(p[x][y] == -1) {
			p[x][y] = count;
			fill(x+1,y,p,count);
			fill(x-1,y,p,count);
			fill(x,y-1,p,count);
			fill(x,y+1,p,count);
		}
	}
}
