package CodeStudy.Baekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;


/*
 Input
 N
 M
 M lines of cost needed to connect two computer
 
 N: num of computer
 
 Output
 min cost of connecting all computer
 */

public class networkConnection_1922 {
	static class Node implements Comparable<Node>{
		int start;
		int end;
		int cost;
		
		public Node(int start, int end, int cost) {
			super();
			this.start = start;
			this.end = end;
			this.cost = cost;
		}
		
		// Collection의 sort기능을 쓰기 위해 override, compare하는 기준이 cost가 됨 
				@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
		
	}
	static int num_comp;
	static int num_line;
	static int[] parentNode_list; // 노드들의 parent 노드를 기록하는 list
	static ArrayList<Node> nodeList = new ArrayList<Node>();
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		num_comp = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		num_line = Integer.parseInt(st.nextToken());
		
		parentNode_list = new int[num_comp+1];
		
		for(int idx=0;idx<num_line;idx++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			nodeList.add(new Node(start,end,cost));
		}
		
		Collections.sort(nodeList);
		initSet_parentNode(); // 처음에는 parent노드를 자기 자신으로 설정함
		
		int sum_cost = 0;
		int cnt = 0;
		
		for(Node curr_node:nodeList) {
			if(union(curr_node.start,curr_node.end)) {
				cnt ++;
				sum_cost += curr_node.cost;
			}
		}
		
		System.out.println(sum_cost);

	}
	
	static void initSet_parentNode() {
		for(int idx=1;idx<num_comp+1;idx++) {
			parentNode_list[idx] = idx; // 초기에는 자신의 부모 노드를 자기 자신으로 설
		}
		return;
	}
	
	private static boolean union(int start, int end){
		int startRoot = findSet(start); // 시작 노드의 부모 노드를 검색 
		int endRoot = findSet(end); // 도착 노드의 부모 노드를 검색 
		
		if(startRoot==endRoot) return false; // 시작과 도착의 부모 노드가 같은 경우 순환됨 
		else parentNode_list[endRoot] = startRoot; // 
		return true;
	}
	
	private static int findSet(int v) {
		if(parentNode_list[v]==v) return v; // 그룹의 시작 노드를 찾기 
		else return parentNode_list[v] = findSet(parentNode_list[v]);
	}
}
