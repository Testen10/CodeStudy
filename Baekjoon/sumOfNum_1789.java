package CodeStudy.Baekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 Input
 S
 S: sum of N integer
 
 Output
 max val of N
 
 서로 다른 자연수여야 함
 근데 N이 최대가 되려면 1부터 1씩 증가해야 함 
 -> 1부터 더하고 숫자보다 커지는 시점을 파악, 딱 맞으면 그대로 출력 안 맞으면 최종 답에서 1 빼고 출력 (합하는 수 중 초과되는 수를 빼면 되니까)
 
 */
public class sumOfNum_1789 {
	static long sum;
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		sum = Long.parseLong(st.nextToken());
		
		System.out.println(getSumNum()-1);
	}
	
	// 등차수열의 합 이용 -> 너무 큰 수를 넣으면 못 걸러냄
	// 
	static long getSumNum() {
		long idx= 1;
		while(true) {
			long temp = idx*(1+idx)/2;
			if(temp>sum) return idx;
			idx++;
		}
	}
	
}
