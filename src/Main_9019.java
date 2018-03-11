import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_9019 {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			LinkedList<data> que = new LinkedList<>();
			String result = "";
			que.add(new data(A, ""));
			while(!que.isEmpty()) {
				data cur = que.remove(0);
				if(cur.d == B) {
					result = cur.s;
					break;
				}
				que.addLast(new data(D(cur.d), cur.s+"D"));
				que.addLast(new data(S(cur.d), cur.s+"S"));
				que.addLast(new data(L(cur.d), cur.s+"L"));
				que.addLast(new data(R(cur.d), cur.s+"R"));
			}
			System.out.println(result);
		}
	}
	
	private static int D(int input) {
		return input*2%10000;
	}
	
	private static int S(int input) {
		if(input == 0) return 9999;
		else return input-1;
	}
	
	private static int L(int input) {
		input *= 10;
		int temp = input/10000;
		input %= 10000;
		return input += temp;
	}
	
	private static int R(int input) {
		int temp = (input%10)*1000;
		input /= 10;
		return input += temp;
	}
}

class data {
	String s;
	int d;
	
	data(int d, String s) {
		this.d = d;
		this.s = s;
	}
	
	public String toString() {
		return s +" " + d;
	}
}
