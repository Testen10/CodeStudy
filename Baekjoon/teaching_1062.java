package CodeStudy.Baekjoon;
import java.util.Scanner;
/*
 모든 단어에 anta & tica가 들어감
 -> 단어를 읽으려면 적어도 a / n / t / i / c 5개를 알아야 함
 -> K가 5보다 작을 경우 0 출력
 
 K가 5보다 클 경우 읽을 수 있는 수의 개수: K-5개 여기서 최적의 조합을 알아내야 함
 모든 단어에서 저 5개 단어 삭제하고 남은 단어 리스트하기, 사용되는 단어들 종류 알아내서 dictionary에 삽입?
 
 백트래킹 활용해서 
 */


public class teaching_1062 {
	static boolean[][] alphabet_check;
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		sc.nextLine();
		alphabet_check = new boolean[N][26];
		
		for(int idx=0;idx<N;idx++) { 
			String word = sc.nextLine();
			alphabet_cnt(word,idx);
		}
		
		int[] alphabet_cnt = new int[26];
		
		
	}
	
	public static void alphabet_cnt(String word, int idx) {
		for(int cnt=0;cnt<word.length();cnt++) {
			alphabet_check[idx][(int)word.charAt(cnt)-97]=true;
		}
	}

}
