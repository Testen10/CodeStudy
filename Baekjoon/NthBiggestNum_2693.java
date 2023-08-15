package CodeStudy.Baekjoon;
import java.util.Scanner;
import java.util.ArrayList;

/*
 Input
 T
 array A
 
 T: number of array
 A: ten numbers, seperated by space
 
 Output
 3th biggest number of each array
 */

public class NthBiggestNum_2693 {
	static ArrayList<Integer> num_list = new ArrayList<Integer>();
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		for(int num=0;num<N;num++) {
			for(int idx = 0;idx<10;idx++) {
				num_list.add(sc.nextInt());
			}
			quick_sort(0,9);
			System.out.println(num_list.get(7));
			num_list.clear();
		}
	}
	
	public static void quick_sort(int low, int high) {
		if (high>low) {
			int pivotPoint = random_partition(low,high);
			quick_sort(low, pivotPoint);
			quick_sort(pivotPoint+1, high);
		}
	}
	
	public static int partition(int low, int high) {
		int pivotVal = num_list.get(low);
		int j = low;
		
		for(int i=low+1; i<high+1;i++) {
			if(num_list.get(i)<pivotVal) {
				j++;
				int temp = num_list.get(i);
				num_list.set(i, num_list.get(j));
				num_list.set(j, temp);
			}
		}
		
		int pivotLoc = j;
		int temp = num_list.get(low);
		num_list.set(low, num_list.get(pivotLoc));
		num_list.set(pivotLoc, temp);
		
		return pivotLoc;
		
	}
	
	public static int random_partition(int low, int high) {
		int i = (int) (Math.random() * (high-low+1)) + low;
		int temp = num_list.get(low);
		num_list.set(low, num_list.get(i));
		num_list.set(i, temp);
		
		return partition(low,high);
		
	}
}
