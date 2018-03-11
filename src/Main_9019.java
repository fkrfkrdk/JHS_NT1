import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_9019 {
	private static int A, B;
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		/*
		int T = Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
		}
		*/
		DSLR dslr = new DSLR();
		dslr.data = 1234;
		dslr.calcLR(false);
		System.out.println(dslr.data);
	}
}

class DSLR {
	int data;
	
	public void calcD() {
		data *= 2;
		if(data > 9999) data /= 10000;
	}
	
	public void calcS() {
		if(--data ==0) data = 9999;
	}
	
	public void calcLR(boolean L) {
		int[] ds = new int[4];
		int temp = data;
		int temp_d = 0;
		for(int i=3;i>=0;i--) {
			temp_d = temp%10;
			temp = temp/10;
			System.out.println(i);
			System.out.println(temp_d);
			System.out.println();
			if(L) {
				if(i==0) ds[3] = temp_d;
				else ds[i-1] = temp_d;
			} else {
				if(i==3) ds[0] = temp_d;
				else ds[i+1] = temp_d;
			}
		}
		temp = 1;
		data = 0;
		for(int i=3;i>=0;i--) {
			data += ds[i]*temp;
			temp *= 10;
		}
	}
}
