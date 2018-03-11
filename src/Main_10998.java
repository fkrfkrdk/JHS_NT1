

import java.util.Scanner;

public class Main_10998 {
	public static void main(String args[]) throws Exception {
		Scanner scan = new Scanner(System.in);
		int[] t = new int[100];
		
		for(int i=0;i<t.length;i++) {
			int N = i;
			
			int result = N/30*6;
			N = N%30;
			
			if(N!=0) {
				result += N/12*4;
				N = N%12;
				if(N!=0) {
					result += N/5;
					if(N%5 != 0) {
						if(N/5>0) {
							N = N%5 + 5;
							result --;
						} else {
							N = N%5;
						}
						if(N == 8) result += 2;
						else if(N%3 != 0) result = -1;
						else result += N/3;
					}
				}
			}
			System.out.println(i+":"+result);

		}
		scan.close();
		//int N = scan.nextInt();
	}
}
