import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_14501 {
	private static int[][] sche;
	private static int[] data;
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		sche = new int[N][2];
		data = new int[N];
		for(int i=0;i<N;i++) {
			String[] input_s = br.readLine().split(" ");
			sche[i][0] = Integer.parseInt(input_s[0]);
			sche[i][1] = Integer.parseInt(input_s[1]);
		}
		
		int temp;
		for(int i=sche.length-1;i>=0;i--) {
			temp = 0;
			if(sche[i][0] == 1) {
				temp += sche[i][1];
				if(i+1<data.length) temp += data[i+1];
				data[i] = temp;
			} else {
				int temp_index = sche[i][0] + (i-1);
				if(temp_index >= data.length) {
					if(i+1 >= data.length) data[i] = 0;
					else data[i] = data[i+1];
				} else {
					if(temp_index+1 >= data.length) {
						if(i+1 >= data.length) data[i] = 0;
						else data[i] = Math.max(sche[i][1], data[i+1]);
					}
					else {
						data[i] = Math.max(sche[i][1] + data[temp_index+1], data[i+1]);
					}
				}
			}
		}
		System.out.println(data[0]);
	}
}
