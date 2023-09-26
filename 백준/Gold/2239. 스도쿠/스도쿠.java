import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	static int[][] sudoku = new int[9][9];
	// 0인 칸의 x, y값을 넣는 리스트를 따로 만들어주기
	static List<int[]> zerolist = new ArrayList<>();
	static int flag = 0;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i = 0; i < 9; i++) {
			String st = br.readLine();
			for(int j = 0; j < 9; j++) {
				sudoku[i][j] = st.charAt(j)-'0';
				// 값을 찾아야하는 위치의 x, y 값을 zero 리스트에 넣어준다
				if(sudoku[i][j] == 0) zerolist.add(new int[] {i, j});
			}
		}
		dfs(0);
	}
	
	public static void dfs(int cnt) {
		// zero 리스트와 cnt 값이 같아지면 존재하는 0의 값들을 모두 채운 것이므로 출력 후 종료
		// (0, 0) 부터 시작해서 0의 값인 x, y를 차례로 zero 리스트에 넣은 것이므로 맨 처음 값이 81자리의 수가 제일 작은 경우
		if(flag == 1)return;
		
		if(zerolist.size() == cnt) {
			for(int i = 0; i < 9; i++) {
				for(int j = 0; j < 9; j++) {
					System.out.print(sudoku[i][j]);
				}
				System.out.println();
			}
			flag = 1;
			return;
		}
		
		int x = zerolist.get(cnt)[0];
		int y = zerolist.get(cnt)[1];
		
		// 가로, 세로, 사각형에 존재하는 1~9 숫자 존재 여부를 위한 리스트
		boolean[] check = new boolean[10];
		checkNum(x, y, check);
				
		for(int i = 1; i <= 9; i++) {
			if(!check[i]) {
				sudoku[x][y] = i;
				dfs(cnt+1);
				// 다른 값으로도 넣어야 하므로
				sudoku[x][y] = 0;
			}
		}	
	}
	
	// 0의 위치를 기준으로 가로, 세로, 사각형을 탐색하여 1~9 숫자 존재 여부를 check하는 함수
	private static void checkNum(int x, int y, boolean[] check) {
		// 가로 탐색
		for(int i = 0; i < 9; i++) {
			if(sudoku[x][i] != 0) check[sudoku[x][i]] = true;
		}
		
		// 세로 탐색
		for(int i = 0; i < 9; i++) {
			if(sudoku[i][y] != 0) check[sudoku[i][y]] = true;
		}
		
		// 사각형 탐색
		int px = (x / 3) * 3;
		int py = (y / 3) * 3;
		for(int i = px; i < px + 3; i++) {
			for(int j = py; j < py + 3; j++) {
				if(sudoku[i][j] != 0) check[sudoku[i][j]] = true;
			}
		}
	}
}