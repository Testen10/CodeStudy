package CodeStudy.Baekjoon;

import java.util.Scanner;
/*
 Input
 H W
 W integer (0<=integer<=H)
 H: height
 W: width
 
 Output
 sum of raindrop
 
 curr height를 max height으로 설정
 for loop
 max height>curr_height -> sum += height-curr_height
 max height<curr_height -> max height = curr_height
 */
public class rainDrop_14719 {
	static int [] rain_list;
	static int sum=0;
	static int H;
	static int W;
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		H = sc.nextInt();
		W = sc.nextInt();
		
		rain_list = new int[W];
		
		for(int idx = 0;idx<W;idx++) rain_list[idx] = sc.nextInt();

		count();
		
		System.out.println(sum);
		
	}
	
	public static void count() {
		for(int h=0;h<H;h++) {
			int temp = 0;
			boolean left_wall=false;
			for(int w=0;w<W;w++) {
				// 고이기 시작하기 위해서는 왼쪽이 막혀있어야 
				if(rain_list[w]>h && !left_wall) left_wall=true;
				// 왼쪽보다 낮다면 빗물이 고임
				else if (left_wall && rain_list[w]<=h) temp ++;
				// 오른쪽이 막혀있으면 sum 값에 추가
				else if (left_wall && rain_list[w]>h) {
					sum += temp;
					temp = 0;
				}
			}
		}
	}
}
