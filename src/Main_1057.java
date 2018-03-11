import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1057 {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input_s = br.readLine().split(" ");
		//int N = Integer.parseInt(input_s[0]);
		int A = Integer.parseInt(input_s[1])-1;
		int B = Integer.parseInt(input_s[2])-1;
		int count = 1;
		int temp = 0;
		while(true) {
			temp = A / (1 << count);
			if(temp == B/(1<<count)) break;
			count++;
		}
		System.out.println(count);
	}
}
