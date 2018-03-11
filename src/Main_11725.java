import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_11725 {
	private static int N;
	private static ArrayList<Integer>[] nodes;
	private static int[] visited;
	
	public static void main(String args[]) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		nodes = new ArrayList[N+1];
		for(int i=0;i<N+1;i++) {
			nodes[i] = new ArrayList<Integer>();
		}
		visited = new int[N+1];
		visited[1] = -1;
		
		for(int i=0;i<N-1;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			nodes[a].add(b);
			nodes[b].add(a);
		}
		
		visit(1);
		
		for(int i=2;i<nodes.length;i++) {
			sb.append(visited[i]).append('\n');
		}
		System.out.println(sb);
	}
	
	private static void visit(int cur) {
		for(int i=0;i<nodes[cur].size();i++) {
			if(visited[nodes[cur].get(i)] == 0) {
				visited[nodes[cur].get(i)] = cur;
				visit(nodes[cur].get(i));
			}
		}
	}
}
