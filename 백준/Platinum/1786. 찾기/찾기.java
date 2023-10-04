import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] text = br.readLine().toCharArray();
		char[] pattern = br.readLine().toCharArray();
		
		int tlen = text.length;
		int plen = pattern.length;
		
		int[] p = new int[plen];
		
		for(int i = 1, j = 0; i < plen; i++) {
			while(j > 0 && pattern[i] != pattern[j]) j = p[j-1];
			
			if(pattern[i] == pattern[j]) p[i] = ++j;
		}
		
		int cnt = 0;
		ArrayList<Integer> list = new ArrayList<>();
		for(int i = 0, j = 0; i < tlen; i++) {
			while(j > 0 && text[i] != pattern[j]) j = p[j-1];
			if(text[i] == pattern[j]) {
				if(j == plen-1) {
					cnt++;
					list.add(i-plen+1);
					j = p[j];
				}else {
					j++;
				}
			}
		}
		System.out.println(cnt);
		if(cnt > 0) {
			StringBuilder sb = new StringBuilder();
			for(Integer idx : list) {
				sb.append(idx+1 + " ");
			}
			System.out.println(sb.toString());
		}
	}
}