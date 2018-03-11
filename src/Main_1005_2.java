import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class Main_1005_2 {
	static InputReader in = new InputReader(System.in);
	private static int[] calced;
	
	public static void main(String args[]) throws Exception {
		
		int T = in.nextInt();
		for(int t=0;t<T;t++) {
			int N = in.nextInt();
			int K = in.nextInt();
			calced = new int[N];
			for(int i=0;i<N;i++) {
				calced[i] = -1;
			}
			int[] Ds = in.nextIntArray(N);
			
			@SuppressWarnings("unchecked")
			ArrayList<Integer>[] needs = new ArrayList[N];
			for(int i=0;i<N;i++) {
				needs[i] = new ArrayList<Integer>();
			}
			int[] temp = in.nextIntArray(2);
			for(int i=0;i<K;i++) {
				needs[temp[1]-1].add(temp[0]-1);
			}
			int W = in.nextInt()-1;
			System.out.println(calc(W, needs, Ds));
		}
	}

	private static int calc(int w, ArrayList<Integer>[] needs, int[] Ds) {
		if(calced[w] != -1) {
			return calced[w];
		}
		
		int result = Ds[w];
		int temp = 0;
		for(int i=0;i<needs[w].size();i++) {
			temp = Math.max(temp, calc(needs[w].get(i), needs, Ds));
		}
		result += temp;
		calced[w] = result;
		return result;
	}
}

class InputReader {
	private final InputStream stream;
	private final byte[] buf = new byte[8192];
	private int curChar, snumChars;
	
	public InputReader(InputStream st) {
		this.stream = st;
	}
	
	public int read() {
		if (snumChars == -1)
			throw new InputMismatchException();
		if (curChar >= snumChars) {
			curChar = 0;
			try {
				snumChars = stream.read(buf);
			} catch (IOException e) {
				throw new InputMismatchException();
			}
			if (snumChars <= 0)
				return -1;
		}
		return buf[curChar++];
	}
	
	public int nextInt() {
		int c = read();
		while (isSpaceChar(c)) {
			c = read();
		}
		int sgn = 1;
		if (c == '-') {
			sgn = -1;
			c = read();
		}
		int res = 0;
		do {
			res *= 10;
			res += c - '0';
			c = read();
		} while (!isSpaceChar(c));
		return res * sgn;
	}
	public int[] nextIntArray(int n) {
		int a[] = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = nextInt();
		}
		return a;
	}
	public boolean isSpaceChar(int c) {
		return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
	}
}
