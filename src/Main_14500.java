import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_14500 {
	private static int N,M;
	private static Node[][] paper;
	private static int[][] result;
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input_s = br.readLine().split(" ");
		N = Integer.parseInt(input_s[0]);
		M = Integer.parseInt(input_s[1]);
		paper = new Node[N][M];
		result = new int[N][M];
		
		for(int i=0;i<N;i++) {
			input_s = br.readLine().split(" ");
			for(int j=0;j<M;j++) {
				paper[i][j] = new Node(Integer.parseInt(input_s[j]));
			}
		}
		
		for(int i=N-1;i>=0;i--) {
			for(int j=M-1;j>=0;j--) {
				calcNode(i,j);
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				result[i][j] = calcShape(i,j);
			}
		}
		
		int max = 0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				max = Math.max(result[i][j], max);
			}
		}
		System.out.println(max);
	}
	
	private static void calcNode(int x, int y) {
		Node temp = paper[x][y];
		if(x == N-1) {
			temp.ver_2 = 0;
			temp.ver_3 = 0;
		} else if(x == N-2) {
			temp.ver_2 = paper[x+1][y].value + temp.value;
			temp.ver_3 = 0;
		} else {
			temp.ver_2 = paper[x+1][y].value + temp.value;
			temp.ver_3 = paper[x+1][y].ver_2 + temp.value;
		}
		if(y == M-1) {
			temp.hor_2 = 0;
			temp.hor_3 = 0;
		} else if(y == M-2) {
			temp.hor_2 = paper[x][y+1].value + temp.value;
			temp.hor_3 = 0;
		} else {
			temp.hor_2 = paper[x][y+1].value + temp.value;
			temp.hor_3 = paper[x][y+1].hor_2 + temp.value;
		}
	}
	
	private static int calcShape(int x, int y) {
		Node temp = paper[x][y];
		int[] shapes = new int[19];
		
		// 0
		if(!(x+1>=N || y+1>=M)) shapes[0] = temp.hor_2 + paper[x+1][y].hor_2;
		// 1
		if(!(x+2>=N || y+1>=M)) shapes[1] = temp.ver_2 + paper[x+1][y+1].ver_2;
		// 2
		if(!(x-1<0 || x+1>=N || y+1>=M)) shapes[2] = temp.ver_2 + paper[x-1][y+1].ver_2;
		// 3
		if(!(x+1>=N || y-1<0 || y+1>=M)) shapes[3] = temp.hor_2 + paper[x+1][y-1].hor_2;
		// 4
		if(!(x+1>=N || y+2>=M)) shapes[4] = temp.hor_2 + paper[x+1][y+1].hor_2;
		// 5
		if(!(x+1>=N || y+2>=M)) shapes[5] = temp.value + paper[x+1][y].hor_3;
		// 6
		if(!(x+1>=N || y-1<0 || y+1>=M)) shapes[6] = temp.value + paper[x+1][y-1].hor_3;
		// 7
		if(!(x+1>=N || y-2<0)) shapes[7] = temp.value + paper[x+1][y-2].hor_3;
		// 8 9 10	
		if(!(x+1>=N || y+2>=M)) {
			shapes[8] = temp.hor_3 + paper[x+1][y].value;
			shapes[9] = temp.hor_3 + paper[x+1][y+1].value;
			shapes[10] = temp.hor_3 + paper[x+1][y+2].value;
		}
		// 11
		if(!(y+3>=M)) shapes[11] = temp.value + paper[x][y+1].hor_3;
		// 12 13 14
		if(!(x+2>=N || y+1>=M)) {
			shapes[12] = temp.ver_3 + paper[x][y+1].value;
			shapes[13] = temp.ver_3 + paper[x+1][y+1].value;
			shapes[14] = temp.ver_3 + paper[x+2][y+1].value;
		}
		// 15
		if(!(x+2>=N || y+1>=M)) shapes[15] = temp.value + paper[x][y+1].ver_3;
		// 16
		if(!(x-1<0 || x+1>=N || y+1>=M)) shapes[16] = temp.value + paper[x-1][y+1].ver_3;
		// 17
		if(!(x-2<0 || y+1>=M)) shapes[17] = temp.value + paper[x-2][y+1].ver_3;
		// 18
		if(!(x+3>N)) shapes[18] = temp.value + paper[x+1][y].ver_3;
		
		int max = 0;
		for(int i=0;i<shapes.length;i++) {
			max = Math.max(max, shapes[i]);
		}
		return max;
	}
}

class Node {
	int value, hor_2, hor_3, ver_2, ver_3;  // Left-Upper is a root
	
	Node(int value) {
		this.value = value;
	}
}
