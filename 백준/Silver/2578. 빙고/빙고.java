import java.io.*;
import java.util.*;

public class Main {
	static class Pair{
		int val;
		boolean check;
		
		public Pair(int val, boolean check) {
			super();
			this.val = val;
			this.check = check;
		}
	}
	static Pair[][] bingo;
	static int[][] findNum;
	static int answer;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		bingo = new Pair[5][5];
		findNum = new int[25][2];
		for(int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 5; j++) {
				int x = Integer.parseInt(st.nextToken());
				bingo[i][j] = new Pair(x, false);
				findNum[x-1][0] = i;
				findNum[x-1][1] = j;
			}
		}
		
		int cnt = 0;
		for(int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 5; j++) {
				int x = Integer.parseInt(st.nextToken());
				bingo[findNum[x-1][0]][findNum[x-1][1]].check = true;
				cnt++;
				if(cnt >= 5) {
					if(find()) {
						System.out.println(cnt);
						return;
					}
				}
			}
		}
	}
	
	public static boolean find() {
		int answer = 0;
		// 가로 방향 check
		for(int i = 0; i < 5; i++) {
			boolean c = false;
			for(int j = 0; j < 5; j++) {
				if(!bingo[i][j].check) {
					c = true;
					break;
				}
			}
			if(!c) answer++;
		}
		
		// 세로 방향 check
		for(int i = 0; i < 5; i++) {
			boolean c = false;
			for(int j = 0; j < 5; j++) {
				if(!bingo[j][i].check) {
					c = true;
					break;
				}
			}
			if(!c) answer++;
		}
		
		// 대각선 방향 check
		boolean c1 = false;
		boolean c2 = false;
		for(int i = 0; i < 5; i++) {
			if(!bingo[i][i].check) c1 = true;
			if(!bingo[4-i][i].check) c2 = true;
		}
		if(!c1) answer++;
		if(!c2) answer++;
		if(3 <= answer) return true;
		return false;
	}
}