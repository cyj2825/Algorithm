import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// CCW 문제
public class Main {
	static class Pair {
		long x, y;

		public Pair(long x, long y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Pair[] pairs = new Pair[4];
		long x1 = Long.parseLong(st.nextToken());
		long y1 = Long.parseLong(st.nextToken());
		long x2 = Long.parseLong(st.nextToken());
		long y2 = Long.parseLong(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		long x3 = Long.parseLong(st.nextToken());
		long y3 = Long.parseLong(st.nextToken());
		long x4 = Long.parseLong(st.nextToken());
		long y4 = Long.parseLong(st.nextToken());
		
		pairs[0] = new Pair(x1, y1);
		pairs[1] = new Pair(x2, y2);
		pairs[2] = new Pair(x3, y3);
		pairs[3] = new Pair(x4, y4);
		
		System.out.println(check(pairs));
		br.close();
	}
	
	public static int check(Pair[] p) {
		boolean possible = false;
		int answer = 0;
		
		int p123 = CCW(p[0], p[1], p[2]);
		int p124 = CCW(p[0], p[1], p[3]);
		int p341 = CCW(p[2], p[3], p[0]);
		int p342 = CCW(p[2], p[3], p[1]);

		boolean compare1 = Math.min(p[0].x, p[1].x) <= Math.max(p[2].x, p[3].x);
		boolean compare2 = Math.min(p[2].x, p[3].x) <= Math.max(p[0].x, p[1].x);
		boolean compare3 = Math.min(p[0].y, p[1].y) <= Math.max(p[2].y, p[3].y);
		boolean compare4 = Math.min(p[2].y, p[3].y) <= Math.max(p[0].y, p[1].y);
		
		// p3 < p2 && p1 < p4를 만족해야 함!
		if (p123 * p124 == 0 && p341 * p342 == 0) {
			possible = true;
			if (compare1 && compare2 && compare3 && compare4) answer = 1;
		}
		// CCW(p1, p2, p3) * CCW(p1, p2, p4) <= 0 && CCW(p3, p4, p1) * CCW(p3, p4, p2) <= 0
		if (p123 * p124 <= 0 && p341 * p342 <= 0) {
			if (!possible) answer = 1;
		}
		return answer;
	}
	
	public static int CCW(Pair p1, Pair p2, Pair p3) {
		long result = ((p1.x * p2.y) + (p2.x * p3.y) + (p3.x * p1.y)) - ((p1.y * p2.x) + (p2.y * p3.x) + (p3.y * p1.x));
		
		if (result > 0) // 반시계 방향
			return 1;
		else if (result == 0) // 일직선 방향
			return 0;
		else // 시계 방향
			return -1;
	}
}