package CodeStudy.Baekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;


// 샘플들로 돌리면 잘 돌아가나 답을 백준에 넣으면 오답이라고 뜸 


/*
 Input
 N
 N * N board, C (red), P (blue), Z (green), Y (yellow)
 
 Output
 max num of candy one can win
 
 행/열에서 가장 길게 연속되는 부분 찾기 -> 근처를 swap했을 때 값이 늘어나는지 확인하기 
 */
public class BOMBONI_3085 {
	static int[][] candy_board;
	static int N;
	static ArrayList<int[]> maxCandy_info = new ArrayList<int[]>();
	static int ans=0;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
	
		candy_board = new int[N][N];
		
		for(int row=0;row<N;row++) {
			st = new StringTokenizer(br.readLine(),"");
			String line = st.nextToken();
			for(int col=0;col<N;col++) {
				candy_board[row][col] = charToInt(line.charAt(col));
			}
		}
		
		for(int row=0;row<N;row++) {
			ans = Math.max(ans, candyCnt(0,row));
		}
		for(int col=0;col<N;col++) {
			ans = Math.max(ans, candyCnt(1, col));
		}
		
		
		for(int row = 0; row < N; row++) {
			for(int col = 0; col < N; col++) {
				if( col + 1 < N) { 
					swapNum(new int[] {row,col}, new int[] {row,col+1});// 아래쪽이랑 swap
					ans = Math.max(ans, candyCnt(0,row));
					ans = Math.max(ans, candyCnt(1,col));
					ans = Math.max(ans, candyCnt(1, col+1));
					swapNum(new int[] {row,col}, new int[] {row,col+1}); // 복귀
				}
				if(row + 1 < N) {
					swapNum(new int[] {row,col}, new int[] {row+1,col});
					ans = Math.max(ans, candyCnt(0,row));
					ans = Math.max(ans, candyCnt(0, row+1));
					ans = Math.max(ans, candyCnt(1,col));
					swapNum(new int[] {row,col}, new int[] {row+1,col});
				}
			}
		}
		
		System.out.println(ans);
	}
	
	
	static void swapNum(int[] loc1, int[] loc2) {
		int temp = candy_board[loc1[0]][loc1[1]];
		candy_board[loc1[0]][loc1[1]] = candy_board[loc2[0]][loc2[1]];
		candy_board[loc2[0]][loc2[1]] = temp;
		return;
			
	}
	
	public static int candyCnt(int rowOrCol, int ord) {
		int max_cnt = 0;
		int temp_cnt = 1;
		
		if(rowOrCol==0) { // row count
			int curr_type = candy_board[ord][0];
			
			for(int col=1;col<N;col++) {
				if(curr_type == candy_board[ord][col]) {
					temp_cnt++;
				}
				else {
					max_cnt = Math.max(max_cnt, temp_cnt);
					curr_type = candy_board[ord][col];
					temp_cnt = 1;
				}
			}
		}
		
		else if(rowOrCol==1) { // col count
			int curr_type = candy_board[0][ord];
			
			for(int row=1;row<N;row++) {
				if(curr_type == candy_board[row][ord]) {
					temp_cnt++;
				}
				else {
					max_cnt = Math.max(max_cnt, temp_cnt);
					curr_type = candy_board[row][ord];
					temp_cnt = 1;
				}
			}
		}
		
		
		
		return max_cnt = Math.max(max_cnt, temp_cnt);
	}
	
	public static int charToInt(Character type) {
		switch(type) {
		case 'C': return 0;
		case 'P': return 1;
		case 'Z': return 2;
		case 'Y': return 3;
		default: return -1;
		}
	}
	
	
	

}


/*
 처음 풀이
 틀렸음 // 연속해서 있어야 먹을 수 있는데 이러면 연속하지 않는 경우도 카운팅하게 됨
 
 
 우선 가로세로 N개의 사탕이 있는 경우에는 그냥 N 출력하게 하고
 그게 아니면 가로 세로로 살펴보면서 맥스 개수/종류 파악 + 주변에 교환 ㄱㄴ한 놈이 있는지 살펴보고 교환 ㄱㄴ하면 1 증가
 ArrayList int[] -> [candy type, candy num, row or col, nth row/col]
 for(int row=0;row<N;row++)
 	int cnt=0;
 	int [] candy_cnt = new [4] // 사탕 종류마다 몇 개 있는지 기록
 	for (int col=0;col<N;col++)
 		candy_cnt[col] ++ ;
 	find max candy_cnt & type
 	if max candy cnt is bigger than what is stored in arraylist, reset arraylist & insert
 	if smae, no reset just insert
 	
 for elem in arraylist
 	for candy that aren't same type with the max candy, find tradable place
 	if tradable found, break immediatly and print max candy cnt +1
 	if not found, print max candy cnt
 
 	
*/