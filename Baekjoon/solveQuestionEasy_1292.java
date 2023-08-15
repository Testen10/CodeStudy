package CodeStudy.Baekjoon;

import java.util.Scanner;

/*
 Input
 A, B
 A: start number
 B: end number
 */

public class solveQuestionEasy_1292 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();
		int B = sc.nextInt();
		
		// (sum of num from range 1~B) - (sum of num from range 1~(A-1)) = (sum of num from A~B)
		System.out.println(getSum(B)-getSum(A-1));
	}
	
	public static int getSum(int A) {		
		int num_loc = 1;
		int sum = 0;
		int num = 1;
		int cnt = 0;
		
		while(true){
			for(int idx=0;idx<num;idx++) {
				if(cnt==A) return sum;
				sum = sum+num;
				cnt ++;
			}
			num++;
		}
	}
}
