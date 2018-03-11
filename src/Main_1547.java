import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1547 {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int M = Integer.parseInt(br.readLine());
		String curCup = "1";
		String[] temp;
		for(int i=0;i<M;i++) {
			temp = br.readLine().split(" ");
			if(temp[0].equals(curCup)) {
				curCup = temp[1];
			} else if(temp[1].equals(curCup)) {
				curCup = temp[0];
			}
		}
		System.out.println(curCup);
	}
}
