package CodeStudy;

import java.util.Scanner;
/*
 Input
 10 lines of num of passengers getting off & passengers getting on
 
 Output
 max num of passengers
 */
public class smartTrain_2460 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int num = 0;
		int max_num = -1;
		int idx = 0;
		
		while(idx<10) {
			num = num-sc.nextInt();
			num = num+sc.nextInt();
			
			if(num>max_num) {
				max_num = num;
			}
			idx++;
		}
	System.out.println(max_num);
	}
	
}
