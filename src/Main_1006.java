import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1006 {
	private static int max;
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++) {
			String[] input_s = br.readLine().split(" ");
			int N = Integer.parseInt(input_s[0]);
			int W = Integer.parseInt(input_s[1]);
			int[][] area = new int[2][N];
			
			for(int i=0;i<2;i++) {
				input_s = br.readLine().split(" ");
				for(int j=0;j<N;j++) {
					area[i][j] = Integer.parseInt(input_s[j]);
				}
			}
			int[][] painted = new int[2][N];
			// paint init
			for(int i=0;i<2;i++) {
				for(int j=0;j<N;j++) {
					paintInit(i,j,W, area,painted);
				}
			}
			// paint(DP)
			max = Integer.MIN_VALUE;
			dfs(0,0,W, area,painted,0);
			
			System.out.println(2*(N-max)+max);
		}
	}
	
	private static void dfs(int x, int y, int w, int[][] area, int[][] painted, int count) {
		int[] nextP = nextPoint(x,y,painted);
		if(nextP == null) {
			max = Math.max(max, count);
			return;
		}
		
		int[][] temp_painted = copy(painted);
		temp_painted[x][y] = -3;
		nextP = nextPoint(x, y, temp_painted);
		if(nextP != null) dfs(nextP[0], nextP[1], w, area, temp_painted, count);  // not include this
		
		int thisValue = area[x][y];
		int N = area[0].length;
		
		count++;
		temp_painted = copy(painted);
		temp_painted[x][y] = count;
		if(y+1 < N) {
			if(area[x][y+1]+thisValue <= w) {
				temp_painted[x][y+1] = count;
				nextP = nextPoint(x, y, temp_painted);
				if(nextP != null) dfs(nextP[0], nextP[1], w, area, temp_painted, count);
			}
		} else {
			if(area[x][0]+thisValue <= w) {
				temp_painted[x][0] = count;
				nextP = nextPoint(x, y, temp_painted);
				if(nextP != null) dfs(nextP[0], nextP[1], w, area, temp_painted, count);
			}
		}
		
		if(x==0) {
			temp_painted = copy(painted);
			temp_painted[x][y] = count;
			if(area[x+1][y]+thisValue <= w) {
				temp_painted[x+1][y] = count;
				nextP = nextPoint(x, y, temp_painted);
				if(nextP != null) dfs(nextP[0], nextP[1], w, area, temp_painted, count);
			}
		}
	}
	
	private static int[] nextPoint(int x, int y, int[][] painted) {
		for(int i=x;i<2;i++) {
			for(int j=y+1;j<painted[0].length;j++) {
				if(painted[i][j] == -2) return new int[] {i,j};
			}
			y=-1;
		}
		return null;
	}
	/*
	private static void print(int[][] painted) {
		System.out.println("print painted");
		for(int i=0;i<2;i++) {
			for(int j=0;j<painted[0].length;j++) {
				System.out.print(painted[i][j] + " " + ((painted[i][j]<0)?"":" "));
			}
			System.out.println();
		}
	}*/
	
	private static void paintInit(int x, int y, int w, int[][] area, int[][] painted) {
		if(painted[x][y]!=0) return;
		boolean check = false;
		int thisValue = area[x][y];
		int N = area[0].length;
		int temp = 0;
		
		if(y-1>=0) temp = area[x][y-1];
		else temp = area[x][N-1];
		if(temp + thisValue <= w) check = true;
		if(y+1<N) temp = area[x][y+1];
		else temp = area[x][0];
		if(temp + thisValue <= w) check = true;
		if(x-1>=0 && area[x-1][y]+thisValue<=w) check = true;
		if(x+1<2 && area[x+1][y]+thisValue<=w) check = true;
		
		if(check) painted[x][y] = -2;
		else painted[x][y] = -1;
	}
	
	private static int[][] copy(int[][] painted) {
		int[][] result = new int[painted.length][painted[0].length];
		for(int i=0;i<painted.length;i++) {
			result[i] = painted[i].clone();
		}
		return result;
	}
}
