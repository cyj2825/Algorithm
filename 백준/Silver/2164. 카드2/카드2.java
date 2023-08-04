import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		// 카드를 넣을 큐
		Queue<Integer> data = new LinkedList<>();
		for(int i = 1; i <= n; i++) {
			data.add(i);
		}
		while (data.size() > 1) {
			data.remove();
			int x = data.poll();
			data.add(x);
		}
		System.out.println(data.peek());
	}
}