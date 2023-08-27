import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Solution
{
    static int N, minCount, maxCore, count;
	static int[][] data;
	// 상하좌우 이동
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static List<int[]> coreList;
    
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			data = new int[N][N];
			// 존재하는 core의 좌표 저장
			coreList = new ArrayList<int[]>();
			minCount = Integer.MAX_VALUE;
			maxCore = Integer.MIN_VALUE;
			
			// 배열에 정보 입력값 넣기
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					data[i][j] = Integer.parseInt(st.nextToken());
					if(data[i][j] == 1) {
						if(i != 0 && i != N-1 && j != 0 && j != N-1) {
							coreList.add(new int[] {i, j});
						}
					}
				}
			}
			dfs(0, 0, 0);
			System.out.printf("#%d %d\n", t, minCount);
		}
	}
	
	public static void dfs(int index, int coreCount, int wireCount) {
		// 종료 조건
		if(index == coreList.size()) {
			if(maxCore < coreCount) {
				maxCore = coreCount;
				minCount = wireCount;
			}else if(maxCore == coreCount) {
				minCount = Math.min(minCount, wireCount);
			}
			return;
		}
		
		
		for(int i = 0; i < 4; i++) {
			// 가장자리까지 도달할 수 있다면
			if (connect(coreList.get(index), i)) {
                fill(coreList.get(index), i, 1);
                dfs(index + 1, coreCount + 1, wireCount + count); // 코어 선택했을 경우
                fill(coreList.get(index), i, 0);
            }
        }
		// 해당 코어 선택하지 않았을 경우
        dfs(index + 1, coreCount, wireCount);
    }

    private static void fill(int[] val, int d, int fill_v) {
        count = 0;

        int x = val[0] + dx[d];
        int y = val[1] + dy[d];
        while (0 <= x && x < N && 0 <= y && y < N) {
            data[x][y] = fill_v;
            count++;
            x += dx[d];
            y += dy[d];
        }
    }

    private static boolean connect(int[] val, int d) {
        int x = val[0] + dx[d];
        int y = val[1] + dy[d];

        while (0 <= x && x < N && 0 <= y && y < N) {
            if (data[x][y] == 1) return false;
            x += dx[d];
            y += dy[d];
        }
        return true;
	}
}