package NYPC2022;

import java.util.Scanner;
import java.util.Arrays;

/* docstring
Input
N M
t i s
user num N
recod num M

start / end time t
user num i
start-> s=0 / end -> s=1

Output
Yes/No
correct record / wrong record
 */
public class raceRecord {
	static int[][] user_rec;
	public static void main(String args[]) {
		 Scanner scanner = new Scanner(System.in);		 
		 int N = scanner.nextInt();
		 int M = scanner.nextInt();
		 String ans = "Yes";
		 
		 user_rec = new int[N][2];
		 
		 for (int i = 0; i < N; i++) {
			 Arrays.fill(user_rec[i], -1);
		 }
		 
		 for (int row = 0; row < M; row++) {
			 int t = scanner.nextInt();
			 int i = scanner.nextInt();
			 int s = scanner.nextInt();
			 
			 if (!check_userRec(t,i,s)) {
				 ans = "No";
				 break;
			 }
		 }
		 
		 for (int i = 0; i < N; i++) {
			 if ((user_rec[i][0] != -1 && user_rec[i][1] == -1) || (user_rec[i][0] == -1 && user_rec[i][1] != -1)) {
				 // 경기가 온전하게 끝나지 않았을 경우 ans = No
				 ans = "No";
			 }
		 }
		 
		 System.out.println(ans);
		 
	}
	
	public static boolean check_userRec(int t, int i, int s) {
		if (s == 0){ // start point
			if (user_rec[i-1][0]==-1) { // 시작 time에 기록 X
				user_rec[i-1][0] = t;
				return true;
			}
		}
		else { // end point
			if (user_rec[i-1][0]!=-1) { // 시작 time에 기록이 존재
				if (t-user_rec[i-1][0]>59) { // 59초 이상 걸/
					user_rec[i-1][0] = -1;
					return true;
				}
			}
		}
		System.out.println(t);
		System.out.println(i);
		System.out.println(s);
		return false;
	}
}
