import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_5585 {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int money = 1000 - Integer.parseInt(br.readLine());
//		System.out.println("money : " + money);
		
		int cnt = 0;
		int[] basis = {500, 100, 50, 10, 5, 1};
		
		for(int i=0;i<basis.length;i++) {
//			System.out.println(basis[i] + ":" + money/basis[i]);
			cnt += money/basis[i];
			money %= basis[i];
			if(checkZero(money, cnt)) break;
		}
	}
	
	private static boolean checkZero(int money, int cnt) {
		if(money==0) {
			System.err.println(cnt);
			return true;
		}
		return false;
	}
}
