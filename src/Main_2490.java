import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2490 {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<3;i++) {
			int count_0 = 0;
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<4;j++) {
				if(Integer.parseInt(st.nextToken())==0) count_0++;
			}
			switch(count_0) {
			case 1: sb.append('A'); break;
			case 2: sb.append('B'); break;
			case 3: sb.append('C'); break;
			case 4: sb.append('D'); break;
			case 0: sb.append('E'); break;
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}
}
