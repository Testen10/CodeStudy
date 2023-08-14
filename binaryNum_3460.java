package CodeStudy;

import java.util.Scanner;
/*
 Input
 T
 n
 T: num of test case
 
 Output
 각 테스트 케이스에 대해서, 1의 위치를 공백으로 구분해서 줄 하나에 출력한다. 위치가 낮은 것부터 출력한다.
 */
public class binaryNum_3460 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int idx = 0;idx<T;idx++) {
			get_loc(sc.nextInt());
		}
		
		
	}
	
	public static void get_loc(int num) {
		int idx = 0;
		while(num>=1) {
			if(num%2==1) {
				System.out.print(idx);
				System.out.print(" ");
				num--;
			}
			num = num/2;
			idx++;
		}
		System.out.println("");
	}
}
