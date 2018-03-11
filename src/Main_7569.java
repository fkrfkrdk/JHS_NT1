import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_7569 {
	private static int M,N,H;
	private static int[][][] data, counts;
	private static int[][] diff = {{0,0,1},{0,0,-1},{0,1,0},{0,-1,0},{1,0,0},{-1,0,0}};
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		data = new int[H][N][M];
		counts = new int[H][N][M];
		Queue<int[]> que = new LinkedList<>();
		for(int h=0;h<H;h++) {
			for(int n=0;n<N;n++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int m=0;m<M;m++) {
					int temp = Integer.parseInt(st.nextToken());
					if(temp == 1) que.add(new int[] {h,n,m});
					data[h][n][m] = temp;
				}
			}
		}
		
		while(!que.isEmpty()) {
			int[] cur = que.poll();
			int c = counts[cur[0]][cur[1]][cur[2]]+1;
			
			for(int i=0;i<6;i++) {
				int[] newd = {cur[0]+diff[i][0], cur[1]+diff[i][1], cur[2]+diff[i][2]};
				if(newd[0]<0 || newd[1]<0 || newd[2]<0 || newd[0]>=H || newd[1]>=N || newd[2]>=M) continue;
				if(data[newd[0]][newd[1]][newd[2]] == 0) {
					data[newd[0]][newd[1]][newd[2]] = 1;
					counts[newd[0]][newd[1]][newd[2]] = c;
					que.add(newd);
				}
			}
		}
		
		for(int h=0;h<H;h++) {
			for(int n=0;n<N;n++) {
				for(int m=0;m<M;m++) {
					if(data[h][n][m] == 0) {
						System.out.println(-1);
						System.exit(0);
					}
				}
			}
		}
		
		int max = 0;
		for(int h=0;h<H;h++) {
			for(int n=0;n<N;n++) {
				for(int m=0;m<M;m++) {
					if(counts[h][n][m]>max) max = counts[h][n][m]; 
				}
			}
		}
		System.out.println(max);
	}
}
