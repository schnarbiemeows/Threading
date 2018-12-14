
public class QuickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] intArray = {11,22,-33,4,16,-55,0,2,12,0};
		System.out.print("[");;
		for(int i = 0; i<intArray.length; i++) {
			System.out.print(intArray[i]+",");
		}
		System.out.println("]");
		
		quickSort(intArray,0,intArray.length);
		System.out.print("[");;
		for(int i = 0; i<intArray.length; i++) {
			System.out.print(intArray[i]+",");
		}
		System.out.println("]");
		
		
	}
	
	public static void quickSort(int[] input, int min, int max) {
		if(max-min<2) {
			return;
		}
		int midpoint = partition(input, min, max);
		quickSort(input,min,midpoint);
		quickSort(input,midpoint+1,max);
	}
	
	public static int partition(int[] input, int min, int max) {
		int pivot = input[min];
		int start = min;
		int end = max;
		while(start<end) {
			while(start<end&&input[--end]>pivot) ;
			if(start<end) {
				input[start] = input[end];
			}
			while(start<end&&input[++start]<pivot) ;
			if(start<end) {
				input[end] = input[start];
			}
		}
		
		
		input[end] = pivot;
		return end;
	}

}
