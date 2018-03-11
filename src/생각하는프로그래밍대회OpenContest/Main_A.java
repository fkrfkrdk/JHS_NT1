package 생각하는프로그래밍대회OpenContest;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_A {
	private static int M, N;
	private static int[][] flag;
	private static int colors = 0;
	public static void main(String ags[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().split(" ");
		M = Integer.parseInt(temp[0]);
		N = Integer.parseInt(temp[1]);
		flag = new int[M][N];
		for(int i=0;i<M;i++) {
			temp = br.readLine().split(" ");
			for(int j=0;j<N;j++) {
				flag[i][j] = temp[j].equals("1")?-1:0;
			}
		}
		
		for(int i=0;i<M;i++) {
			for(int j=0;j<N;j++) {
				if(flag[i][j] == -1)
					paint(i,j,0);
			}
		}
		System.out.println(colors);
		
	}
	private static void paint(int m, int n,int color) {
		if(color == 0) {
			paint(m,n,++colors);
			return;
		}
		flag[m][n] = color;
		if(n>0) {
			if(flag[m][n-1]==-1) paint(m,n-1,color);
			if(m<M-1) if(flag[m+1][n-1]==-1) paint(m+1,n-1,color);
		}
		if(m>0) {
			if(flag[m-1][n]==-1) paint(m-1,n,color);
			if(n<N-1) if(flag[m-1][n+1]==-1) paint(m-1,n+1,color);
			if(n>0) if(flag[m-1][n-1]==-1) paint(m-1,n-1,color);
		}
		if(n<N-1) {
			if(flag[m][n+1]==-1) paint(m,n+1,color);
			if(m<M-1) if(flag[m+1][n+1]==-1) paint(m+1,n+1,color);
			
		}
		if(m<M-1) if(flag[m+1][n]==-1) paint(m+1,n,color);
	}
}
