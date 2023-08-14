package CodeStudy.Baekjoon;

import java.util.Scanner;
/*
 Input
 int n
 
 Output
 nth fibonacchi num
 */

public class Fibonacchi_10870 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		int first_num = 0;
		int sec_num = 1;
		int ans = 0;
		
		int n = sc.nextInt();
		
		if(n==0) {
			System.out.println(first_num);
			return;
		}
		else if(n==1) {
			System.out.println(sec_num);
			return;
		}
		
		for(int idx=2;idx<=n;idx++) {
			ans = first_num+sec_num;
			first_num = sec_num;
			sec_num = ans;
		}
		
		System.out.println(ans);
	}
}
