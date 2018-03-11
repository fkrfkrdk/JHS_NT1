import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2908 {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] inputs = br.readLine().split(" ");
		int A = Integer.parseInt(new StringBuilder(inputs[0]).reverse().toString());
		int B = Integer.parseInt(new StringBuilder(inputs[1]).reverse().toString());
		System.out.println(A > B? A:B);
	}
}
