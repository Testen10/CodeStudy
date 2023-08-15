package CodeStudy.Baekjoon;
import java.util.Scanner;
import java.util.ArrayList;

/*
 Input
 N
 N integer
 N: number of integer
 
 Output
 num of prime num
 
 */
public class findPrimeNum_1978 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int ans = 0;
		
		for(int idx =0;idx<N;idx++) {
			if(is_Prime(sc.nextInt())) ans++;
		}
		
		System.out.println(ans);
		
	}
	
	public static boolean is_Prime(int num) {
		// 1 is not prime num
		if(num==1) return false;
		
		// number theory
		int start_num = (int) Math.sqrt(num);
		
		for(int idx = start_num;idx>1;idx--) {
			if(num%idx==0) return false;
		}
		return true;
	}
}
