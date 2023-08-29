import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static ArrayList<Integer>[] list;
	static int[] time, inDegree, result;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		list = new ArrayList[N+1];
		time = new int[N+1];
		inDegree = new int[N+1];
		result = new int[N+1];
		
		for(int i = 0; i <= N; i++) {
			// 인접 정보를 담을 list 생성
			list[i] = new ArrayList<>();
		}
		
		for(int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			time[i] = Integer.parseInt(st.nextToken());
			while(true) {
				int x = Integer.parseInt(st.nextToken());
				if(x == -1) {
					break;
				}
				else {
					// 나를 가리키고 있는 값에 나를 넣어줘
					list[x].add(i);
					++inDegree[i];
				}
			}
		}
		
		Queue<Integer> q = new ArrayDeque<Integer>();
		for(int i = 1; i <= N; i++) {
			if(inDegree[i] == 0) {
				q.add(i);
				result[i] = time[i];
			}
				
		}
        
		int cur = 0;
		for(int i = 0; i < N; i++) {
			cur = q.poll();
			for(int next : list[cur]) {
				result[next] = Math.max(result[next], result[cur] + time[next]);
				if (--inDegree[next] == 0)
					q.add(next);
			}
		}
		
		for(int i = 1; i <= N; i++) {
			System.out.println(result[i]);
		}
	}
}