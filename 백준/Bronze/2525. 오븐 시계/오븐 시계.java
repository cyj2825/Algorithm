import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
 
public class Main {
    static int A, B, C;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
 
        C = Integer.parseInt(br.readLine());
 
        int min = 60 * A + B;   // '시'를 '분'으로 변경
        min += C;
 
        int hour = (min / 60) % 24;
        int minute = min % 60;
 
        System.out.println(hour + " " + minute);
    }
}