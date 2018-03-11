import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1002 {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++) {
			Turret A, B;
			double dist_A, dist_B, dist_between;
			String[] input_s = br.readLine().split(" ");
			dist_A = Double.parseDouble(input_s[2]);
			dist_B = Double.parseDouble(input_s[5]);
			A = new Turret(Integer.parseInt(input_s[0]),Integer.parseInt(input_s[1]));
			B = new Turret(Integer.parseInt(input_s[3]),Integer.parseInt(input_s[4]));
			dist_between = A.dist(B);
			
			if(dist_between == 0) {
				if(dist_A == dist_B) System.out.println(-1);
				else System.out.println(0);
			} else if(dist_between == dist_A+dist_B || dist_between == Math.abs(dist_A-dist_B)) {
				System.out.println(1);
			} else if(dist_between < dist_A+dist_B) {
				if(dist_between < Math.abs(dist_A-dist_B)) System.out.println(0);
				else System.out.println(2);
			} else {
				System.out.println(0);
			}
		}
	}
}

class Turret {
	int x,y;
	
	Turret(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	double dist(Turret t) {
		return Math.sqrt(Math.pow(t.x-x, 2) + Math.pow(t.y-y, 2));
	}
}