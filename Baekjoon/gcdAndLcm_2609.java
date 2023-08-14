package CodeStudy.Baekjoon;

import java.util.Scanner;
/*
 Input
 two integer
 
 Output
 GCD
 LCM
 */

public class gcdAndLcm_2609 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		int N1 = sc.nextInt();
		int N2 = sc.nextInt();
		
		if(N1<N2) {
			int temp = N1;
			N1 = N2;
			N2 = temp;
		}
		int gcd = get_gcd(N1,N2);
		System.out.println(gcd);
		
		int lcm = (int)N1*N2/gcd;
		System.out.println(lcm);
	}
	
	// Euclidean algorithm
	public static int get_gcd(int N1, int N2) {
		int remainder = N1%N2;
		if(remainder == 0) return N2;
		else return get_gcd(N2,remainder);
	
	}
	
}
