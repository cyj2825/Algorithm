import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[] input;
	static int[][][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		input = new int[s.length-1];
		
		// input 배열에 값들 넣기
		for(int i = 0; i < s.length-1; i++) {
			input[i] = Integer.parseInt(s[i]);
		}
		
		// dp 배열 초기화
		// dp 배열 -> left, right, cnt으로 구성 (cnt는 수행한 횟수)
		// left와 right의 경우는 0,1,2,3,4값만 존재
		dp = new int[5][5][s.length];
		
		int answer = DDR(0, 0, 0);
		System.out.println(answer);
		br.close();
	}
	
	public static int DDR(int left, int right, int cnt) {
		// 마지막 스텝 도달하면 종료
		if(cnt == input.length) return 0;
		// dp에 값이 차있으면 return
		if (dp[left][right][cnt] != 0) return dp[left][right][cnt];

		// 가능한 경우의 수 중 가장 적은 경우로 갱신하고 return
		// 왼발 욺직이는 경우와 오른발 움직이는 경우 비교
		int leftScore = score(left, input[cnt]) + DDR(input[cnt], right ,cnt+1); 
		int rightScore = score(right, input[cnt]) + DDR(left, input[cnt], cnt+1); 
				
		return dp[left][right][cnt] = Math.min(leftScore, rightScore);
	}
	
	public static int score(int from, int to) {
		// 현재 위치를 누르면 1
    	if(from == to) return 1;
    	// 0에서 출발하면 2
        if(from == 0) return 2;
        // 반대 방향을 밟으면 4
        if(Math.abs(from-to) == 2) return 4;
        // 인접 스텝 즉 바로 옆을 밟으면 3
        return 3;
	}
}