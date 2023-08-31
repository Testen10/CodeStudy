package CodeStudy.Baekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Stream;
/*
 Input
 V E
 K
 E lines of u v w
 
 V: num of points
 E: num of lines
 K: start point
 w: cost of going from point u to point v
 
 Output
 v lines of min cost of going from K to ith point
 
 다익스트라 알고리즘, 근데 long [][] 쓰면 메모리 초과 걸림
 --> 우선순위 큐를 사용해야 풀림 
 
 */

public class shortestRoute_1753 {
	static class Edge implements Comparable<Edge>{
		int endPoint, cost;
		public Edge(int endPoint, int cost) {
			this.endPoint = endPoint;
			this.cost = cost;
		}
		// 우선순위 큐에서 사용시 최솟값 정렬
		@Override
		public int compareTo(Edge o) {
			return this.cost - o.cost;
		}	
	}
	
	static int num_dot;
	static int num_line;
	static int start_dot;
	static ArrayList<Edge>[] route_list;
	static int[] dijkstra;
	static boolean [] visited;
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		num_dot = Integer.parseInt(st.nextToken());
		num_line = Integer.parseInt(st.nextToken());
		
		route_list = new ArrayList[num_dot];
		
		start_dot = Integer.parseInt(br.readLine())-1;
		
		for(int i=0;i<route_list.length;i++) 
			route_list[i] = new ArrayList<Edge>();
		
		for(int idx=0;idx<num_line;idx++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken())-1;
			int end = Integer.parseInt(st.nextToken())-1;
			int val = Integer.parseInt(st.nextToken());
			
			route_list[start].add(new Edge(end,val));
		}
		
		dijkstra = new int[num_dot];
		Arrays.fill(dijkstra, Integer.MAX_VALUE); // 최솟값 비교 가능하게 MAX_VALUE로 채움 
		dijkstra[start_dot] = 0; // 시작하는 곳에서 시작하는 곳으로 이동하는 cost = 0
		
		// 다익스트라로 start에서 연결된 모른 경로값을 탐색
		dijkstra(start_dot);		
		
		for(int idx=0;idx<num_dot;idx++) {
			if(dijkstra[idx]!=Integer.MAX_VALUE) System.out.println(dijkstra[idx]);
			else System.out.println("INF");
		}
	}
	
	public static void dijkstra(int start) {
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
		// 우선순위 큐는 최솟값 기준으로 edge가 들어감 -> 굳이 최소 비용으로 정렬하는 코드를 추가적으로 짜지 않아도 됨
		pq.add(new Edge(start,0)); // 탐색 시작점
		
		while(!pq.isEmpty()) {
			Edge now = pq.poll(); // 현재 위치 
			
			for(Edge next:route_list[now.endPoint]) { // 현재 위치에서 갈 수 있는 위치 for loop
				if(dijkstra[next.endPoint] > now.cost + next.cost) { // 간선으로 가는 게 더 쌀 경우 
					dijkstra[next.endPoint] = now.cost + next.cost;
					pq.add(new Edge(next.endPoint, dijkstra[next.endPoint]));
				}
			}
			
			
		}
	}
}