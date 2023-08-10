import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M, K;
    static int[][] operation;
    static int[][] data;
    static int minVal = 987654321;
    static int[] arr;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        data = new int[N][M];
        operation = new int[K][3];
        arr = new int[K];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                data[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int k = 0; k<K; k++) {
            st = new StringTokenizer(br.readLine());
            operation[k][0] = Integer.parseInt(st.nextToken()) - 1;
            operation[k][1] = Integer.parseInt(st.nextToken()) - 1;
            operation[k][2] = Integer.parseInt(st.nextToken());
        }

        permutation(0, 0);

        System.out.println(minVal);
    }

    public static void permutation(int cnt, int flag) {
        if(cnt == K) {
            rotation(arr);
            return;
        }
        for(int i = 0; i < K; i++) {
            if((flag & 1 << i) != 0) continue;
            arr[cnt] = i;
            permutation(cnt+1, flag | 1 << i);
        }
    }

    public static void rotation(int[] a) {
    	int[][] tempData = new int[N][M];

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                tempData[i][j] = data[i][j];
            }
        }

        for(int i=0; i<K; i++) {
            int r = operation[a[i]][0];
            int c = operation[a[i]][1];
            int s = operation[a[i]][2];

            for(int j=1; j<=s; j++) {
            	// 맨 위 가로
                int upTmp = tempData[r-j][c+j];
                for(int y = c+j; y > c-j; y--) {
                    tempData[r-j][y] = tempData[r-j][y-1];
                }
                
                // 맨 오른쪽 세로
                int rightTmp = tempData[r+j][c+j];
                for(int x = r+j; x > r-j; x--) {
                    tempData[x][c+j] = tempData[x-1][c+j];
                }
                tempData[r-j+1][c+j] = upTmp;
                
                // 맨 아래 가로
                int leftTmp = tempData[r+j][c-j];
                for(int y = c-j; y < c+j; y++) {
                    tempData[r+j][y] = tempData[r+j][y+1];
                }
                tempData[r+j][c+j-1] = rightTmp;
                
                // 맨 왼쪽 세로
                for(int x = r-j; x < r+j; x++) {
                    tempData[x][c-j] = tempData[x+1][c-j];
                }
                tempData[r+j-1][c-j] = leftTmp;
            }
        }
        for(int i=0; i<N; i++) {
            int sum = 0;
            for(int j=0; j<M; j++) {
                sum += tempData[i][j];
            }
            minVal = Math.min(minVal, sum);
        }
    }
}