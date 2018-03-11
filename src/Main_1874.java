import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_1874 {
	public static void main(String arg[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Stack<Integer> st = new Stack<>();
		
		int counter = 1;
		
		StringBuilder result = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0;i<N;i++) {
			int temp = Integer.parseInt(br.readLine());
			if(temp > N) {
				result = new StringBuilder("NO");
				break;
			}
			if(st.size()==0 || temp>st.peek()) {
				for(int sp=counter;sp<=temp;sp++) {
					st.push(sp);
					result.append('+').append('\n');
					counter++;
				}
				st.pop();
				result.append('-').append('\n');
			} else {
				int poped = st.pop();
				if(poped != temp) {
					result = new StringBuilder("NO");
					break;
				} else {
					result.append('-').append('\n');
				}
			}
		}
		System.out.println(result);
	}
}
