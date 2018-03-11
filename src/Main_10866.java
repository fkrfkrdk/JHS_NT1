

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main_10866 {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		Deque<Integer> dq = new LinkedList<Integer>();
		
		for(int i=0;i<N;i++) {
			String com = br.readLine();
			String result = "";
			if(com.charAt(1) == 'i') {
				result = dq.size()+"";
			} else if(com.charAt(1) == 'm') {
				result = dq.isEmpty()?"1":"0";
			} else if(com.charAt(1) == 'r') {
				result = dq.peekFirst()+"";
			} else if(com.charAt(1) == 'a') {
				result = dq.peekLast()+"";
			} else if(com.charAt(6) == 'r') {
				dq.addFirst(Integer.parseInt(com.substring(11, com.length())));
				continue;
			} else if(com.charAt(6) == 'a') {
				dq.addLast(Integer.parseInt(com.substring(10, com.length())));
				continue;
			} else if(com.charAt(6) == 'o') {
				result = dq.pollFirst()+"";
			} else if(com.charAt(6) == 'c') {
				result = dq.pollLast()+"";
			}
			if(result.equals("null")) result = "-1";
			sb.append(result+"\n");
		}
		System.out.print(sb);
	}
}