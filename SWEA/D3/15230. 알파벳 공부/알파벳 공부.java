import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution
{
    static int num, count;
	public static void main(String args[]) throws Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for(int i = 1; i <= tc; i++) {
			char[] alphabet = br.readLine().toCharArray();
			num = 97;
			count = 0;
			for(char x: alphabet) {
				if(num == (int)x) count++;
				else break;
				num++;
			}
			System.out.printf("#%d %d\n", i, count);
		}
	}
}