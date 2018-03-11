import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_10875_2 {
	private static long L, L_len;
	private static long time = 0;
	private static Snake dir;
	private static ArrayList<Pos2> snake = new ArrayList<>();
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		L = Long.parseLong(br.readLine());
		L_len = 2*L+1;
		dir = new Snake(L);
		snake.add(new Pos2(L,L));
		int N = Integer.parseInt(br.readLine());
		String[] coms = new String[N+1];
		for(int i=0;i<N;i++) {
			coms[i] = br.readLine();
		}
		coms[N] = Integer.MAX_VALUE+" L";
		
		for(int i=0;i<coms.length;i++) {
			StringTokenizer st = new StringTokenizer(coms[i]," ");
			long times = Long.parseLong(st.nextToken());
			Pos2 temp = new Pos2(dir.cur.x+dir.dir_x*times, dir.cur.y+dir.dir_y*times);
			
			boolean maybeWall = false;
			// check collision to wall
			Pos2 fake = temp;
			if(temp.x < 0) {
				maybeWall = true;
				temp = new Pos2(0,fake.y);
			} else if(temp.x >= L_len) {
				maybeWall = true;
				temp = new Pos2(L_len-1,fake.y);
			} else if(temp.y < 0) {
				maybeWall = true;
				temp = new Pos2(fake.x,0);
			} else if(temp.y >= L_len) {
				maybeWall = true;
				temp = new Pos2(fake.x,L_len-1);
			}
			
			// check Collision to itself
			long k = 0;
			if((k = checkItself(temp)) != -1) {
				time += k;
				break;
			}
			if(maybeWall) {
				temp = fake;
				time += dir.cur.x==temp.x ? (temp.y<0?dir.cur.y+1:L_len-dir.cur.y) : (temp.x<0?dir.cur.x+1:L_len-dir.cur.x);
				break;
			}
			
			// passed all
			snake.add(temp);
			dir.cur = temp;
			time += times;
			
			if(st.nextToken().charAt(0) == 'L') {
				dir.turnLeft();
			} else {
				dir.turnRight();
			}
		}
		System.out.println(time);
	}
	
	private static long checkItself(Pos2 newPos) {
		Pos2 collision = null;
		// find collisions
		if(snake.size()<3) return -1;
		Pos2 bb = null;
		Pos2 b = snake.get(snake.size()-2);
		for(int i=snake.size()-3;i>=0;i--) {
			bb = b;
			b = snake.get(i);
			
			if(dir.dir_x == 1) {
				if(bb.y == b.y) {
					if(b.y == newPos.y) {
						long smaller = b.x > bb.x ? bb.x : b.x;
						long bigger = b.x > bb.x ? b.x : bb.x;
						if(newPos.x < smaller || bigger < dir.cur.x) continue;
						collision = collision == null || collision.x > smaller ? new Pos2(smaller, newPos.y) : collision;
					}
				} else {
					if(b.x < dir.cur.x || b.x > newPos.x) continue;
					long smaller = b.y > bb.y ? bb.y : b.y;
					long bigger = b.y > bb.y ? b.y : bb.y;
					if(bigger < newPos.y || smaller > newPos.y) continue;
					collision = collision == null || collision.x > b.x ? new Pos2(b.x, newPos.y) : collision;
				}
			} else if(dir.dir_x == -1) {
				if(bb.y == b.y) {
					if(b.y == newPos.y) {
						long smaller = b.x > bb.x ? bb.x : b.x;
						long bigger = b.x > bb.x ? b.x : bb.x;
						if(newPos.x > bigger || smaller > dir.cur.x) continue;
						collision = collision == null || collision.x < bigger ? new Pos2(bigger, newPos.y) : collision;
					}
				} else {
					if(b.x > dir.cur.x || b.x < newPos.x) continue;
					long smaller = b.y > bb.y ? bb.y : b.y;
					long bigger = b.y > bb.y ? b.y : bb.y;
					if(bigger < newPos.y || smaller > newPos.y) continue;
					collision = collision == null || collision.x < b.x ? new Pos2(b.x, newPos.y) : collision;
				}
			} else if(dir.dir_y == 1) {
				if(bb.x == b.x) {
					if(b.x == newPos.x) {
						long smaller = b.y > bb.y ? bb.y : b.y;
						long bigger = b.y > bb.y ? b.y : bb.y;
						if(newPos.y < smaller || bigger < dir.cur.y) continue;
						collision = collision == null || collision.y > smaller ? new Pos2(newPos.x, smaller) : collision;
					}
				} else {
					if(b.y < dir.cur.y || b.y > newPos.y) continue;
					long smaller = b.x > bb.x ? bb.x : b.x;
					long bigger = b.x > bb.x ? b.x : bb.x;
					if(bigger < newPos.x || smaller > newPos.x) continue;
					collision = collision == null || collision.y > b.y ? new Pos2(newPos.x, b.y) : collision;
				}
			} else if(dir.dir_y == -1) {
				if(bb.x == b.x) {
					if(b.x == newPos.x) {
						long smaller = b.y > bb.y ? bb.y : b.y;
						long bigger = b.y > bb.y ? b.y : bb.y;
						if(newPos.y > bigger || smaller > dir.cur.y) continue;
						collision = collision == null || collision.y < bigger ? new Pos2(newPos.x, bigger) : collision;
					}
				} else {
					if(b.y > dir.cur.y || b.y < newPos.y) continue;
					long smaller = b.x > bb.x ? bb.x : b.x;
					long bigger = b.x > bb.x ? b.x : bb.x;
					if(bigger < newPos.x || smaller > newPos.x) continue;
					collision = collision == null || collision.y < b.y ? new Pos2(newPos.x, b.y) : collision;
				}
			}
		}
		if(collision == null) {
			return -1;
		}
		// calc distance
		long dist = newPos.x == dir.cur.x ? dir.cur.y-collision.y : dir.cur.x-collision.x;
		if(dist<0) dist = -dist;
		return dist;
	}
}

class Pos2 {
	long x,y;
	Pos2(long x, long y) {
		this.x = x;
		this.y = y;
	}
}

class Snake {
	Pos2 cur;
	int dir_x = 0, dir_y = 1;
	
	Snake(long L) {
		cur = new Pos2(L,L);
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
}