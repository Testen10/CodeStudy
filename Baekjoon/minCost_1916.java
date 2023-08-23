package CodeStudy.Baekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 Input
 N
 M
 M lines of bus info: num of city where bus starts / num of city where bus arrives / cost
 start city num / end city num
 N: num of city
 M; num of bus
 
 Output
 min cost of going from starting city to ending city
 
 시작 지점에서 갈 수 있는 버스 넘버들 기록 ->  dfs 사용해서 least cost 구하기
 avaBus_list = [버스 넘버]
 for loop avaBus_list
 if curr_city = end+city
 cost = mincost
 total cost += busInfo_list[idx][2]
 get_minCost(busInfo_list[idx][1])
 
 다익스트라 알고리즘 
 */

public class minCost_1916 {
	static int N;
	static int M;
	static int start_city;
	static int end_city;
	static long[][] bus_map;
	static boolean[] visited;
	static long[] dijkstra;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		
		bus_map = new long[N][N];
		
		for(int row=0;row<N;row++) {
			for(int col=0;col<N;col++) {
				// 출발지와 목적지가 같은 경우 이동에 드는 비용 = 0
				if(row==col) {
					bus_map[row][col]=0;
				}
				// 한 곳에서 다른 곳으로 가는 최소비용을 저장해야 하니까 초기 값은 max_value로 설정 
				else bus_map[row][col]=Integer.MAX_VALUE;
			}
		}
		
		for(int idx=0;idx<M;idx++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			// 같은 출발&목적지를 가진 버스는 비용이 더 작은 쪽을 저장 
			bus_map[start-1][end-1]= Math.min(bus_map[start-1][end-1],Integer.parseInt(st.nextToken()));
		}
		
		st = new StringTokenizer(br.readLine());
		start_city = Integer.parseInt(st.nextToken())-1;
		end_city = Integer.parseInt(st.nextToken())-1;
		
		dijkstra = bus_map[start_city].clone();
		visited = new boolean[N];
		visited[start_city] = true;
		
		for(int idx=1;idx<N;idx++) {
			int temp = choose(); // 이전에 가지 않았던 곳들 중 갈 수 있던 곳 중 가장 cost가 적은 경로를 고름
			visited[temp] = true;

            for(int j =0; j < N; j++)
                if(!visited[j]) dijkstra[j] = Math.min(dijkstra[j], dijkstra[temp] + bus_map[temp][j]);
                	// 바로 가는 것 & 간선 중 빠른 경로 선택
                	// 간선 버스가 없어도 어차피 저장된 건 MAX_VALUE여서 알아서 걸러짐 
		}
		
		System.out.println(dijkstra[end_city]);
	}
	
	public static int choose() {
		int minIdx = 0;
		long min = Integer.MAX_VALUE;
		
		for(int i=0;i<N;i++) {
			if(!visited[i]) {
				if(min>dijkstra[i]) {
					min = dijkstra[i];
					minIdx=i;
				}
			}
		}
		
		return minIdx;
	}
}
/* Time limit 뜬 코드 
public class minCost_1916 {
	static int N;
	static int M;
	static int start_city;
	static int end_city;
	static int[][] busInfo_list;
	static boolean[] not_visited;
	static boolean[] visited;
	
	static int cost_sum=0;
	static int ans = Integer.MAX_VALUE;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		
		busInfo_list = new int[M][3];
		not_visited = new boolean[N];
		visited = new boolean[N];
		
		for(int idx=0;idx<M;idx++) {
			st = new StringTokenizer(br.readLine());
			busInfo_list[idx][0]=Integer.parseInt(st.nextToken());
			busInfo_list[idx][1]=Integer.parseInt(st.nextToken());
			busInfo_list[idx][2]=Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		start_city = Integer.parseInt(st.nextToken());
		end_city = Integer.parseInt(st.nextToken());
		
		get_minCost(0,start_city);
		
		System.out.println(ans);
	}
	
	public static void get_minCost(int curr_cost, int curr_city) {
		if(curr_city==end_city) {
			ans = curr_cost;
			return;
		}
		
		int min_cost=Integer.MAX_VALUE;
		int min_cost_city = -1;
		visited[curr_city]=true;
		for(int idx=0;idx<M;idx++) {
			if(busInfo_list[idx][0]==curr_city) {
				if(min_cost>busInfo_list[idx][2]) {
					min_cost = busInfo_list[idx][2];
					min_cost_city =  busInfo_list[idx][1];
				}
			}
		}
		
		get_minCost(curr_cost+min_cost,min_cost_city);
	}

}

*/
