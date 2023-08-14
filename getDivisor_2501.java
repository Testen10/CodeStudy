package CodeStudy;
import java.util.Scanner;


/*
 Input
 N K
 N: natural num
 K: Kth divisor
 
 Output
 Kth smallest divisor // if not exist, 0
 */
public class getDivisor_2501 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		int ans = 0;
		int target_num;
		
		if(N%2==1) {
			target_num = N+1;
		}
		else {
			target_num = N;
		}
		
		for(int i=1;i<=target_num/2;i++) {
			if(N%i == 0) {
				
				ans++;
				if(ans==K) {
					System.out.println(i);
					return;
				}
			}
		}
		
		 if(ans==K-1) System.out.println(N);
		 else System.out.println(0);		 
	}
}

