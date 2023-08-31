package CodeStudy.Baekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;

/*
 Input
 V E
 E lines of A B C
 
 V: num of point
 E: num of line
 point A & B connected with line with weight of C
 
 Output
 min weight of spanning tree
 
 크루스칼 알고리즘
 */
public class minSpanningTree_1197 {
	static class Node implements Comparable<Node> {
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
	
	static int V, E;
	static int[] parents;
	static ArrayList<Node> nodeList;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		parents = new int[V];
		nodeList = new ArrayList<Node>();
		
		for(int idx=0;idx<E;idx++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken())-1;
			int end = Integer.parseInt(st.nextToken())-1;
			int cost = Integer.parseInt(st.nextToken());
			
			nodeList.add(new Node(start, end, cost));
		}
		
		Collections.sort(nodeList); // 비용 낮은 순으로 정렬
		make(); // 초기 부모 노드를 자기 자신으로 설정 

		int sum = 0;
		int cnt = 0;
		
		for(Node n : nodeList) {
			if(union(n.start, n.end)){
				sum += n.cost;
				cnt++;
				
				if(cnt==E-1) break;
			}
		}
		
		System.out.println(sum);
	}
	
	private static boolean union(int start, int end){
		int startRoot = findSet(start);
		int endRoot = findSet(end);
		
		if(startRoot==endRoot) return false; // 이 경우 순환됨 
		else parents[endRoot] = startRoot; // 순환 X
		return true;
	}
	
	private static int findSet(int v) {
		if(parents[v]==v) return v;
		else return parents[v] = findSet(parents[v]);
	}
	
	private static void make() {
		for(int i = 0 ; i < V ; i++) {
			parents[i] = i;
		}
	}
}
