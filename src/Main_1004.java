import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_1004 {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		String[] input_s;
		for(int t=0; t<T; t++) {
			input_s = br.readLine().split(" ");
			int[] SP = new int[2];
			int[] EP = new int[2];
			SP[0] = Integer.parseInt(input_s[0]);
			SP[1] = Integer.parseInt(input_s[1]);
			EP[0] = Integer.parseInt(input_s[2]);
			EP[1] = Integer.parseInt(input_s[3]);
			int N = Integer.parseInt(br.readLine());
			ArrayList<Planet> planets = new ArrayList<Planet>(N);
			for(int n=0;n<N;n++) {
				planets.add(new Planet(br.readLine().split(" ")));
			}
			
			boolean[] SPB = insides(SP, planets);
			boolean[] EPB = insides(EP, planets);
			int count = 0;
			for(int i=0;i<N;i++) {
				if(SPB[i]^EPB[i]) count++;
			}
			System.out.println(count);
		}
	}
	
	private static boolean[] insides(int[] point, ArrayList<Planet> planets) {
		boolean[] result = new boolean[planets.size()];
		for(int i=0;i<planets.size();i++) {
			result[i] = planets.get(i).inside(point[0], point[1]);
		}
		return result;
	}
}

class Planet {
	int x, y, r;
	
	Planet(String[] input_s) {
		this(Integer.parseInt(input_s[0]),Integer.parseInt(input_s[1]),Integer.parseInt(input_s[2]));
	}
	
	Planet(int x, int y, int r) {
		this.x = x;
		this.y = y;
		this.r = r;
	}
	
	boolean inside(int a, int b) {
		double distance = dist(a,b);
		if(distance < r) return true;
		else return false;
	}
	
	double dist(int a, int b) {
		return Math.sqrt(Math.pow(a-x, 2) + Math.pow(b-y, 2));
	}
}