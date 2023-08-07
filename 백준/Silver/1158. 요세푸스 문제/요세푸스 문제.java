import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		List<Integer> data = new ArrayList<>();
		Stack<Integer> s = new Stack<>();
		for (int i = 1; i <= n; i++) {
			s.add(i);
		}
		
		int idx = k-1;
		data.add(s.remove(idx));
		while (!s.isEmpty()) {
			if (s.size() == 1) {
				data.add(s.pop());
				break;
			}
			else {
				idx += k-1;
				while(idx >= s.size()) {
					idx -= s.size();
				}
				data.add(s.remove(idx));
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		for (int i = 0; i < data.size(); i++) {
			if(i == data.size()-1) {
				sb.append(data.get(i) +">");
			}
			else {
				sb.append(data.get(i)+ ", ");
			}
		}
		System.out.println(sb.toString());
	}
}