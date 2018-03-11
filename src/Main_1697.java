

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main_1697 {
	static int N, K;
	static Queue<Integer> q;
	final static int MAX = 200001;
	static int[] dist = new int[MAX];
	
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		
		N = scan.nextInt();
		K = scan.nextInt();
		
		q = new ArrayDeque<Integer>(MAX);
		
		q.add(N);
		dist[N] = 0;
		while(!q.isEmpty()) {
			int now = q.poll();
			
			Loop1 : for(int i=0;i<3;i++) {
				int temp = 0;
				switch(i) {
				case 0:
					temp = now-1;
					if(temp < 0) continue Loop1;
					break;
				case 1:
					temp = now+1;
					if(temp >= MAX) continue Loop1;
					break;
				case 2:
					temp = now*2;
					if(temp >= MAX) continue Loop1;
					break;
				}
				
				if(dist[temp] == 0) {
					q.add(temp);
					dist[temp] = dist[now]+1;
				}
			}
		}
		System.out.println(dist[K]);
		scan.close();
	}
}
