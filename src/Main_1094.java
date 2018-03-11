

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_1094 {
	private static Stack<Double> data = new Stack<>();
	private static int X;
	private static int result = 0;
	
	static {
		data.push(64.0);
	}
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		X = Integer.parseInt(br.readLine());
		
		calc();
		System.out.println(result);
		
		br.close();
	}
	
	private static void calc() {
		// sum all sticks
		int sum = 0;
		for(int i=0;i<data.size();i++) {
			sum += data.get(i);
		}
		while(sum > X) {
			double shortest_stick = data.pop()/2;
			data.push(shortest_stick);
			sum -= shortest_stick;
			if(sum < X) {
				data.push(shortest_stick);
				sum += shortest_stick;
			}
		}
		
		//stick
		sum = 0;
		for(int i=0;i<data.size();i++) {
			sum += data.get(i);
			result++;
			if(sum == X) break;
			else if(sum > X) {
				sum -= data.get(i);
				result--;
			}
		}
	}
}
