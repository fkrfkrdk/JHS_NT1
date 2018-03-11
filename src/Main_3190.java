import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_3190 {
	private static int N, K, L;
	private static int[][] plate;
	private static Snake s = new Snake();
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		plate = new int[N][N];
		plate[0][0] = 1;
		
		int apple_x, apple_y;
		for(int i=0;i<K;i++) {
			st = new StringTokenizer(br.readLine()," ");
			apple_x = Integer.parseInt(st.nextToken())-1;
			apple_y = Integer.parseInt(st.nextToken())-1;
			plate[apple_x][apple_y] = -1;
		}
		
		L = Integer.parseInt(br.readLine());
		for(int l=0;l<L;l++) {
			st = new StringTokenizer(br.readLine()," ");
			int t = Integer.parseInt(st.nextToken());
			while(t>=0) {
				
				t--;
			}
			
			char c = st.nextToken().charAt(0);
			if(c=='L') s.turnLeft();
			else s.turnRight();
		}
	}
	
	
	private static class Snake {
		int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};
		int cur_dir = 1, head_x=0, head_y=0, length=1;
		LinkedList<int[]> turned = new LinkedList<>();
		{
			turned.add(new int[] {1,1,1,-1});
		}
		
		private void forward(int n, int[][] plate) {
			head_x += dir[cur_dir][0]*n;
			head_y += dir[cur_dir][1]*n;
			
		}
		
		private void turnLeft() {
			if(cur_dir == 0) cur_dir = 3;
			else cur_dir -= 1;
			addTurn();
		}
		private void turnRight() {
			if(cur_dir == 3) cur_dir = 0;
			else cur_dir += 1;
			addTurn();
		}
		
		private void addTurn() {
			int diff = 0;
			int[] before = turned.getLast();
			if(before == null) {
				diff = -1;
			} else {
				if(before[2]%2==0) diff += Math.abs(head_x-before[0]);
				else diff += Math.abs(head_y-before[1]);
			}
			turned.add(new int[] {head_x,head_y,cur_dir,diff});
		}
	}
}
