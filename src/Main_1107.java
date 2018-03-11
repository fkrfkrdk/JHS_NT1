import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1107 {
	private static final int INIT_CH = 100;
	private static int N, M;
	private static int smallest, largest, secondSmallest = -1;
	private static boolean[] broken;
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		String[] input_s = new String[0];
		if(M!=0) {
			 input_s = br.readLine().split(" ");
		}
		broken = new boolean[10];
		for(int i=0;i<M;i++) {
			broken[Integer.parseInt(input_s[i])] = true;
		}
		
		boolean second = false;
		for(int i=0;i<10;i++) {
			if(!broken[i]) {
				if(!second) {
					smallest = i;
					second = true;
				} else {
					secondSmallest = i;
					break;
				}
			}
		}
		for(int i=9;i>=0;i--) {
			if(!broken[i]) {
				largest = i;
				break;
			}
		}
		
		if(N == INIT_CH) {
			System.out.println(0);
			System.exit(0);
		}
		int diff = Math.abs(N-INIT_CH);
		if(M==10) {
			System.out.println(diff);
			System.exit(0);
		}
		if(M==9 && smallest==0) {
			int toZero = Math.abs(N-0)+1;
			System.out.println(Math.min(toZero, diff));
			System.exit(0);
		}
		if(checkConsistAll(N)) {
			int digit = checkDigit(N);
			System.out.println(Math.min(digit, diff));
			System.exit(0);
		}
		
		
		int afterN = afterN(N);
		int beforeN = beforeN(N);
		int countAfter = Math.abs(afterN-N) + checkDigit(afterN);
		int countBefore = Math.abs(beforeN-N) + checkDigit(beforeN);
		int countDiff = Math.abs(N-INIT_CH);
		
		//System.out.println("A:" + afterN + " / "+countAfter);
		//System.out.println("B:" + beforeN +" / "+countBefore);
		int result = 0;
		if(beforeN == 0 && broken[0]) {
			result = Math.min(countDiff,countAfter);
		} else {
			result = Math.min(countDiff, Math.min(countAfter, countBefore));
		}
		System.out.println(result);
		br.close();
	}
	
	private static int checkDigit(int num) {
		if(num == 0) return 1;
		int digit = 0;
		int n_temp = num;
		while(n_temp != 0) {
			n_temp = n_temp/10;
			digit++;
		}
		return digit;
	}
	
	private static boolean checkConsistAll(int num) {
		if(num == 0) {
			if(broken[0]) return false;
			else return true;
		}
		int n_temp = num;
		while(n_temp != 0) {
			if(broken[n_temp%10]) return false;
			else n_temp = n_temp/10;
		}
		return true;
	}

	private static int afterN(int num) {
		if(num/10 == 0) {
			int larger = findBiggerNum(num);
			if(larger != -1) return larger;
			else {
				if(smallest == 0) return secondSmallest*10+smallest;
				else return smallest*10+smallest;
			}
		} else {
			if(checkConsistAll(num/10)) {
				int larger = findBiggerNum(num%10);
				if(larger != -1) return (num/10)*10+larger;
			}
			return afterN(num/10)*10+smallest;
		}
	}
	
	private static int beforeN(int num) {
		if(num/10 == 0) {
			int smaller = findSmallerNum(num);
			if(smaller != -1) return smaller;
			else return 0;
		} else {
			if(checkConsistAll(num/10)) {
				int smaller = findSmallerNum(num%10);
				if(smaller != -1) return (num/10)*10+smaller;
			}
			return beforeN(num/10)*10+largest;
		}
	}
	
	private static int findBiggerNum(int num) {
		for(int i=num+1;i<10;i++) {
			if(!broken[i]) return i;
		}
		return -1;
	}
	
	private static int findSmallerNum(int num) {
		for(int i=num-1;i>=0;i--) {
			if(!broken[i]) return i;
		}
		return -1;
	}
}
