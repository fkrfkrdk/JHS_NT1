import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_2504 {
	@SuppressWarnings("unused")
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		Stack<Character> st = new Stack<>();
		int result = 0;
		
		for(int i=0;i<input.length();i++) {
			char temp = input.charAt(i);
			if(temp == '(' || temp == '[') {
				st.push(temp);
			} else {
				if(st.size()==0) {
					System.out.println(0);
					System.exit(0);
				}
				char poped = st.pop();
				if(temp==')' && poped=='(') {
					
				} else if(temp==']' && poped=='[') {
					
				} else {
					System.out.println(0);
					System.exit(0);
				}
			}
		}
	}
}
