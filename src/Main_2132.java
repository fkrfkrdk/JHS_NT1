import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_2132 {
	private static int N;
	private static int[] fruits;
	private static LinkedList<Integer>[] links;
	private static HashMap<String,Boolean> visited_ORIGIN, visited;
	private static boolean[] visitedLeaf;
	private static int max_sum = Integer.MIN_VALUE;
	private static int max_start = Integer.MAX_VALUE;
	
	@SuppressWarnings("unchecked")
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		visitedLeaf = new boolean[N+1];
		fruits = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=1;i<=N;i++) {
			fruits[i] = Integer.parseInt(st.nextToken());
		}
		//visited_ORIGIN = new HashMap<>();
		links = new LinkedList[N+1];
		for(int i=0;i<links.length;i++) {
			links[i] = new LinkedList<Integer>();
		}
		
		for(int i=1;i<N;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(!links[a].contains(b)) links[a].add(b);
			if(!links[b].contains(a)) links[b].add(a);
			visited_ORIGIN.put(make(a,b), false);
		}
		
		for(int i=1;i<=N;i++) {
			if(links[i].size()>1) continue;
			else if(visitedLeaf[i]) continue;
			visited = copyMap(visited_ORIGIN);
			Stack<Integer> stk = new Stack<>();
			visit(stk, i, 0, i);
		}
		
		System.out.println(max_sum+" "+max_start);
	}
	private static void visit(Stack<Integer> stk, int visitNode, int temp_sum, int started) {
		System.out.println("visit : "+visitNode);
		stk.push(visitNode);
		temp_sum += fruits[visitNode];
		
		LinkedList<Integer> l = links[visitNode];
		
		boolean poss = false;
		if(l.size()>0) {
			for(int i:l) {
				String t = make(i, visitNode);
				if(visited.get(t)) continue;
				else {
					if(visitedLeaf[i]) continue;
					poss = true;
					visited.put(t, true);
					visit(stk,i,temp_sum, started);
					if(l.size()==1) {
						System.out.println("changedLeaf :" + visitNode);
						visitedLeaf[visitNode] = true;
					}
				}
			}
		}
		if(!poss) {
			if(max_sum < temp_sum) {
				max_sum = temp_sum;
				max_start = started;
			} else if(max_sum == temp_sum) {
				max_start = Math.min(max_start, started);
			}
		}
		int ind = stk.pop();
		visited.put(make(ind, visitNode), false);
	}
	
	private static String make(int a, int b) {
		StringBuilder sb = new StringBuilder();
		if(a<b) return sb.append(a).append(" ").append(b).toString();
		return sb.append(b).append(" ").append(a).toString();
	}
	
	private static HashMap<String, Boolean> copyMap(HashMap<String, Boolean> map) {
		HashMap<String, Boolean> newMap = new HashMap<>();
		Iterator<String> it = map.keySet().iterator();
		while(it.hasNext()) {
			newMap.put(it.next().toString(), false);
		}
		return newMap;
	}
}