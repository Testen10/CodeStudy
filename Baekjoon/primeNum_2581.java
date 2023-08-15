package CodeStudy.Baekjoon;

import java.util.Scanner;
import java.util.ArrayList;

/*
 Input
 M
 N
 
 M: range start num
 N: range end num
 
 Output
 sum of prime num within range
 smallest prime num
 
 if prime num doesn't exist in the range, output = -1
 */

public class primeNum_2581 {
	static ArrayList<Integer> primeNum_list = new ArrayList<Integer>();
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		int M = sc.nextInt();
		int N = sc.nextInt();
		
		get_primeNum(N);
		
		if(get_primeNum_min(M)==-1) {
			System.out.println(-1);
			return;
		}
		else {
			System.out.println(get_primeNum_sum(M));
			System.out.println(get_primeNum_min(M));
			
		}
	}
	
	public static void get_primeNum(int num) {
		for(int idx = 2;idx<=num;idx++) {
			if (is_primeNum(idx)) primeNum_list.add(idx);
		}
	}
	
	public static boolean is_primeNum(int num) {
		if(primeNum_list.isEmpty()) {
			return true;
		}
		else {
			for(int idx =0;idx<primeNum_list.size();idx++) {
				if(num%primeNum_list.get(idx)==0) return false;
			}
		}
		
		return true;
		
	}
	
	public static int get_primeNum_sum(int num) {
		int sum = 0;
		
		for(int idx=primeNum_list.size()-1;idx>=0;idx--) {
			if(primeNum_list.get(idx)>=num) sum = sum+primeNum_list.get(idx);
			else break;
		}
		return sum;
	}
	
	public static int get_primeNum_min(int num) {
		int ans = -1;
		for(int idx=0;idx<primeNum_list.size();idx++) {
			if(primeNum_list.get(idx)>=num) {
				ans = primeNum_list.get(idx);
				break;
			}
			
		}
		return ans;
	}
}
