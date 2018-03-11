import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main_14502 {
	private static int N,M;
	private static int[][] origin;
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input_s = br.readLine().split(" ");
		N = Integer.parseInt(input_s[0]);
		M = Integer.parseInt(input_s[1]);
		origin = new int[N][M];
		for(int i=0;i<N;i++) {
			input_s = br.readLine().split(" ");
			for(int j=0;j<M;j++) {
				origin[i][j] = Integer.parseInt(input_s[j]);
			}
		}
		
		posWall();
	}
	
	private static void posWall() {
		int[][] tempMap = cloneMap(origin);
		ArrayList<int[]> list = new ArrayList<>();
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(tempMap[i][j] == 0) {
					int[] t = {i, j};
					list.add(t);
				}
			}
		}
		
		int max_count = 0;
		
		for(int i=0;i<list.size();i++) {
			for(int j=i+1;j<list.size();j++) {
				for(int k=j+1;k<list.size();k++) {
					tempMap = cloneMap(origin);
					tempMap[list.get(i)[0]][list.get(i)[1]] = 3;
					tempMap[list.get(j)[0]][list.get(j)[1]] = 3;
					tempMap[list.get(k)[0]][list.get(k)[1]] = 3;
					
					int safeCount = countSafe(infect(cloneMap(tempMap)));
					max_count = Math.max(max_count, safeCount);
				}
			}
		}
		System.out.println(max_count);
	}
	
	private static int countSafe(int[][] map) {
		int count = 0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j] == 0) count++;
			}
		}
		return count;
	} 
	
	private static int[][] infect(int[][] map) {
		Queue<int[]> que = new LinkedList<int[]>();
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j] == 2) {
					int[] t = {i,j};
					que.offer(t);
				}
			}
		}
		
		while(!que.isEmpty()) {
			int[] cur = que.poll();
			if(--cur[0]>=0) {
				checkPosAdd(cur,map,que);
			}
			++cur[0];
			if(++cur[0]<N) {
				checkPosAdd(cur,map,que);
			}
			--cur[0];
			if(--cur[1]>=0) {
				checkPosAdd(cur,map,que);
			}
			++cur[1];
			if(++cur[1]<M) {
				checkPosAdd(cur,map,que);
			}
			--cur[1];
		}
		return map;
	}
	
	private static void checkPosAdd(int[] input, int[][] map, Queue<int[]> que) {
		if(map[input[0]][input[1]] == 0) {
			map[input[0]][input[1]] = 2;
			que.offer(input.clone());
		}
	}
	
	private static int[][] cloneMap(int[][] map) {
		int[][] result = new int[N][M];
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				result[i][j] = map[i][j];
			}
		}
		return result;
	}
}
