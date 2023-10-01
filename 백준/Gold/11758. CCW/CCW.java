import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// CCW(Counter Clockwise) 문제
// (x1y2 + x2y3 + x3y1) - (x2y1 + x3y2 + x1y3) => 0보다 크면 반시계 방향, 0이면 일직선, 0보다 작으면 시계 방향
public class Main {
	static class Pair{
		int x, y;
		public Pair(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	static Pair[] coor = new Pair[3];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for(int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			coor[i] = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		int a = coor[0].x * coor[1].y + coor[1].x * coor[2].y + coor[2].x * coor[0].y;
		int b = coor[0].y * coor[1].x + coor[1].y * coor[2].x + coor[2].y * coor[0].x;

		// 반시계 방향
		if (a - b > 0) {
			System.out.println(1);
		} else if (a == b) { // 일직선 방향
			System.out.println(0);
		} else { // 시계 방향
			System.out.println(-1);
		}
		br.close();
	}
}