import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_3163 {
	public static void main(String args[]) throws Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++) {
			String[] input_s = br.readLine().split(" ");
			int N = Integer.parseInt(input_s[0]);
			int L = Integer.parseInt(input_s[1]);
			int K = Integer.parseInt(input_s[2]);
			
		}
	}
}

class Ant {
	long ID;
	boolean dir;
	
	Ant(long ID, boolean dir) {
		this.ID = ID;
		this.dir = dir;
	}
}
