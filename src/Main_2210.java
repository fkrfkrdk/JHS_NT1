

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main_2210 {
	static final char[][] data = new char[5][5];
	static LinkedList<String> compare = new LinkedList<String>();
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				
		for(int i=0;i<5;i++) {
			data[i] = br.readLine().replaceAll(" ","").toCharArray();
		}
		
		make(0,-1,new StringBuilder());
	}
	
	private static void make(int x, int y, StringBuilder sb) {
		System.out.println("x:"+x+" y:"+y+"/"+sb);
		if(sb.toString().equals("123456")) {
			for(int i=0;i<compare.size();i++) {
				System.out.println(compare.get(i));
			}
		}
		if(sb.length() == 6) {
			for(int i=0;i<compare.size();i++) {
				if(sb.toString().equals(compare.get(i))) return;
			}
			compare.add(sb.toString());
			sb = sb.deleteCharAt(sb.length()-1);
			return;
		} else if(sb.length() == 0) {
			if(y == 4) {
				x++; y=0;
			} else y++;
			if(x==5) return;
			System.out.println("X:"+x+" Y:"+y);
		}
		sb.append(data[x][y]);
		if(x>0) make(x-1,y,sb);
		if(y>0) make(x,y-1,sb);
		if(x<4) make(x+1,y,sb);
		if(y<4) make(x,y+1,sb);
		sb = sb.deleteCharAt(sb.length()-1);
	}
}
