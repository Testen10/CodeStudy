package CodeStudy.Baekjoon;

import java.util.Scanner;
import java.util.ArrayList;
/*
 Input
 nine dwarf's height
 
 Output
 seven dwarf's sorted height / sum of height = 100
 */
public class sevenDwarf_2309 {
	static ArrayList<Integer> num_list;
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		num_list = new ArrayList<Integer>();
		
		for(int idx=0;idx<9;idx++) num_list.add(sc.nextInt());
		
		// randomized pivot sort
		quick_sort(0,8);
		
		int sum = 0;
		
		// get sum of all nine dwarf's height
		for(int idx=0;idx<9;idx++) {
			sum = sum+num_list.get(idx);
		}
		
		// get two dwarf's height / (sum of nine dwarf's height)-(sum of two dwarf's height) = 100 --> remove two dwarf's height
		for(int idx=num_list.size()-1;idx>=0;idx--) {
			int val = sum-100-num_list.get(idx);
			if(num_list.contains(val)) {
				num_list.remove(idx);
				num_list.remove(num_list.indexOf(val));
				break;
			}
		}
		
		for(int idx=0;idx<7;idx++) {
			System.out.println(num_list.get(idx));
		}
	}
	
	public static void quick_sort(int low, int high) {
		if (high>low) {
			int pivotPoint = rand_partition(low,high);
			quick_sort(low, pivotPoint);
			quick_sort(pivotPoint+1, high);
		}
	}
	
	public static int partition(int low, int high) {
		int pivotVal = num_list.get(low);
		int j = low;
		
		for(int i=low+1;i<high+1;i++) {
			if(num_list.get(i) < pivotVal) {
				j++;
//				System.out.println(num_list.get(i));
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
	
	public static int rand_partition(int low, int high) {
		int i = (int) (Math.random() * (high-low+1)) + low;
		int temp = num_list.get(i);
		num_list.set(i, num_list.get(low));
		num_list.set(low, temp);
		
		return partition(low,high);
	}
	
	
}