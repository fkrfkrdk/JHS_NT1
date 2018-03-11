import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2941 {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		int count = 0;
		for(int i=0;i<input.length();i++) {
			char temp = input.charAt(i);
			count++;
			switch(temp) {
			case 'c':
				if(i+1 < input.length() && (input.charAt(i+1)=='=' || input.charAt(i+1)=='-')) {
					i++;
				}
				break;
			case 'd':
				if(i+1< input.length()) {
					if(i+2 < input.length() && input.charAt(i+1)=='z' && input.charAt(i+2)=='=') {
						i += 2;
					} else if(input.charAt(i+1)=='-') {
						i++;
					}
				}
				break;
			case 'l':
				if(i+1 < input.length() && input.charAt(i+1)=='j') {
					i++;
				}
				break;
			case 'n':
				if(i+1 < input.length() && input.charAt(i+1)=='j') {
					i++;
				}
				break;
			case 's':
				if(i+1 < input.length() && input.charAt(i+1)=='=') {
					i++;
				}
				break;
			case 'z':
				if(i+1<input.length() && input.charAt(i+1)=='=') {
					i++;
				}
				break;
			}
		}
		System.out.println(count);	
	}
}
