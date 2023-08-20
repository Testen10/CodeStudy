package CodeStudy.Baekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 모든 단어에 anta & tica가 들어감
 -> 단어를 읽으려면 적어도 a / n / t / i / c 5개를 알아야 함
 -> K가 5보다 작을 경우 0 출력
 -> 모든 단어 사용 가능한 경우 그냥  출
 
 
 시간초과 뜬다 
 
 */


public class teaching_1062 {
	static String[] word_list;
	static boolean[] alphabet_learned = new boolean[26];
	static int N;
	static int K;
	static int ans=0;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		// all word include at least 5 alphabet
		if(K<5) {
			System.out.println(0);
			return;
		}
		else {
			word_list = new String [N];
			
			K -=5;
			
			// anta & tica에 들어가는 알파벳은 알아야 함
			alphabet_learned['a'-97]=true;
			alphabet_learned['n'-97]=true;
			alphabet_learned['t'-97]=true;
			alphabet_learned['i'-97]=true;
			alphabet_learned['c'-97]=true;
		}
		
		for(int idx=0;idx<N;idx++) { 
			String word = br.readLine();
			word = word.substring(4,word.length()-4); // anta & tica 제거
			word_list[idx] = word;
		}
		
		
		// if the student can learn all alphabet needed to read given words
		if(K==26) {
			System.out.println(N);
			return;
		}
		
		dfs(0,0);
		
		System.out.println(ans);
	}
	
	public static void dfs(int cnt, int start) {
		// max number of alphabet learned
		if(cnt==K) {
			int temp = 0;
			for(int idx=0;idx<N;idx++) {
				boolean isLearnable = true;
				for(int alp=0;alp<word_list[idx].length();alp++) {
					if(!alphabet_learned[word_list[idx].charAt(alp)-'a']){
						isLearnable=false;
						break;
					}
				}
				// all alphabet in the word learned
				if(isLearnable) temp ++;
			}
			
			ans = Math.max(temp, ans);
			return;
		}
		
		// idx=start인 이유: 한 번 들럿던 알파벳은 들리지 않아야 시간 단축됨 
		for(int idx=start;idx<26;idx++) {
			if(!alphabet_learned[idx]) {
				alphabet_learned[idx] = true;
				dfs(cnt+1, idx+1);
				// dfs 복구하고 다시 원래 상태로 복구
				alphabet_learned[idx] = false;
			}
		}
		
	}

}
