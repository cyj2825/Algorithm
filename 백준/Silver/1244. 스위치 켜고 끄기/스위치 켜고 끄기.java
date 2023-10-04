import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] state; // 스위치 상태
	static int student; // 학생 수
	
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  
        int n = Integer.parseInt(br.readLine());
        
        // 스위치 상태 입력
        state = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i < state.length; i++) {
        	state[i] = Integer.parseInt(st.nextToken());
        }
        
        // 학생수 입력
        student = Integer.parseInt(br.readLine());
        
        // 학생 스위치 처리
        for(int i = 0; i < student; i++) {
        	st = new StringTokenizer(br.readLine());
        	
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	
        	// 남자
        	if(a == 1) {
        		int cur = b;
            	// 배수 번호 스위치 상태 반대로 변경
            	while(cur < state.length) {
            		if(state[cur] == 0) {
            			state[cur] = 1;
            		}
            		else if(state[cur] == 1) {
            			state[cur] = 0;
            		}
            		cur += b;
            	}
        	}
        	// 여자
        	else if(a == 2) {
        		// 현재 위치 스위치 상태 반대로 변경
            	if(state[b] == 0) {
        			state[b] = 1;
        		}
        		else if(state[b] == 1) {
        			state[b] = 0;
        		}
            	
            	// 대칭 스위치 반대로 변경
            	int count = 1;
            	while((b - count) > 0 && (b + count) < state.length) {
            		if(state[b + count] == state[b - count]) {
            			
            			if(state[b + count] == 0) {
            				state[b + count] = 1;
            				state[b - count] = 1;
            			}
            			else if(state[b + count] == 1) {
            				state[b + count] = 0;
            				state[b - count] = 0;
            			}
            			count++;
            			
            		}
            		else {
            			break;
            		}
            	}
        	}
        }
        
        for(int i = 1; i < state.length; i++) {
        	System.out.print(state[i] + " ");
        	if(i % 20 == 0) {
        		System.out.println();
        	}
        }
        br.close();
    }
}
