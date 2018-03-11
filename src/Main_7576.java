import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_7576 {
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[][] data = new int[N][M];
		int[][] counts = new int[N][M];
		boolean able = false;
		boolean all = true;
		Queue<int[]> que = new LinkedList<int[]>();
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<M;j++) {
				int temp = Integer.parseInt(st.nextToken());
				if(temp == 1) {
					able = true;
					que.offer(new int[] {i,j});
				} else {
					all = false;
				}
				data[i][j] = temp;
			}
		}
		
		if(!able) {
			System.out.println(-1);
			System.exit(0);
		}
		if(all) {
			System.out.println(0);
			System.exit(0);
		}
		
		while(!que.isEmpty()) {
			int[] temp = que.poll();
			int c = counts[temp[0]][temp[1]]+1;
			
			for(int d=0;d<4;d++) {
				int new_x = temp[0]+dir[d][0];
				int new_y = temp[1]+dir[d][1];
				if(new_x<0 || new_x>=N || new_y<0 || new_y>=M) continue;
				if(data[new_x][new_y] == 0) {
					data[new_x][new_y] = 1;
					counts[new_x][new_y] = c;
					que.add(new int[] {new_x,new_y});
				}
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(data[i][j] == 0) {
					System.out.println(-1);
					System.exit(0);
				}
			}
		}
		
		int max = 0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				max = Math.max(max, counts[i][j]);
			}
		}
		System.out.println(max);
	}
}
