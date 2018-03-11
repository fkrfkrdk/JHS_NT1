

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1260 {
	private static int N, M, V;
	private static boolean[][] vs;
	private static boolean[] visited;
	private static StringBuilder dfs = new StringBuilder();
	private static StringBuilder bfs = new StringBuilder();
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken())-1;
		vs = new boolean[N][N];
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			vs[a][b] = true;
			vs[b][a] = true;
		}
		
		visited = new boolean[N];
		DFS(V);
		System.out.println(dfs);
		
		visited = new boolean[N];
		BFS(V);
		System.out.println(bfs);
		br.close();
	}
	
	private static void DFS(int v) {
		dfs.append(v+1).append(' ');
		visited[v] = true;
		
		for(int i=0;i<N;i++) {
			if(i == v) continue;
			if(vs[v][i] && !visited[i]) DFS(i);
		}
	}
	
	private static void BFS(int v) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(v);
		visited[v] = true;
		
		while(queue.size()>0) {
			int temp = queue.poll();
			bfs.append(temp+1).append(' ');
			for(int i=0;i<N;i++) {
				if(i == temp) continue;
				if(vs[temp][i] && !visited[i]) {
					queue.add(i);
					visited[i] = true;
				}
			}
		}
	}
}
