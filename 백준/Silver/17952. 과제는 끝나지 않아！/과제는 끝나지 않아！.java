import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int N, work, A, T, totalScore;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 이번 분기가 몇 분인지 나타내는 정수 N
		N = Integer.parseInt(br.readLine());
		// 후입선출 스택을 사용하여 N분동안 주어진 업무에 대한 정보 넣기
		Stack<int[]> stack = new Stack<>();
		totalScore = 0;
		
		// 이번 분기가 시작하고 N분째에 주어진 업무의 정보 입력받기
		for(int i = 0; i < N; i++) {
			String s = br.readLine();
			// 입력이 '1 A T'로 주어졌다면 s.length()값은 1보다 크다
			
			if(s.length() > 1) {
				StringTokenizer st = new StringTokenizer(s);
				work = Integer.parseInt(st.nextToken());
				A = Integer.parseInt(st.nextToken());
				T = Integer.parseInt(st.nextToken());
				// 만약 T가 1이라면 현재 일을 바로 시작해 다음 분으로 넘어가기 전에 완료하므로 평가 점수는 추가하고 스택에 넣지 않는다
				if(T == 1) {
					totalScore += A;
				}
				// 만약 T가 1보다 크다면 현재 일한 1을 T에서 빼준 값을 스택에 넣는다
				else if(T > 1) {
					stack.add(new int[] {A, T-1});
				}
			}
			// 입력이 '0'으로 주어졌다면 s.length()값은 1이다
			else if(s.length() == 1) {
				if(!stack.isEmpty()) {
					int[] info = stack.peek();
					// 만약 남은 시간이 1이라면 이번에 완료할 수 있으므로 평가 점수를 추가하고 스택에서 제거한다
					if(info[1] == 1) {
						totalScore += info[0];
						stack.remove(stack.size()-1);
					}
					// 만약 남은 시간이 1보다 크다면 현재 일한 1을 제외한 T-1값으로 업데이트해준다
					else {
						stack.set(stack.size()-1, new int[] {info[0], info[1]-1});
					}
				}
			}
		}
		System.out.println(totalScore);
	}

}