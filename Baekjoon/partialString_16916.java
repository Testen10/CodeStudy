package CodeStudy.Baekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Map;
import java.util.HashMap;

/*
 Input
 S
 P
 
 S: given string
 P: pattern
 
 Output
 if P is partial string of S, 1, else 0
 
 KMP
 */
public class partialString_16916 {
	static String given;
	static String pattern;
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		given = st.nextToken();
		
		st = new StringTokenizer(br.readLine());
		pattern = st.nextToken();
		
		int idx = 0;
		int [] record_len = makeTable();
		
		for(int i=0;i<given.length();i++) {
			// 문자열이 연속해서 일치하지 않는 경우
			while(idx>0 && given.charAt(i) != pattern.charAt(idx)) {
				idx = record_len[idx-1];
			}
			if(given.charAt(i)==pattern.charAt(idx)) {
				// 부분 문자열임을 발
				if(idx==pattern.length()-1) {
					System.out.println(1);
					return;
				}
				else idx++;
			}
		}
		System.out.println(0);
		
	}
	public static int[] makeTable() {
		int n = pattern.length();
		int[] table = new int[n]; // 초기값 = 0
		
		int idx=0;
		for(int i=1; i<n; i++) {
	        // 일치하는 문자가 발생했을 때(idx>0), 
			// 연속적으로 더 일치하지 않으면 idx = table[idx-1]로 돌려준다.
			while(idx>0 && pattern.charAt(i) != pattern.charAt(idx)) {
				idx = table[idx-1];
			}
			
			if(pattern.charAt(i) == pattern.charAt(idx)) {
				idx += 1;
				table[i] = idx;  
			}
		}
		
		return table;
 	}
}
