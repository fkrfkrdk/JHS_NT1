import java.util.*;

public class Main_1107_ {
	static boolean[] broken;
	static int target;
	static int[] low;
	static int[] high;
	
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		
		target = sc.nextInt();
		int M = sc.nextInt();
		broken = new boolean[10];
		for(int i=0; i<M; i++)	broken[sc.nextInt()] = true;
		
		
		// same digit
		low = new int[(target == 0 ? 0 : (int)Math.log10(target) + 1)];
		high = new int[(target == 0 ? 1 : (int)Math.log10(target) + 1)];
		int tmp = target;
		for(int i=low.length - 1; i>=0; i--){
			low[i] = tmp%10;
			high[i] = tmp%10;
			tmp/=10;
		}
		
		boolean lowpossible = nextLow();
		boolean highpossible = nextHigh();
		
		int lowInteger = 0;
		for(int i=0; i<low.length; i++)
			lowInteger = lowInteger*10 + low[i];
		
		int highInteger = 0;
		for(int i=0; i<high.length; i++)
			highInteger = highInteger*10 + high[i];
		
		lowInteger = (!lowpossible ? Integer.MAX_VALUE : Math.abs(target - lowInteger) + low.length);
		highInteger = (!highpossible ? Integer.MAX_VALUE : Math.abs(target - highInteger) + high.length);
		
		
		// digit difference
		low = new int[(target == 0 ? 0 : (int)Math.log10(target))];
		high = new int[(target == 0 ? 2 : (int)Math.log10(target) + 2)];
		tmp = target;
		for(int i=low.length - 1; i>=0; i--)
			low[i] = 9;
		
		for(int i=0; i<high.length; i++)
			high[i] = (i == 0 ? 1 : 0);
		
		boolean lowpossible1 = nextLow();
		boolean highpossible1 = nextHigh();
		
		int lowInteger1 = 0;
		for(int i=0; i<low.length; i++)
			lowInteger1 = lowInteger1*10 + low[i];
		int highInteger1 = 0;
		for(int i=0; i<high.length; i++)
			highInteger1 = highInteger1*10 + high[i];

		
		int justClick = Math.abs(target - 100);

		lowInteger1 = (!lowpossible1 ? Integer.MAX_VALUE : (Math.abs(target - lowInteger1) + low.length));
		highInteger1 = (!highpossible1 ? Integer.MAX_VALUE : (Math.abs(target - highInteger1) + high.length));

		lowInteger = Math.min(lowInteger1, lowInteger);
		highInteger = Math.min(highInteger, highInteger1);
		
		System.out.println("A:"+highInteger);
		System.out.println("B:"+lowInteger);
		
		System.out.println(Math.min(Math.min(lowInteger, highInteger), justClick));
		sc.close();
	}
	
	static boolean nextLow(){
		if(low.length == 0)	return false;
		if(!broken[low[0]])	return nextLowHelper(1, true, true);
		else				return nextLowHelper(0, true, false);
	}
	
	
	static boolean nextLowHelper(int index, boolean fromI, boolean exact){
		if(index == -1)	return false;
		if(index == low.length)		return true;
		
		if(low[index] == -1 && index == 0)	return false;
		else if(low[index] == -1){
			low[index] = 9;
			low[index-1]--;
			return nextLowHelper(index-1, true, false);
		}
		
		int max;
		if(fromI){
			for(max=low[index]; max>=0 && broken[max]; max--);
			boolean still = (max == low[index]);
			if(max == -1 && index != 0){
				low[index] = 9;
				low[index-1]--;
				return nextLowHelper(index-1, true, false);			// can't find 
			} else if(max == -1){
				return false;
			} else{
				low[index] = max;
				return nextLowHelper(index+1, fromI && still && exact, still && exact);
			}
		} else{
			for(max=9; max>=0 && broken[max]; max--);
			low[index] = max;
			return nextLowHelper(index+1, fromI, exact);
		}
	}
	
	
	
	static boolean nextHigh(){
		if(high.length == 0)	return false;
		if(!broken[high[0]])	return nextHighHelper(1, true, true);
		else					return nextHighHelper(0, true, false);
	}
	
	static boolean nextHighHelper(int index, boolean fromI, boolean exact){
		if(index == -1)				return false;
		if(index == high.length)	return true;

		if(high[index] == 10 && index == 0)	return false;
		else if(high[index] == 10){
			high[index] = 0;
			high[index-1]++;
			return nextHighHelper(index-1, true, false);
		}
		
		int min;
		if(fromI){
			for(min=high[index]; min<10 && broken[min]; min++);
			boolean still = (min == high[index]);
			if(min == 10 && index != 0){
				high[index] = 0;
				high[index-1]++;
				return nextHighHelper(index-1, true, false);
			} else if(min == 10){			// can't find 
				return false;
			} else{
				high[index] = min;
				return nextHighHelper(index+1, fromI && still && exact, still && exact);
			}
		} else{
			for(min=0; min<10 && broken[min]; min++);
			high[index] = min;
			return nextHighHelper(index+1, fromI, exact);
		}
	}
}