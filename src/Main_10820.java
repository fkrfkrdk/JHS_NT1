

import java.util.Scanner;

public class Main_10820 {
	public static void main(String args[]) throws Exception {
		Scanner scan = new Scanner(System.in);
		int lower,higher,num,space;
		
		while(scan.hasNext()) {
			lower=0;higher=0;num=0;space=0;
			String input = scan.nextLine();
			for(int i=0;i<input.length();i++) {
				char temp = input.charAt(i);
				if(temp==' ') space++;
				else if('a'<=temp && temp<='z') lower++;
				else if('A'<=temp && temp<='Z') higher++;
				else if('0'<=temp && temp<='9') num++;
			}
			System.out.print(lower+" "+higher+" "+num+" "+space+"\n");
		}
		scan.close();
	}
}
