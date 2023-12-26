import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int arr[] = new int[N];
        int M = Integer.parseInt(st.nextToken());
        int temp;
        for(int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        for(int j = 0; j < M; j++) {
            st = new StringTokenizer(br.readLine(), " ");
            int I = Integer.parseInt(st.nextToken());
            int J = Integer.parseInt(st.nextToken());
            temp = arr[I-1];
            arr[I-1] = arr[J-1];
            arr[J-1] = temp;
        }
        StringBuilder sb = new StringBuilder();
        for(int k = 0; k <arr.length; k++) {
            sb.append(arr[k] + " ");
        }
        System.out.println(sb);
        br.close();
    }
}