package �����ϴ����α׷��ִ�ȸOpenContest;

/*
 * array�� ���� ����(length)�� ���ȣ ����(index)
 * - array�� ����(length)�� 1���� ����
 * - array�� ���ȣ(index)�� 0���� ���� ~ (length - 1)���� ����
 * array�� �ϳ��� ������ ��������� �޸��Ͽ� ������ ����
 * - while�� �Ǵ� for���� ���� �ݺ����� �Բ� ����ϸ� ȿ����
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




