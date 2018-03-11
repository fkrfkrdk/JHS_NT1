

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_9012 {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		Stack<Character> st;
		String result = "";
		
		for(int i=0;i<T;i++) {
			String s = br.readLine();
			st = new Stack<Character>();
			result = "";
			for(int j=0;j<s.length();j++) {
				char c = s.charAt(j);
				if(c == '(') {
					st.push(c);
				} else {
					if(st.isEmpty()) {
						result = "NO";
						break;
					}
					else st.pop();
				}
			}
			result = st.size() == 0 && result.equals("") ? "YES" : "NO";
			System.out.println(result);
		}
	}
}
