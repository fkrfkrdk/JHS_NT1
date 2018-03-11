import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main_2580 {
	private static int[][] plate = new int[9][9];
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<int[]> zeros = new LinkedList<>();
		for(int i=0;i<9;i++) {
			String[] input_s = br.readLine().split(" ");
			for(int j=0;j<9;j++) {
				plate[i][j] = Integer.parseInt(input_s[j]);
				if(plate[i][j] == 0) {
					int[] item = {i,j};
					zeros.add(item);
				}
			}
		}
		
		while(!checkFilledAll(plate)) {
			fillMustBe(zeros);
			if(zeros.size()!=0) {
				int[] zero_temp = zeros.poll();
				ArrayList<Integer> canBe = findCanBe(zero_temp[0], zero_temp[1]);
				for(int i=0;i<canBe.size();i++) {
					if(dfs(copyPlate(plate), clone(zeros), zero_temp, canBe.get(i))) break;
				}
			}
		}
		
		printPlate(plate);
	}
	
	private static boolean dfs(int[][] plate_, Queue<int[]> zeros, int[] cur_point, int canBeInt) {
		System.out.println("DFS!!!"+canBeInt);
		printPlate(plate_);
		
		plate_[cur_point[0]][cur_point[1]] = canBeInt;
		
		if(!checkConsistency(plate_)) return false;
		
		if(zeros.size()!=0) {
			int[] zero_temp = zeros.poll();
			ArrayList<Integer> canBe = findCanBe(zero_temp[0], zero_temp[1]);
			for(int i=0;i<canBe.size();i++) {
				if(dfs(copyPlate(plate), clone(zeros), zero_temp, canBe.get(i))) return true;
			}
			return false;
		} else {
			if(checkConsistency(plate_)) return true;
			else return false;
		}
	}
	
	private static ArrayList<Integer> findCanBe(int zero_x, int zero_y) {
		boolean[][] canbe = new boolean[3][9];
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		for(int i=0;i<9;i++) {
			int temp_x = plate[zero_x][i];
			int temp_y = plate[i][zero_y];
			int temp_c = plate[zero_x/3*3+i/3][zero_y/3*3+i%3];
			if(temp_x != 0) canbe[0][temp_x-1] = true;
			if(temp_y != 0) canbe[1][temp_y-1] = true;
			if(temp_c != 0) canbe[2][temp_c-1] = true;
		}
		
		for(int i=0;i<9;i++) {
			if(!canbe[0][i] && !canbe[1][i] && !canbe[2][i]) result.add(i+1);
		}
		return result;
	}
	
	private static void fillMustBe(Queue<int[]> zeros) {
		int lookUpCount = zeros.size();
		while(!zeros.isEmpty() && lookUpCount>0) {
			int[] point_temp = zeros.poll();
			boolean canFill = must(point_temp[0], point_temp[1]);
			if(!canFill) {
				zeros.add(point_temp);
				lookUpCount--;
			} else {
				lookUpCount = zeros.size();
			}
		}
	}
	
	private static boolean must(int zero_x, int zero_y) {
		int temp = 0;
		
		// lookUp Row
		temp = lookUpRow(zero_x, zero_y);
		if(temp != -1) {
			plate[zero_x][zero_y] = temp;
			return true;
		}
		
		// lookUp Column
		temp = lookUpColumn(zero_x, zero_y);
		if(temp != -1) {
			plate[zero_x][zero_y] = temp;
			return true;
		}
		
		// lookUp Cell
		temp = lookUpCell(zero_x, zero_y);
		if(temp != -1) {
			plate[zero_x][zero_y] = temp;
			return true;
		}
		
		return false;
	}
	
	private static int lookUpRow(int zero_x, int zero_y) {
		boolean[] check = new boolean[9];
		int countZero = 0;
		for(int i=0;i<9;i++) {
			int temp = plate[zero_x][i];
			if(temp == 0) countZero++;
			else check[temp-1] = true;
		}
		if(countZero != 1) return -1;
		for(int i=0;i<9;i++) {
			if(!check[i]) return i+1;
		}
		return -1;
	}
	
	private static int lookUpColumn(int zero_x, int zero_y) {
		boolean[] check = new boolean[9];
		int countZero = 0;
		for(int i=0;i<9;i++) {
			int temp = plate[i][zero_y];
			if(temp == 0) countZero++;
			else check[temp-1] = true;
		}
		if(countZero != 1) return -1;
		for(int i=0;i<9;i++) {
			if(!check[i]) return i+1;
		}
		return -1;
	}
	
	private static int lookUpCell(int zero_x, int zero_y) {
		boolean[] check = new boolean[9];
		int countZero = 0;
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				int temp = plate[zero_x/3*3+i][zero_y/3*3+j];
				if(temp == 0) countZero++;
				else check[temp-1] = true;
			}
		}
		if(countZero != 1) return -1;
		for(int i=0;i<9;i++) {
			if(!check[i]) return i+1;
		}
		return -1;
	}
	
	private static boolean checkFilledAll(int[][] plate) {
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				if(plate[i][j] == 0) return false;
			}
		}
		return true;
	}
	
	private static boolean checkConsistency(int[][] plate) {
		int[][] canbe;
		
		for(int i=0;i<9;i++) {
			canbe = new int[3][9];
			for(int j=0;j<9;j++) {
				int temp1 = plate[i][j];
				int temp2 = plate[j][i];
				int temp3 = plate[i/3*3+j/3][i%3*3+j%3];
				
				if(temp1 != 0) canbe[0][temp1-1]++;
				if(temp2 != 0) canbe[1][temp2-1]++;
				if(temp3 != 0) canbe[2][temp3-1]++;
			}
			for(int k=0;k<9;k++) {
				for(int l=0;l<3;l++) {
					if(canbe[l][k] > 1) return false;
				}
			}
		}
		return true;
	}
	
	private static Queue<int[]> clone(Queue<int[]> zeros) {
		Queue<int[]> result = new LinkedList<>();
		for(int[] item : zeros) {
			result.add(item.clone());
		}
		return result;
	}
	
	private static int[][] copyPlate(int[][] p) {
		int[][] result = new int[p.length][p[0].length];
		for(int i=0;i<p.length;i++) {
			result[i] = p[i].clone();
		}
		return result;
	}
 
	private static void printPlate(int[][] plate) {
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				System.out.print(plate[i][j]+" ");
			}
			System.out.println();
		}
	}
}
