import java.io.*;
import java.util.*;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
		
        // Math.pow(거듭제곱할 숫자, 거듭제곱);
        System.out.println((int)Math.pow(Math.pow(2, N) + 1, 2));
        br.close();
    }
}