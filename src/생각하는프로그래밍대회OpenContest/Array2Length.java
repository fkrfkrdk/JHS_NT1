package 생각하는프로그래밍대회OpenContest;

/*
 * array의 길이 개념(length)과 방번호 개념(index)
 * - array의 길이(length)는 1부터 시작
 * - array의 방번호(index)는 0에서 시작 ~ (length - 1)에서 종료
 * array는 하나의 변수명에 방번지만을 달리하여 접근이 가능
 * - while문 또는 for문과 같은 반복문과 함께 사용하면 효과적
 */
public class Array2Length {

	public static void main(String[] args) {
		int [] intArr = new int[5];
		intArr[0] = 777;
		intArr[1] = 888;
		intArr[2] = 999;
		System.out.println("intArr.length : " + intArr.length);

		int [] intArr2 = new int[3];
		for(int i = 0; i < intArr2.length; i++){
			intArr2[i] = 3 * i;
		}

		for(int i = 0; i < intArr2.length; i++){
			System.out.println("intArr2["+i+"] : " + intArr2[i]);
		}

	}//end of main

}




