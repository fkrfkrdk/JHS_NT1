import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1475 {
	private static int[] data = new int[10];
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		for(int i=0;i<input.length();i++) {
			data[input.charAt(i)-48]++;
		}
		int firstMax = 0;
		int secondMax = 0;
		boolean second = false;
		int firstMaxValue = 0;
		int max_value = 0;
		for(int i=0;i<data.length;i++) {
			if(second && i==firstMax) continue;
			
			if(data[i] >= max_value) {
				if(second) secondMax = i;
				else firstMax = i;
				max_value = data[i];
			}
			
			if(!second && i == data.length-1) {
				i = -1;
				firstMaxValue = max_value;
				max_value = 0;
				second = true;
			}
		}
		int result = 0;
		if(firstMax == 6 || firstMax == 9) {
			int six_nine = data[6]+data[9];
			six_nine = six_nine%2 + six_nine/2;
			if(secondMax == 6 || secondMax == 9) {
				result = six_nine;
			} else {
				result = Math.max(six_nine, max_value);
			}
		} else {
			result = firstMaxValue;
		}
		System.out.println(result);
	}
}
