import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	// T : 요리 시간,  A, B, C : 각각의 버튼 조작 횟수
	static int T, A, B, C;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		// A버튼은 300초, B버튼은 60초, C버튼은 10초
		int ABtn = 300;
		int BBtn = 60;
		int CBtn = 10;
		
		// T초를 위한 최소 버튼을 눌러야 하므로 큰 값 버튼을 최대한 많이 눌러야 함
		// 우선 A버튼을 누를 수 있는대로 다 눌러야 하기 때문에 T/ABtn한 몫 값만큼 누른다
		if(T/ABtn > 0) {
			A = T/ABtn;
			T -= (T/ABtn)*300;
		}
		// 위의 결과대로 A버튼을 누른만큼 T값에서 빼는 업데이트를 하고 T/BBtn한 몫 값만큼 또 누른다
		if(T/BBtn > 0) {
			B = T/BBtn;
			T -= (T/BBtn)*60;
		}
		// 위의 결과대로 B버튼을 누른만큼 T값에서 빼는 업데이트를 하고 T/CBtn한 몫 값만큼 또 누른다
		if(T/CBtn > 0) {
			C = T/CBtn;
			T -= (T/CBtn)*10;
		}
		// 위의 계산을 모두 한 뒤 T가 0이 아닐 경우 T초를 맞출 수 없으므로 -1 출력
		if(T != 0) {
			System.out.println(-1);
		}else {
			System.out.print(A + " " + B + " " + C);
		}
		
	}

}