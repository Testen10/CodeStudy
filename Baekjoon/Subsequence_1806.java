package CodeStudy.Baekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 Input
 N S
 N integer
 
 N: num of integer given in second line
 S: demanded sum of elemnets in second line
 
 Output
 min length of the subsequence of consecutive elemtns of the sequence, greater than or equal to S
 */
public class Subsequence_1806 {
	static int N;
	static int S;
	static int[] num_list;
	static int left=0;
	static int right=0;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		num_list = new int[N];
		
		st = new StringTokenizer(br.readLine());
		
		for(int idx=0;idx<N;idx++) num_list[idx] = Integer.parseInt(st.nextToken());
		
		System.out.println(twoPointer());
		
	}
	
	public static int twoPointer() {
		int sum_val=num_list[left];
		int ans=Integer.MAX_VALUE;
		while(true) {
			if(sum_val>=S) {
				ans = Math.min(right-left+1,ans);
				sum_val-=num_list[left];
				left++;
			}
			else{
				right++;
				if(right==N) break;
				else sum_val += num_list[right];
			}
		}
		if(ans!=Integer.MAX_VALUE) return (ans);
		else return 0;
	}
	
}
