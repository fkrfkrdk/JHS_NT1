import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main_13460 {
	private static int N, M;
	private static int[][] plate;
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input_s = br.readLine().split(" ");
		N = Integer.parseInt(input_s[0])-2;
		M = Integer.parseInt(input_s[1])-2;
		plate = new int[N][M];
		int[] red_init = new int[2];
		int[] blue_init = new int[2];
		for(int i=-1;i<N+1;i++) {
			String input_temp = br.readLine().substring(1, M+1);
			if(i==-1 || i==N) continue;
			
			for(int j=0;j<M;j++) {
				int temp = 0;
				switch(input_temp.charAt(j)) {
				case '#': temp = -1; break;
				case 'R':
					red_init[0] = i;
					red_init[1] = j;
					break;
				case 'B':
					blue_init[0] = i;
					blue_init[1] = j;
					break;
				case 'O': temp = -2; break;
				}
				plate[i][j] = temp;
			}
		}
		
		Queue<Step> bfs = new LinkedList<Step>();
		Pos temp_pos = null;
		int result = Integer.MAX_VALUE;
		bfs.offer(new Step(red_init,blue_init, -1, 0));
		while(!bfs.isEmpty()) {
			Step step = bfs.poll();
			switch(step.dir) {
			case 0:
				temp_pos = tiltUp(step.red, step.blue);
				break;
			case 1:
				temp_pos = tiltRight(step.red, step.blue);
				break;
			case 2:
				temp_pos = tiltDown(step.red, step.blue);
				break;
			case 3:
				temp_pos = tiltLeft(step.red, step.blue);
				break;
			}
			
			// check state
			if(temp_pos!=null) {
				switch(temp_pos.state) {
				case -1: case 2:
					continue;
				case 1:
					break;
				}
			}
			
			step.count++;
			if(step.count > 10) continue;
			
			for(int d=0;d<4;d++) {
				if(d == step.dir) continue;
				bfs.offer(new Step(temp_pos.red, temp_pos.blue, d, step.count));
			}
		}
		
		if(result == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(result);
	}
	
	private static Pos tiltUp(int[] red, int[] blue) {
		int[] new_red = red.clone();
		int[] new_blue = blue.clone();
		int state = -1;  // -1:nothing changed / 0:changed / 1:hole in red / 2:hole in blue
		if(red[1] == blue[1]) {  // balls are in same column
			boolean red_first = red[0] < blue[0] ? true:false;  // start with small index ball
			boolean small_finished = false;  // check small indexed ball finished
			
			if((red_first?red[0]:blue[0]) == 0) small_finished = true;  // small ball in first row
			if(small_finished) {
				for(int i=red_first?blue[0]-1:red[0]-1;i>=0;i--) {  // check large ball
					if(plate[i][red[1]] == -1) {  // wall
						if(i+1 == (red_first?blue[0]:red[0])) break;  // large ball right after wall
						if(red_first) new_blue[0] = i+1;
						else new_red[0] = i+1;
						state = 0;
						break;
					} else if(plate[i][red[1]] == -2) {  // hole
						if(red_first) return new Pos(null,null,2);  // failed - hole in blue
						else return new Pos(null,null,1);  // failed - hole in red
					} else if((red_first?red[0]:blue[0]) == i) {  // small ball
						if(i+1 == (red_first?blue[0]:red[0])) break;  // large ball right after small ball
						if(red_first) new_blue[0] = i+1;
						else new_red[0] = i+1;
						state = 0;
						break;
					}
				}
			} else {  // check both start with small ball
				for(int i=red_first?red[0]-1:blue[0]-1;i>=0;i--) {  // check small ball
					if(plate[i][red[1]] == -1) {  // wall
						if(i+1 == (red_first?red[0]:blue[0])) break;  // small ball right after wall
					} else if(plate[i][red[1]] == -2) { // hole
						if(red_first) {  // not yet - hole in red(must check blue)
							state = 1;
							break;
						} else return new Pos(null,null,2);  // failed - hole in blue
					}
				}
				// small ball placed
				for(int i=red_first?blue[0]-1:red[0]-1;i>=0;i--) {  // check large ball
					if(plate[i][red[1]] == -1) {  // wall
						if(i+1 == (red_first?blue[0]:red[0])) break;  // large ball right after wall
						if(red_first) new_blue[0] = i+1;
						else new_red[0] = i+1;
						state = 0;
						break;
					} else if(plate[i][red[1]] == -2) { // hole
						if(red_first) return new Pos(null,null,2);  // failed - hole in blue 
						else return new Pos(null,null,1);  // finished - only hole in red
					} else if((red_first?new_red[0]:new_blue[0]) == i) { // small ball
						if(i+1 == (red_first?blue[0]:red[0])) break;  // large ball right after small ball
						if(red_first) new_blue[0] = i+1;
						else new_red[0] = i+1;
						state = 0;
						break;
					}
				}
			}
			
			
		} else {  // balls are not in same column
			// check red
			if(red[0] != 0) {
				for(int r=red[0]-1;r>=0;r--) {
					if(plate[r][red[1]] == -1) {  // wall
						if(r+1 == red[0]) break;  // wall right after red
						new_red[0] = r+1;
						state = 0;
						break;
					} else if(plate[r][red[1]] == -2) {  // hole
						return new Pos(null,null,1);  // finish - hole in red
					}
				}
			}
			
			// check blue
			if(blue[0] != 0) {
				for(int b=blue[0]-1;b>=0;b--) {
					if(plate[b][blue[1]] == -1) {  // wall
						if(b+1 == blue[0]) break;  // wall right after blue
						new_blue[0] = b+1;
						state = 0;
						break;
					} else if(plate[b][blue[1]] == -2) {  // hole
						return new Pos(null,null,2);  // failed - hole in blue
					}
				}
			}
		}
		return new Pos(new_red,new_blue,state);
	}
	
	private static Pos tiltRight(int[] red, int[] blue) {
		
	}
	
	private static Pos tiltDown(int[] red, int[] blue) {
		
	}
	
	private static Pos tiltLeft(int[] red, int[] blue) {
		
	}
}

class Pos {
	int[] red, blue;
	int state; // -1:nothing changed / 0:changed / 1:finished(red out) / 2:failed(blue out)
	
	Pos(int[] red, int[] blue, int state) {
		this.red = red;
		this.blue = blue;
		this.state = state;
	}
}

class Step {
	int[] red = new int[2];
	int[] blue = new int[2];
	int dir, count;
	
	Step(int[] red, int[] blue, int dir, int count) {
		this.red = red;
		this.blue = blue;
		this.dir = dir;
		this.count = count;
	}
}
