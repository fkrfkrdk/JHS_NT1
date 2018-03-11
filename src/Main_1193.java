import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1193 {
	private static int X = 0;
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		X = Integer.parseInt(br.readLine());
		boolean flag = true;
		int sum = 0;
		int i=0;
		while(sum < X) {
			sum += ++i;
		}
		if(i%2 == 0) flag = false;
		int k = 1;
		for(int t=sum;t>X;t--) {
			k++;
			i--;
		}
		if(flag) System.out.println(k+"/"+i);
		else System.out.println(i+"/"+k);
	}
}
