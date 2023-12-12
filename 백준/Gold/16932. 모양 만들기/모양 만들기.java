import java.io.*;
import java.util.*;

public class Main {
	static class Pair{
		int x, y;
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	// arr 배열 안에 이미 0과 1이 존재하므로 구분하기 위해 shapeNum을 2부터 시작
	static int N, M, answer = 0, shapeNum = 2;;
	static int[][] arr;
	static ArrayList<Pair> zeroList = new ArrayList<>();
	// 상하좌우 이동
	static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
	static HashMap<Integer, Integer> shapeInfo = new HashMap<>();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == 0) zeroList.add(new Pair(i, j));
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(arr[i][j] == 1) bfs(i, j);
			}
		}
		
		for(int i = 0; i < zeroList.size(); i++) {
			Pair data = zeroList.get(i);
			answer = Math.max(answer, getShapeSize(data.x, data.y));
		}
		System.out.println(answer);
	}
	
	public static void bfs(int x, int y) {
		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(x ,y));
		arr[x][y] = shapeNum;
		int cnt = 1;
		
		while(!q.isEmpty()) {
			Pair data = q.poll();
			for(int i = 0; i < 4; i++) {
				int nx = data.x + dx[i];
				int ny = data.y + dy[i];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= M || arr[nx][ny] != 1) continue;
				cnt++;
				q.offer(new Pair(nx, ny));
				arr[nx][ny] = shapeNum;
			}
		}
		
		shapeInfo.put(shapeNum, cnt);
		shapeNum++;
	}
	
	public static int getShapeSize(int x, int y) {
		HashSet<Integer> visited = new HashSet<>();
		int size = 1;
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx < 0 || nx >= N || ny < 0 || ny >= M || arr[nx][ny] == 0 || visited.contains(arr[nx][ny])) continue;
			visited.add(arr[nx][ny]);
			// 특정 값을 1로 변경하여 연결되는 모양들에 대한 개수 구하기 위함
			size += shapeInfo.get(arr[nx][ny]);
		}
		return size;
	}
}