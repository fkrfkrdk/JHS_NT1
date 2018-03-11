import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10875 {
	private static int L, time = 0;
	private static Snake dir;
	private static boolean[][] plate;
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		L = Integer.parseInt(br.readLine());
		dir = new Snake(L);
		int N = Integer.parseInt(br.readLine());
		plate = new boolean[2*L+1][2*L+1];
		plate[L][L] = true;
		Loop : for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int times = Integer.parseInt(st.nextToken());
			for(int t=0;t<times;t++) {
				printP();
				System.out.println();
				time++;
				dir.cur_x += dir.dir_x;
				dir.cur_y += dir.dir_y;
				if(dir.cur_x<0 || dir.cur_x>=plate.length || dir.cur_y<0 || dir.cur_y>=plate.length) break Loop;
				if(!plate[dir.cur_x][dir.cur_y]) {
					plate[dir.cur_x][dir.cur_y] = true;
				} else {
					break Loop;
				}
			}
			if(st.nextToken().charAt(0) == L) {
				dir.turnLeft();
			} else {
				dir.turnRight();
			}
		}
		System.out.println(time);
	}
	
	private static void printP() {
		for(int i=0;i<plate.length;i++) {
			for(int j=0;j<plate.length;j++) {
				System.out.print(plate[i][j]?1:0);
			}
			System.out.println();
		}
	}
}
/*
class Snake {
	int cur_x, cur_y;
	int dir_x = 0, dir_y = 1;
	
	Snake(int L) {
		cur_x = L;
		cur_y = L;
	}
	
	public void turnLeft() {
		if(dir_x == 0) {
			if(dir_y == 1) {
				dir_x = 1;
				dir_y = 0;
			} else {
				dir_x = -1;
				dir_y = 0;
			}
		} else if(dir_x == 1) {
			dir_x = 0;
			dir_y = -1;
		} else {
			dir_x = 0;
			dir_y = 1;
		}
	}
	
	public void turnRight() {
		if(dir_x == 0) {
			if(dir_y == 1) {
				dir_x = -1;
				dir_y = 0;
			} else {
				dir_x = 1;
				dir_y = 0;
			}
		} else if(dir_x == 1) {
			dir_x = 0;
			dir_y = 1;
		} else {
			dir_x = 0;
			dir_y = -1;
		}
	}
}*/