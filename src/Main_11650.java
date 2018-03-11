

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_11650 {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		ArrayList<Coordinate> coords = new ArrayList<>();
		
		for(int i=0;i<N;i++) {
			String[] input_temp = br.readLine().split(" ");
			coords.add(new Coordinate(Integer.parseInt(input_temp[0]), Integer.parseInt(input_temp[1])));
		}
		
		coords.sort(null);
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<coords.size();i++) {
			sb.append(coords.get(i).toStringBuilder());
		}
		System.out.println(sb);
	}
}

class Coordinate implements Comparable<Coordinate> {
	final int x;
	final int y;
	
	Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int compareTo(Coordinate co) {
		if(x>co.x) return 1;
		else if(x < co.x) return -1;
		else {
			if(y > co.y) return 1;
			else if(y < co.y) return -1;
			else return 0;
		}
	}
	
	public StringBuilder toStringBuilder() {
		StringBuilder sb = new StringBuilder();
		return sb.append(x).append(' ').append(y).append('\n');
	}
}