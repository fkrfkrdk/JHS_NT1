

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_11656 {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String sb = br.readLine();
		Strings[] data = new Strings[sb.length()];
		for(int i=0;i<sb.length();i++) {
			data[i] = new Strings(sb.substring(i, sb.length()));
		}
		Arrays.sort(data);
		for(Strings s : data) {
			System.out.println(s);
		}
	}
}

class Strings implements Comparable<Strings> {
	String s = "";
	
	Strings(String init) {
		s = init;
	}
	
	@Override
	public int compareTo(Strings input) {
		String is = input.s;
		String minLength = Math.min(s.length(), is.length())==s.length()?s:is;
		for(int i=0;i<minLength.length();i++) {
			if(s.charAt(i) > is.charAt(i)) return 1;
			else if(s.charAt(i) == is.charAt(i)) continue;
			else return -1;
		}
		return s.equals(minLength)?-1:1;
	}
	public String toString() {
		return s;
	}
}