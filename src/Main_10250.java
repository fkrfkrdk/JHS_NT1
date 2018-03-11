import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_10250 {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++) {
			String[] input_s = br.readLine().split(" ");
			int H = Integer.parseInt(input_s[0]);
			int W = Integer.parseInt(input_s[1]);
			int N = Integer.parseInt(input_s[2]);
			int temp = N/H+1;
			int temp2 = N%H;
			if(temp2==0) {
				temp2 = H;
				temp--;
			}
			StringBuilder result = new StringBuilder().append(temp2);
			if(temp<10) result.append('0');
			result.append(temp);
			System.out.println(result);
		}
		
	}
}
