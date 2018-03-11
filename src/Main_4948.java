import java.util.ArrayList;
import java.util.Scanner;

public class Main_4948 {
	private static boolean[] notPrime;
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		
		ArrayList<Integer> inputs = new ArrayList<>();
		int max_input = 0;
		int input_temp = scan.nextInt();
		while(input_temp != 0) {
			inputs.add(input_temp);
			max_input = Math.max(max_input, input_temp);
			input_temp = scan.nextInt();
		}
		notPrime = new boolean[2*max_input+1];
		notPrime[0] = true;
		notPrime[1] = true;
		for(int i=2;i<notPrime.length;i++) {
			if(notPrime[i]) continue;
			for(int j=i*2;j<notPrime.length;j+=i) {
				notPrime[j] = true;
			}
		}
		
		for(int temp : inputs) {
			int count = 0;
			for(int i=temp+1;i<=2*temp;i++) {
				if(!notPrime[i]) count++;
			}
			System.out.println(count);
		}
		
		
		scan.close();
	}
}
