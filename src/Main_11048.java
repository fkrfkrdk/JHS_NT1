import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11048 {
	private static int N,M;
	private static int[][] maze,data;
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		maze = new int[N][M];
		data = new int[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0;j<M;j++) {
				maze[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		data[0][0] = maze[0][0];
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(i==0) {
					if(j==0) continue;
					data[i][j] = data[i][j-1]+maze[i][j];
				} else {
					if(j==0) data[i][j] = data[i-1][j]+maze[i][j];
					else {
						data[i][j] = Math.max(Math.max(data[i-1][j-1], data[i-1][j]),data[i][j-1])+maze[i][j];
					}
				}
			}
		}
		System.out.println(data[N-1][M-1]);
	}
}
