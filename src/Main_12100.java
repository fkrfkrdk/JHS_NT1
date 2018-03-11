import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_12100 {
	private static int N, max = 0;
	private static int[][] board_origin;
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		board_origin = new int[N][N];
		for(int i=0;i<N;i++) {
			String[] input_s = br.readLine().split(" ");
			for(int j=0;j<N;j++) {
				board_origin[i][j] = Integer.parseInt(input_s[j]);
			}
		}
		
		dfs(copyBoard(board_origin), -1, 0);
		System.out.println(max);
	}
	
	private static void dfs(int[][] board, int dir, int count) {
		if(count != 0) {
			switch(dir) {
			case 0:
				board = swipeUp(board);
				break;
			case 1:
				board = swipeRight(board);
				break;
			case 2:
				board = swipeDown(board);
				break;
			case 3:
				board = swipeLeft(board);
				break;
			}
		}
		if(count == 10) {
			max = Math.max(max, maxBlock(board));
		} else {
			for(int i=0;i<4;i++) {
				dfs(copyBoard(board),i,count+1);
			}
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
	
	private static int maxBlock(int[][] board) {
		int max = 0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				max = Math.max(max, board[i][j]);
			}
		}
		return max;
	}
	
	private static int[][] copyBoard(int[][] board) {
		int[][] result = new int[N][N];
		for(int i=0;i<N;i++) {
			result[i] = board[i].clone();
		}
		return result;
	}
	
	@SuppressWarnings("unused")
	private static void printBoard(int[][] board) {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
}