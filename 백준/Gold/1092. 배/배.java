import java.io.*;
import java.util.*;

public class Main {
	static int N, M, answer = 0;
	static int[] ship;
	static ArrayList<Integer> box = new ArrayList<>();
	static boolean finalValue = false;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		ship = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			ship[i] = Integer.parseInt(st.nextToken());
		}
		
		M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) {
			box.add(Integer.parseInt(st.nextToken()));
		}
		
		// 오름차순 정렬
		Arrays.sort(ship);
		// 내림차순 정렬
		Collections.sort(box, Collections.reverseOrder());
		
		while(!box.isEmpty()) {
			int num = 0;
			for(int i = N-1; 0 <= i; i--) {
				boolean check = false;
				for(int j = 0; j < box.size(); j++) {
					int x = box.get(j);
					if(ship[i] >= x) {
						check = true;
						box.remove(j);
						break;
					}
				}
				if(check) num++;
			}
			if(num > 0) answer++;
			if (num == 0 && box.size() > 0) {
				System.out.println(-1);
				finalValue = true;
				break;
			}
		}
		if(!finalValue) System.out.println(answer);
	}
}