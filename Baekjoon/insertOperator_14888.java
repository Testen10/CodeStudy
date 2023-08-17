package CodeStudy.Baekjoon;
import java.util.Scanner;
import java.util.ArrayList;

/*
 Input
 integer N
 N integer A1, A2,A3...AN
 four integer, sum of four integer=N-1
 
 Output
 max num that can be created
 min num that can be created
 */

public class insertOperator_14888 {
	static ArrayList<Integer> num_list = new ArrayList<Integer>();
	static ArrayList<Integer> op_list = new ArrayList<Integer>();
	static int N;
	static int min_val = Integer.MAX_VALUE;
	static int max_val = Integer.MIN_VALUE;
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		for(int idx=0;idx<N;idx++) {
			num_list.add(sc.nextInt());
		}
		for(int idx=0;idx<4;idx++) {
			op_list.add(sc.nextInt());
		}
		
		caculate(1,num_list.get(0));
		System.out.println(max_val);
		System.out.println(min_val);
	}
	
	// dfs
	public static void caculate(int cnt, int calc_result) {
		if(cnt==N) {
			max_val = Math.max(calc_result, max_val);
			min_val = Math.min(calc_result, min_val);
			return;
		}
		
		for(int idx =0;idx<4;idx++) {
			if(op_list.get(idx)>0) {
				op_list.set(idx, op_list.get(idx)-1);
				switch(idx) {
					case 0: caculate(cnt+1,calc_result+num_list.get(cnt));
							break;
					case 1: caculate(cnt+1,calc_result-num_list.get(cnt));
							break;
					case 2: caculate(cnt+1,calc_result*num_list.get(cnt));
							break;
					case 3: caculate(cnt+1,(int) calc_result/num_list.get(cnt));
							break;
					default: return;
				}
				op_list.set(idx, op_list.get(idx)+1);
			}
		}
	}
	
}
