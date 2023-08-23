package CodeStudy.Baekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 Input
 N K
 K INTEGER
 N: num of multitab hole
 K: total usage num
 
 Output
 min num of unplugging plug
 
 Greedy alogrithm
 꽂힌 멀티탭이 K보다 적을 경우 -> 꽂기 (plugged[idx] = true)
 K일 경우 -> 앞으로 사용량이 가장 많은 놈을 남겨두고 가장 적은 놈을 뽑기
 
 if plugged_num=0 && plugged[usage[idx]] = false
 -> 남은 사용횟수가 제일 적게 남은 놈 찾아서 넣기
 */

public class multiTabScheduling_1700 {
	static int N;
	static int K;
	static boolean [] plugged; // 현재 플러그 된 전기제품들 보여
	static int [] usage_order; // Input 2번째 줄
	static int ans;
	static int plugged_num = 0;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		usage_order = new int[K];
		plugged = new boolean[K+1];
		
		st = new StringTokenizer(br.readLine());
		
		for(int idx=0;idx<K;idx++) usage_order[idx]=Integer.parseInt(st.nextToken());
		
		greedy(0);
		
		System.out.println(ans);
		
		
	}
	public static void greedy(int cnt) {
		if(cnt==K) return;
		
		int cur_elec = usage_order[cnt];
		
		// 사용해야 하는 전자제품 코드가 꽂혀있지 않음
		if(!plugged[cur_elec]) {
			// 남은 멀티탭 구멍이 있을 경우 꽂기 
			if(plugged_num<N) {
				plugged[cur_elec]= true;
				plugged_num ++;
			}
			// 남은 멀티탭 구멍이 없을 경우 
			else {
				int last_usage = Integer.MIN_VALUE;
				int last_used_plug = -1;
				
				// 이미 꽂혀있는 플러그들 중 제일 적게 쓸 예정인 플러그 고르기 
				for(int idx=1;idx<K+1;idx++) {
					if(plugged[idx]) {
						if(last_usage(idx, cnt)==-1) {
							last_used_plug = idx;
							break;
						}
						else if(last_usage(idx, cnt) > last_usage) {
							last_used_plug = idx;
							last_usage = last_usage(idx, cnt);
						}
					}
				}
				
				plugged[last_used_plug] = false;
				plugged[cur_elec] = true;
				ans++;
			}
		}
		
		greedy(cnt+1);
	}
	
	// 가장 빨리 제품이 사용되는 때 출력 
	public static int last_usage(int idx, int start) {
		for(int loc=start;loc<K;loc++) {
			if(usage_order[loc]==idx) return loc;
		}
		//다시 사용되지 않는 경우 
		return -1;
	}
}
