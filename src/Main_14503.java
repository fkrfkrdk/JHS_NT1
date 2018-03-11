import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_14503 {
	private static int N, M, count = 0;
	private static int[][] plate;
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input_s = br.readLine().split(" ");
		N = Integer.parseInt(input_s[0]);
		M = Integer.parseInt(input_s[1]);
		plate = new int[N][M];
		input_s = br.readLine().split(" ");
		int r, c, d;
		r = Integer.parseInt(input_s[0]);
		c = Integer.parseInt(input_s[1]);
		d = Integer.parseInt(input_s[2]);
		
		for(int i=0;i<N;i++) {
			input_s = br.readLine().split(" ");
			for(int j=0;j<M;j++) {
				plate[i][j] = Integer.parseInt(input_s[j]);
			}
		}
		
		sweeping(r,c,d);
		System.out.println(count);
	}
	
	private static void sweeping(int r, int c, int d) {
		int[] temp = {r,c};
		int temp_d = d;
		while(true) {
			if(checkCanGo(temp)==1) break;
			if(plate[temp[0]][temp[1]] == 0) {
				count++;
				plate[temp[0]][temp[1]] = 2;
			}
			int checkDir = nextUnvisitedDir(temp[0], temp[1], temp_d);
			if(checkDir == -1) {
				if(checkOppositePos(temp[0], temp[1], temp_d)) {
					temp = oppositePos(temp[0], temp[1], temp_d);
				} else return;
			} else {
				temp_d = checkDir;
				temp = directlyPos(temp[0],temp[1],temp_d);
			}
		}
	}
	
	private static int nextUnvisitedDir(int r, int c, int d) {
		int tempDir = d;
		int[] temp = {r,c};
		boolean flag = true;
		while(true) {
			tempDir = nextDir(tempDir);
			if(tempDir == d) flag = false;
			if(checkCanGo(directlyPos(temp[0],temp[1],tempDir)) == 0) break;
			else if(!flag && tempDir == nextDir(d)) return -1;
		}
		return tempDir;
	}
	
	private static int nextDir(int d) {
		if(d==0) return 3;
		else return d-1;
	}
	
	private static boolean checkOppositePos(int r, int c, int d) {
		int[] pos = oppositePos(r, c, d);
		if(checkCanGo(r,c) == 1) return false;
		else return true;
	}
	
	private static int[] oppositePos(int r, int c, int d) {
		int[] result = {r,c};
		switch(d) {
		case 0:
			result[0]++;
			break;
		case 1:
			result[1]--;
			break;
		case 2:
			result[0]--;
			break;
		case 3:
			result[1]++;
			break;
		}
		return result;
	}
	
	private static int[] directlyPos(int r,int c, int d) {
		int[] result = new int[2];
		switch(d) {
		case 0:
			result[0] = r-1;
			result[1] = c;
			break;
		case 1:
			result[0] = r;
			result[1] = c+1;
			break;
		case 2:
			result[0] = r+1;
			result[1] = c;
			break;
		case 3:
			result[0] = r;
			result[1] = c-1;
			break;
		}
		return result;
	}
	
	private static int checkCanGo(int[] input) {
		return checkCanGo(input[0], input[1]);
	}
	private static int checkCanGo(int r, int c) { // Wall or OutOfIndex : 1, Visited : 2, Unvisited : 0
		if(r<0 || r>=N || c<0 || c>=M) return 1;
		if(plate[r][c] == 2) return 2;
		else if(plate[r][c] == 1) return 1;
		else return 0;
	}
}
