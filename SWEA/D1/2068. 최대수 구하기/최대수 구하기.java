import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		//표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옴
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt();

		for(int t = 1; t <= T; t++)
		{
            // 최댓값 저장하기
            int max = 0;
            // 10개의 입력값 받기
            for (int i = 0; i < 10; i++) {
                // 입력받는수와 현재max값과 비교
				max = Math.max(max, sc.nextInt());
			}
			System.out.printf("#%d %d\n", t, max);
		}
	}
}