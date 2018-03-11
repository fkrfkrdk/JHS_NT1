

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_7975 {
	private static int N;
	private static int M;
	private static int[][] age;
	private static int[][] point;
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().split(" ");
		N = Integer.parseInt(temp[0]);
		M = Integer.parseInt(temp[1]);
		age = new int[N][M];
		point = new int[N][M];
		for(int i=0;i<N;i++) {
			temp = br.readLine().split(" ");
			for(int j=0;j<M;j++) {
				age[i][j] = Integer.parseInt(temp[j]);
			}
		}
		for(int i=0;i<N;i++) {
			temp = br.readLine().split(" ");
			for(int j=0;j<M;j++) {
				point[i][j] = Integer.parseInt(temp[j]);
			}
		}
		System.out.println("!!!!");
		
		int curAge = 0;
		int result = 0;
		boolean[][] firstAges = nextAgeCheck(curAge);
		while(true) {
			int[] cur = findNextNM(0,0,firstAges);
			if(cur==null) break;
			int[][] map = new int[N][M];
			result = Math.max(calc(cur[0],cur[1],map),result); // 현재 시작점에서 끝까지 가면서 map에 최대값 저장
		}
		System.out.println(result);
	}
	
	private static int calc(int cur_n,int cur_m,int[][] map) {
		int[] curNM = {cur_n, cur_m};
		int curAge = age[cur_n][cur_m];
		boolean saveNextAge = false;
		boolean[][] checkedNextAge = nextAgeCheck(curAge);
		while(checkedNextAge != null) {
			int[] nextNM = findNextNM(0,0,checkedNextAge);
			while(nextNM != null) {
				if(!saveNextAge) {
					curAge = nextAge(curAge);
					saveNextAge = true;
				}
				map[nextNM[0]][nextNM[1]] = dist(cur_n,cur_m,nextNM[0],nextNM[1])+point[nextNM[0]][nextNM[1]];
				nextNM = findNextNM(nextNM[0],nextNM[1],checkedNextAge);
			}
			checkedNextAge = nextAgeCheck(curAge);
		}
		
		int max = 0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				max = Math.max(max, map[i][j]);
			}
		}
		return max;
	}
	
	private static int dist(int cur_n,int cur_m,int next_n,int next_m) {
		return 100*(Math.abs(cur_n-next_n)+Math.abs(cur_m-next_m));
	}
	
	private static boolean[][] nextAgeCheck(int curAge) {
		int nextAge = nextAge(curAge);
		if(nextAge == -1) return null;
		boolean[][] nexts = new boolean[N][M];
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(age[i][j] == nextAge) nexts[i][j] = true;
			}
		}
		return nexts;
	}
	
	private static int nextAge(int curAge) { // if end, return -1
		int next = curAge;
		boolean setNext = false;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(!setNext && next<age[i][j]) {
					setNext = true;
					next = age[i][j];
				} else if(next<age[i][j] && setNext) {
					next = Math.min(next, age[i][j]);
				}
			}
		}
		if(setNext) return next;
		else return -1;
	}
	
	private static int[] findNextNM(int cur_n,int cur_m,boolean[][] data) {
		int[] next_nm = new int[2];
		for(int i=cur_n;i<data.length;i++) {
			for(int j=cur_m;j<data[0].length;j++) {
				if(i==cur_n && j==cur_m && !(cur_n==0 && cur_m==0)) continue;
				if(data[i][j]) {
					next_nm[0] = i;
					next_nm[1] = j;
					return next_nm;
				}
			}
		}
		return null;
	}
}