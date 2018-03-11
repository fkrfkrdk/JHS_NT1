import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2455 {
	public static void main(String args [])throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input_s;
		int result = Integer.MIN_VALUE;
		int temp = 0;
		for(int i=0;i<4;i++) {
			input_s = br.readLine().split(" ");
			int diff = Integer.parseInt(input_s[1]) - Integer.parseInt(input_s[0]);
			temp += diff;
			result = Math.max(result, temp);
		}
		System.out.println(result);
	}
}
