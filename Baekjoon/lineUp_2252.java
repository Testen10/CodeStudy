package CodeStudy.Baekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Stack; //import

/*
 Input
 N M
 N: num of student
 M: how many times students' height have been compared
 
 Output
 N students lined up in order
 
 node끼리의 direction을 어떻게 만들면 좋을까?
 1. Node class를 따로 만든다
 2. int[][]를 만든다
 
 1번이 나을 듯
 조건이 없는 놈도 있을 수도 있잖아 
 */

public class lineUp_2252 {
	static int N;
	static ArrayList<Integer>[] nodeList;
	static Stack<Integer> ans_stack = new Stack<>();
	static boolean[] visited;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		nodeList = new ArrayList[N+1];
		visited = new boolean[N+1];
		for(int idx=0;idx<N+1;idx++) {
			nodeList[idx] = new ArrayList<Integer>();
		}
		
		for(int idx=0;idx<M;idx++) {
			st = new StringTokenizer(br.readLine());
			int front = Integer.parseInt(st.nextToken());
			int back = Integer.parseInt(st.nextToken());
			
			nodeList[front].add(back);
		}
		
		
		for(int student=1;student<N+1;student++) topologicalSorting(student);
		
		for(int idx=0;idx<N;idx++) {
			System.out.print(ans_stack.pop());
			System.out.print(" ");
		}
	}
	public static void topologicalSorting(int curr_node) {
		// 숫자 순서대로 방문 시작
		// 이어져있는 노드가 없는 경우 or 이어진 노드가 이미 방문한 노드들일 경우 stack에 값 삽입
		// 삽입 이후에는 원래 노드로 돌아가기 
		if(!visited[curr_node]) {
			if(nodeList[curr_node].size()==0) {
				visited[curr_node] = true;
				ans_stack.push(curr_node);
				return;
			}
			
			for(int next_node:nodeList[curr_node]) {
				if(!visited[next_node]) {
					topologicalSorting(next_node);
				}
			}
			ans_stack.push(curr_node);
			visited[curr_node] = true;
		}
		return;
	}
}
