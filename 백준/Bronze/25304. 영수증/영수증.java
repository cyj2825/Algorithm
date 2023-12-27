import java.util.*;
import java.io.*;

public class Main {
    static int X, N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        X = Integer.parseInt(br.readLine());
        N = Integer.parseInt(br.readLine());
        int answer = 0;
        
        StringTokenizer st = null;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            answer += a * b;
        }
        if(answer == X) System.out.println("Yes");
        else System.out.println("No");
    }
}