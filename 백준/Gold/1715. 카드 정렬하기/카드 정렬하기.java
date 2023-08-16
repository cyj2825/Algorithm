import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
	static int count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> q = new PriorityQueue<>();
		
		for(int i = 0; i < N; i++) {
			q.offer(Integer.parseInt(br.readLine()));
		}
		count = 0;
		cardSort(q);
		System.out.println(count);	
	}
	
	private static void cardSort(Queue<Integer> q) {
		int size = q.size();
		if(size == 1) {
			return;
		}
		int x = 0;
		x += q.poll();
		x += q.poll();
		count += x;
		q.offer(x);
		cardSort(q);
	}
}