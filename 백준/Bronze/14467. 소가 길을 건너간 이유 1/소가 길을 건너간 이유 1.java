import java.util.*;
import java.io.*;

public class Main {
	static class Pair{
		int num, position;
		
		public Pair() {
			super();
			this.num = 0;
			this.position = -1;
		}
	}
	static int N, answer = 0;
	static Pair[] data;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		data = new Pair[N];
		
		for(int i = 0; i < N; i++) {
			data[i] = new Pair();
		}
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			if(data[x-1].position != value) {
				data[x-1].num++;
				data[x-1].position = value;
			}
		}
		for(Pair p : data) {
			if(p.position != -1) answer += p.num-1;
		}
		System.out.println(answer);
	}
}