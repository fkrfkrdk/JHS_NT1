import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class Main_1005 {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++) {
			// input start
			String[] input_s = br.readLine().split(" ");
			int N = Integer.parseInt(input_s[0]);
			int K = Integer.parseInt(input_s[1]);
			input_s = br.readLine().split(" ");
			int[] Ds = new int[N];
			for(int i=0;i<N;i++) {
				Ds[i] = Integer.parseInt(input_s[i]);
			}
			Rules rules = new Rules(N, K);
			for(int i=0;i<K;i++) {
				input_s = br.readLine().split(" ");
				rules.addRule(Integer.parseInt(input_s[0])-1,Integer.parseInt(input_s[1])-1, i);
			}
			int W = Integer.parseInt(br.readLine())-1;
			// input end
			
			int time = 0;
			LinkedList<int[]> progress = new LinkedList<>(); // [0] : remain time  [1] : D_index
			int[] current = new int[N];
			while(true) {
				calcPossiblity(current, rules);
				if(checkW(current, W)) {
					time += Ds[W];
					break;
				}
				
				buildPossible(current, progress, Ds);
				time += completeBuild(current, progress);
			}
			System.out.println(time);
		}
	}
	
	private static void calcPossiblity(int[] current, Rules rules) {
		for(int i=0;i<current.length;i++) {
			if(current[i] == 0) {
				if(rules.canBuild(i, current)) current[i] = 1;
			}
		}
	}
	
	private static boolean checkW(int[] current, int W_index) {
		if(current[W_index] == 1) return true;
		else return false;
	}
	
	private static void buildPossible(int[] current, LinkedList<int[]> progress, int[] Ds) {
		for(int i=0;i<current.length;i++) {
			if(current[i] == 1) {
				current[i] = 2;
				addProgress(progress, Ds[i], i);
			}
		}
	}
	
	private static int completeBuild(int[] current, LinkedList<int[]> progress) {
		if(progress.size()==0) return 0;
		int[] firstItem = progress.poll();
		int remains = firstItem[0];
		current[firstItem[1]] = 3;
		while(progress.size() > 0) {
			if(progress.peek()[0] == remains) {
				current[progress.peek()[1]] = 3;
				progress.removeFirst();
			} else break;
		}
		for(int i=0;i<progress.size();i++) {
			progress.get(i)[0] -= remains;
		}
		return remains;
	}
	
	// insertion to keep sorted list with remain time
	private static void addProgress(LinkedList<int[]> progress, int D_time, int D_index) {
		int[] item = {D_time,D_index};
		int counter = 0;
		for(int i=0;i<=progress.size();i++) {
			if(i==progress.size()) counter = -1;
			else if(progress.get(i)[0] >= D_time) {
				counter = i;
				break;
			}
		}
		if(counter == -1) progress.add(item);
		else progress.add(counter, item);
	}
}

class Rules {
	Rule[] rs;
	int[] need_start_index;
	LinkedList<Integer>[] needs_can_build;
	
	@SuppressWarnings("unchecked")
	Rules(int N, int K) {
		rs = new Rule[K];
		need_start_index = new int[N];
		needs_can_build = new LinkedList[N];
		for(int i=0;i<N;i++) {
			needs_can_build[i] = new LinkedList<Integer>();
		}
	}
	
	void RuleSort() {
		Arrays.sort(rs);
		int count = 0;
		for(int i=0;i<rs.length;i++) {
			if(count < rs[i].need) {
				for(;count<rs[i].need;count++) {
					need_start_index[count] = -1;
				}
				need_start_index[count] = i;
				count++;
			} else if(count == rs[i].need) {
				need_start_index[count] = i;
				count++;
			}
		}
		for(int i=count;i<need_start_index.length;i++) {
			need_start_index[i] = -1;
		}
	}
	
	void addRule(int a, int b, int index) {
		Rule r = new Rule(a,b);
		rs[index] = r;
		needs_can_build[b].add(a);
	}
	
	boolean canBuild(int D_index, int[] current) {
		LinkedList<Integer> temp = needs_can_build[D_index]; 
		for(int i=0;i<temp.size();i++) {
			if(current[temp.get(i)]!=3) return false;
		}
		return true;
	}
}

class Rule implements Comparable<Rule> {
	int need, can;
	
	Rule(int a, int b) {
		need = a-1;
		can = b-1;
	}

	@Override
	public int compareTo(Rule r) {
		if(need > r.need) return 1;
		else if(need < r.need) return -1;
		else {
			if(can > r.can) return 1;
			else if(can < r.can) return -1;
			else return 0;
		}
	}
	
	public String toString() {
		return "[" + need +":" + can +"]";
	}
}