import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1991 {
	private static String[] rules;
	private static Node1 root;
	private static StringBuilder pre = new StringBuilder(), mid = new StringBuilder(), post = new StringBuilder();
	
	public static void main(String ags[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		rules = new String[N];
		root = new Node1('A');
		
		for(int i=0;i<N;i++) {
			String temp = br.readLine();
			rules[temp.charAt(0)-65] = temp.substring(2);
		}
		
		fillTree(root, 'A');
		
		preOrder(root);
		System.out.println(pre);
		midOrder(root);
		System.out.println(mid);
		postOrder(root);
		System.out.println(post);
	}
	
	private static void fillTree(Node1 cur, char ch) {
		int cur_ch = ch-65;
		
		String rule = rules[cur_ch];
		if(rule.charAt(0) != '.') {
			cur.left = new Node1(rule.charAt(0));
			fillTree(cur.left, rule.charAt(0));
		}
		if(rule.charAt(2) != '.') {
			cur.right = new Node1(rule.charAt(2));
			fillTree(cur.right, rule.charAt(2));
		}
	}
	
	private static void preOrder(Node1 cur) {
		pre.append(cur.value);
		if(cur.left!=null) preOrder(cur.left);
		if(cur.right!=null) preOrder(cur.right);
	}
	
	private static void midOrder(Node1 cur) {
		if(cur.left!=null) midOrder(cur.left);
		mid.append(cur.value);
		if(cur.right!=null) midOrder(cur.right);
	}
	
	private static void postOrder(Node1 cur) {
		if(cur.left!=null) postOrder(cur.left);
		if(cur.right!=null) postOrder(cur.right);
		post.append(cur.value);
	}
}

class Node1 {
	Node1 left, right;
	char value;
	
	Node1(char v) {
		value = v;
	}
}
