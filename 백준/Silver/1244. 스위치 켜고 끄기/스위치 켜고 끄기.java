import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] data = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 스위치 상태 데이터 입력 받기
        for(int i = 1; i < n + 1; i++) {
        	data[i] = Integer.parseInt(st.nextToken());
        }
        
        int studentN = Integer.parseInt(br.readLine());
        for(int i = 0; i < studentN; i++) {
        	st = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	
        	// 남자의 경우
        	if(a == 1) {
            	for(int x = b; x < n + 1; x+= b) {
            		if(data[x] == 0) data[x] = 1;
            		else if(data[x] == 1) data[x] = 0;
            	}
        	}
        	// 여자의 경우
        	else if(a == 2) {
            	if(data[b] == 0) data[b] = 1;
        		else if(data[b] == 1) data[b] = 0;
            	
            	// 받은 자연수를 기준으로 대칭 스위치 값 변경
            	int cnt = 1;
            	while((b - cnt) > 0 && (b + cnt) < n + 1) {
            		if(data[b + cnt] == data[b - cnt]) {
            			if(data[b - cnt] == 0) {
            				data[b + cnt] = 1;
            				data[b - cnt] = 1;
            			}
            			else if(data[b - cnt] == 1) {
            				data[b + cnt] = 0;
            				data[b - cnt] = 0;
            			}
            			cnt++;
            		}
            		else {
            			break;
            		}
            	}
        	}
        }
        
        for(int i = 1; i < n + 1; i++) {
        	System.out.print(data[i] + " ");
            // 마지막 스위치까지 한 줄에 20개씩 출력 조건
        	if(i % 20 == 0) {
        		System.out.println();
        	}
        }
        br.close();
    }
}