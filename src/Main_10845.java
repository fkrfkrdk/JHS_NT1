 

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_10845 {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		MyQueue queue = new MyQueue();
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<N;i++) {
			String com = br.readLine();
			switch(com.charAt(1)) {
			case 'u':
				queue.push(Integer.parseInt(com.substring(5, com.length())));
				break;
			case 'r':
				sb.append(queue.front()+"\n");
				break;
			case 'i':
				sb.append(queue.size()+"\n");
				break;
			case 'm':
				sb.append(queue.empty()+"\n");
				break;
			case 'a':
				sb.append(queue.back()+"\n");
				break;
			case 'o':
				sb.append(queue.pop()+"\n");
			}
		}
		System.out.println(sb);
		br.close();
	}
}

class MyQueue {
	private int[] que = new int[20000];
	private int size = 0;
	private int front = 0;
	private int back = -1;
	
	
	void push(int x) {
		if(size == que.length) refresh();
		back = back==que.length-1?0:back+1;
		que[back] = x;
		size++;
	}
	private void refresh() {
		int[] newQue = new int[que.length*2];
		for(int i=0;i<size;i++) {
			newQue[i] = que[front+i>=que.length?front+i-que.length:front+i];
		}
		front = 0;
		back = size-1;
		que = newQue;
	}
	int pop() {
		int result = que[front];
		if(size == 0) return -1;
		front = front==que.length-1 ? 0:front+1;
		size--;
		return result;
	}
	int size() {
		return size;
	}
	int empty() {
		return size==0?1:0;
	}
	int front() {
		if(size == 0) return -1;
		return que[front];
	}
	int back() {
		if(size == 0) return -1;
		return que[back];
	}
}