
public class testtest {
	public static void main(String args[]) {
		String s = new String();
		
		MyClass my = new MyClass(2);
		
		MyClass my2 = new MyClass(3);
	}
}

class MyClass {
	int a = 1;
	
	MyClass(int a) {
		this.a = a;
		
	}
	
	MyClass() {
	}
	public int plus(int a, int b) {
		return a+b;
	}
	
	public int plus(int a, int b, int c) {
		return plus(a,b)+c;
	}
}

class MyClass2 extends MyClass {
	
	MyClass2() {
		super();
	}
	
	public int plus(int a, int b) {
		
		return super.plus(a, b)+1;
	}
}