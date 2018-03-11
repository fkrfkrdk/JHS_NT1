

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_1406 {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String init = br.readLine();
		Stack<Character> left = new Stack<Character>();
		Stack<Character> right = new Stack<Character>();
		
		for(int i=0;i<init.length();i++) {
			left.push(init.charAt(i));
		}
		
		int N = Integer.parseInt(br.readLine());
		for(int i=0;i<N;i++) {
			String com = br.readLine();
			switch(com.charAt(0)) {
			case 'L':
				if(!left.isEmpty()) right.push(left.pop());
				break;
			case 'D':
				if(!right.isEmpty()) left.push(right.pop());
				break;
			case 'B':
				if(!left.isEmpty()) left.pop();
				break;
			case 'P':
				left.push(com.charAt(2));
				break;
			}
		}
		StringBuilder sb = new StringBuilder();
		Object[] temp_char = left.toArray();
		for(int i=0;i<temp_char.length;i++) {
			sb.append(temp_char[i]);
		}
		temp_char = right.toArray();
		for(int i=temp_char.length-1;i>=0;i--) {
			sb.append(temp_char[i]);
		}
		System.out.println(sb);
	}
}