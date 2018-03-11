import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_3071 {
	private static String result;
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++) {
			result = "";
			long N = Long.parseLong(br.readLine());
			if(N==0) {
				System.out.println(0);
				continue;
			}
			boolean neg = false;
			if(N<0) {
				neg = true;
				N = -N;
			}
			change(N);
			if(neg) negation();
			
			System.out.println(result);
		}
		br.close();
	}
	
	private static void change(long N) {
		long temp = (N+1)/3;
		result = digitToChar((int)(N+1)%3-1) + result;
		if(temp == 0) return;
		change(temp);
	}
	
	private static char digitToChar(int digit) {
		switch(digit) {
		case 1: return '1';
		case 0: return '0';
		case -1: return '-';
		}
		return '?';
	}
	
	private static void negation() {
		StringBuilder neg = new StringBuilder(result);
		for(int i=0;i<neg.length();i++) {
			if(neg.charAt(i)=='1') neg.setCharAt(i, '-');
			else if(neg.charAt(i)=='-') neg.setCharAt(i, '1');
		}
		result = neg.toString();
	}
}
