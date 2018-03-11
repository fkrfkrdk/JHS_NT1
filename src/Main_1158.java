

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_1158 {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken())-1;

		ArrayList<Integer> data = new ArrayList<Integer>();
		
		for(int i=1;i<=N;i++) {
			data.add(i);
		}
		
		StringBuilder sb = new StringBuilder("<");
		int temp = 0;
		while(data.size() > 0) {
			temp = (temp+M)%data.size();
			sb.append(data.remove(temp)+", ");
		}
		System.out.println(sb.toString().substring(0,sb.length()-2)+">");
	}
}