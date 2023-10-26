import java.io.*;
import java.util.*;

public class Main {
	static class Seat implements Comparable<Seat>{
		// x, y 좌표, 주변 좋아하는 학생 수, 주변 빈칸 수
		int x, y, likeSum, emptySum;
		
		public Seat(int x, int y, int likeSum, int emptySum) {
			this.x = x;
			this.y = y;
			this.likeSum = likeSum;
			this.emptySum = emptySum;
		}
		
		// 다른 좌석과 비교
		@Override
		public int compareTo(Seat other) {
			// 인접한 좋아하는 학생 수로 비교
			if(likeSum != other.likeSum) {
				return other.likeSum-likeSum;
			}
			
			// 인접한 빈칸 수로 비교
			if(emptySum != other.emptySum) {
				return other.emptySum-emptySum;
			}
			
			// 행 비교
			if(x != other.x) return x - other.x;
			
			// 열 비교 (마지막 비교 사항)
			return y - other.y;
		}
	}
	// answer: 만족도 총 합
	static int N, answer = 0;
	static int[][] seat;
	// 상하좌우로 이동
	static int[] students, dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
	// 학생별 좋아하는 학생들 저장
	static Map<Integer, Set<Integer>> like;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		seat = new int[N][N];
		// N^2 명의 학생이 존재
		students = new int[N*N];
		like = new HashMap<>();
		
		for(int i = 0; i < N*N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			students[i] = x;
			like.put(x, new HashSet<>());
			
			for(int j = 0; j < 4; j++) {
				like.get(x).add(Integer.parseInt(st.nextToken()));
			}
		}
		
		// 학생들 자리 정하기
		for(int i = 0; i < students.length; i++) {
			Seat s = findSeat(students[i]);
			seat[s.x][s.y] = students[i];
		}
		
		// 점수 구하기
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				int cnt = getLikeSum(i, j, seat[i][j]);
				if(cnt > 0) answer += (int) Math.pow(10, cnt-1);
			}
		}
		
		System.out.println(answer);
	}
	
	// 학생 자리 정하기 함수
	public static Seat findSeat(int student) {
		Seat s = null;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(seat[i][j] != 0) continue;
				
				// 현재 자리의 정보
				Seat cur = new Seat(i, j, getLikeSum(i, j, student), getEmptySum(i, j));
				
				// 비교할 자리가 null이면 초기화
				if(s == null) {
					s = cur;
					continue;
				}
				
				// 이전 좌석과 현재 좌석 비교
				if(s.compareTo(cur) > 0) s = cur;
			}
		}
		return s;
	}
	
	// 인접한 좋아하는 학생 수 구하는 함수
	public static int getLikeSum(int x, int y, int student) {
		int cnt = 0;
		
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx < 0 || N <= nx || ny < 0 || N <= ny) continue;
			if(like.get(student).contains(seat[nx][ny])) cnt++;
		}
		return cnt;
	}
	
	// 인접한 빈칸 수 구하는 함수
	public static int getEmptySum(int x, int y) {
		int cnt = 0;
		
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx < 0 || N <= nx || ny < 0 || N <= ny) continue;
			if(seat[nx][ny] == 0) cnt++;
		}
		return cnt;
	}
}