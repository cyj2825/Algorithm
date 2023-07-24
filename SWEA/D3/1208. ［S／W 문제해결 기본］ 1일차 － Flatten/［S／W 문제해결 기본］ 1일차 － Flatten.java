import java.util.Scanner;
import java.util.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);

		for(int tc = 1; tc <= 10; tc++)
		{
            int answer = 0;
            // 덤프 횟수 받기
            int num = sc.nextInt();
            int[] data = new int[100];
            
            // 상자에 들어있는 데이터 값들 받기
            for (int i = 0; i < 100; i++){
                data[i] = sc.nextInt();
            }
            Arrays.sort(data);
            
            // 덤프 횟수만큼 while문 돌기
            while (num > 0){
                data[99] -= 1;
                data[0] += 1;
                Arrays.sort(data);
                num--;
            }
            answer = data[99] - data[0];
			System.out.printf("#%d %d\n", tc, answer);

		}
	}
}