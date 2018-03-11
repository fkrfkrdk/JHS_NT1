import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_12208 {
	private static int N;
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++) {
			String[] input_s = br.readLine().split(" ");
			N = Integer.parseInt(input_s[0]);
			char dir = input_s[1].charAt(0);
			int[][] board= new int[N][N];
			for(int i=0;i<N;i++) {
				input_s = br.readLine().split(" ");
				for(int j=0;j<N;j++) {
					board[i][j] = Integer.parseInt(input_s[j]);
				}
			}
			switch(dir) {
			case 'u':
				swipeUp(board);
				break;
			case 'r':
				swipeRight(board);
				break;
			case 'd':
				swipeDown(board);
				break;
			case 'l':
				swipeLeft(board);
				break;
			}
			
			printBoard(board,t);
		}
	}
	
	private static int[][] swipeUp(int[][] board) {
		int temp;
		int before = 0;
		for(int i=0;i<N;i++) {
			temp = 0;
			for(int j=0;j<N;j++) {
				if(board[j][i] != 0) {
					if(before == board[j][i] && temp>0) {
						board[temp-1][i] = before << 1;
						board[j][i] = 0;
						before = 0;
					} else if(temp < j) {
						before = board[j][i];
						board[j][i] = 0;
						board[temp][i] = before;
						temp++;
					} else {
						before = board[j][i];
						temp++;
					}
				}
			}
		}
		return board;
	}
	
	private static int[][] swipeRight(int[][] board) {
		int temp;
		int before = 0;
		for(int i=N-1;i>=0;i--) {
			temp = N-1;
			for(int j=N-1;j>=0;j--) {
				if(board[i][j] != 0) {
					if(before == board[i][j] && temp<N-1) {
						board[i][temp+1] = before << 1;
						board[i][j] = 0;
						before = 0;
					} else if(temp > j) {
						before = board[i][j];
						board[i][j] = 0;
						board[i][temp] = before;
						temp--;
					} else {
						before = board[i][j];
						temp--;
					}
				}
			}
		}
		return board;
	}
	
	private static int[][] swipeDown(int[][] board) {
		int temp;
		int before = 0;
		for(int i=N-1;i>=0;i--) {
			temp = N-1;
			for(int j=N-1;j>=0;j--) {
				if(board[j][i] != 0) {
					if(before == board[j][i] && temp<N-1) {
						board[temp+1][i] = before << 1;
						board[j][i] = 0;
						before = 0;
					} else if(temp > j) {
						before = board[j][i];
						board[j][i] = 0;
						board[temp][i] = before;
						temp--;
					} else {
						before = board[j][i];
						temp--;
					}
				}
			}
		}
		return board;
	}
	
	private static int[][] swipeLeft(int[][] board) {
		int temp;
		int before = 0;
		for(int i=0;i<N;i++) {
			temp = 0;
			for(int j=0;j<N;j++) {
				if(board[i][j] != 0) {
					if(before == board[i][j] && temp>0) {
						board[i][temp-1] = before << 1;
						board[i][j] = 0;
						before = 0;
					} else if(temp < j) {
						before = board[i][j];
						board[i][j] = 0;
						board[i][temp] = before;
						temp++;
					} else {
						before = board[i][j];
						temp++;
					}
				}
			}
		}
		return board;
	}
	
	private static void printBoard(int[][] board, int t) {
		StringBuilder sb = new StringBuilder("Case #"+(t+1)+":\n");
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				sb.append(board[i][j]+" ");
			}
			sb.append('\n');
		}
		System.out.print(sb);
	}
}
