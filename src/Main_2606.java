import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_2606 {
	private static int N,P;
	private static Computer[] computers;
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		P = Integer.parseInt(br.readLine());
		computers = new Computer[N+1];
		for(int i=1;i<=N;i++) {
			computers[i] = new Computer();
		}
		for(int i=0;i<P;i++) {
			st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			computers[a].links.add(b);
			computers[b].links.add(a);
		}
		
		visit(1);
		
		int count = -1;
		for(int i=1;i<=N;i++) {
			if(computers[i].visited) count++;
		}
		System.out.println(count);
	}
	
	private static void visit(int com_index) {
		Computer cur = computers[com_index];
		cur.visited = true;
		for(int i=0;i<cur.links.size();i++) {
			int temp = cur.links.get(i);
			if(computers[temp].visited) continue;
			else visit(temp);
		}
	}
	
	private static class Computer {
		ArrayList<Integer> links = new ArrayList<>();
		boolean visited = false;
	}
}
