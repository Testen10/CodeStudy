package CodeStudy.Baekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.HashMap;

/*
 Input
 n k
 n lines of coins' value
 
 k: demanded sum of val
 
 Output
 num of case
 */

/*
 dynamic programming
 
 dfs 사용해서 더해나가기, 만약 값이 k와 일치 -> 똑같은 구성 요소로 한 그게 잇는지 확인, 없으면 ans+1
 
 dfs(sum_val)
 	if sum_val == k
 		for(success_case)
 			if usedCoin_list[] .. 
 			 -> ans
 			 
 	for(idx:coinValList)
 		usedCoin_list[idx]+=1
 		dfs(sum_val+idx)
 		usedCoin_list[idx]-=1
  */

public class coin1_2293 {
	static int n;
	static int k;
	static int[] coinVal_list;
	static ArrayList<int[][]> successCase_list = new ArrayList<int[][]>(10^5);
	static int ans;
	public static void main(String args[]) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		coinVal_list = new int[n];
		
		for (int idx=0;idx<n;idx++) {
			st = new StringTokenizer(br.readLine());
			coinVal_list[idx] = Integer.parseInt(st.nextToken());
		}
		
		dfs(0, init_currList());
		
		System.out.println(ans);
	}
	
	public static void dfs(int sum_val, int[][] usedCoin_list) {
		if(sum_val==k) {
			if(ans==0) { // successCase가 하나도 없을 경우 -> 처음 추가하는 케이스는 아무 조건 X 
				successCase_list.add((int[][]) usedCoin_list.clone());
				ans++;
			}
			else { 
				for(int[][] curr_intList:successCase_list) {
					if(isSameList(usedCoin_list,curr_intList)) {
						return;
					}
				}
				successCase_list.add((int[][]) usedCoin_list.clone());
				ans++;
			}
			return;
		}
		
		for(int idx=0;idx<n;idx++) {
			if(sum_val+coinVal_list[idx]<=k) { // 초과하는 경우를 없앰 
				usedCoin_list[idx][1] += 1;
				dfs(sum_val+coinVal_list[idx], usedCoin_list);
				usedCoin_list[idx][1] -= 1;
			}
		}
	}
	
	public static boolean isSameList(int[][] intList1, int[][] intList2) {
		for(int idx=0;idx<n;idx++) {
			if(intList1[coinVal_list[idx]][1] != intList2[coinVal_list[idx]][1]) return false;
			}
		return true;
	}
	
	public static int[][] init_currList() {
		int[][] intList = new int[n][2];
		
		for(int idx=0;idx<n;idx++) {
			intList[idx][0] = coinVal_list[idx];
			intList[idx][1] = coinVal_list[idx];
		}
		
		return intList;
	}	
}
