import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static long arr[];        // 원소를 저장하는 배열
	static long tree[];       // SGtree

	/**
	 * 원소를 이용해서 SGTree를 구성하는 함수
	 * @param node      Tree의 node 번호
	 * @param start     원소가 저장된 배열의 start index => node가 저장하고 있는 중간값에 대한 start index
	 * @param end       원소가 저장된 배열의 end index => node가 저장하고 있는 중간값에 대한 end index
	 * @return          node의 저장된 값을 리턴한다. 단말 노드면 원소의 값이고, 중간 노드면 관리하고 있는 중간 값
	 */
	static long init(int node, int start, int end) {
		if (start == end) {     // 단말 노드
			return tree[node] = arr[start];      // 원소의 값을 노드에 저장
		}else {
			// 하위 노드의 값을 더해서 저장                                    // 중간 노드
			int mid = (start+end)/2;          // => int mid = (start+end)/2;
			int nn = node*2;
			return tree[node] = init(nn, start, mid) + init(nn+1, mid+1, end);
		}
	}
	
	/**
	 * 구간 합을 구하는 함수
	 * @param node      Tree의 node 번호
	 * @param start     원소가 저장된 배열의 start index => node가 저장하고 있는 중간값에 대한 start index
	 * @param end       원소가 저장된 배열의 end index => node가 저장하고 있는 중간값에 대한 end index
	 * @param left      구간 합을 구할 start index
	 * @param right     구간 합을 구할 end index
	 * @return          arr의 index가 구간합을 구할 index의 범위 밖이면 0을 리턴하고
	 *                  범위 내의 index인 경우 단말 노드면 원소 값을 리턴하고
	 *                  중간 노드면 하위 노드를 sum한 값을 리턴한다.
	 */
	static long sum(int node, int start, int end, int left, long right) {
		if(left > end || right < start) {        // 구간합을 구할 범위 밖
			return 0;
		}
		// start~end는 구간합을 구할 범위 내에 속하는 원소
		
		// 단말 노드라면
		if(left <= start && end <= right) {
			return tree[node];
		}
		// 중간 노드라면 하위 노드의 sum값을 구한다.
		int mid = (start+end)/2;          // => int mid = (start+end)/2;
		int nn = node*2;
		//        왼쪽 하위 노드                                                            오른쪽 하위 노드
		return sum(nn, start, mid, left, right) + sum(nn+1, mid+1, end, left, right);
	}
	
	/**
	 * index번째 데이터의 값을 변경하기 
	 * @param node      Tree의 node 번호
	 * @param start     원소가 저장된 배열의 start index => node가 저장하고 있는 중간값에 대한 start index
	 * @param end       원소가 저장된 배열의 end index => node가 저장하고 있는 중간값에 대한 end index
	 * @param index     변경할 원소의 index
	 * @param diff      원소와 변경할 데이터의 차이값
	 */
	// 업데이트 함수
	public static void update(int node, int start, int end, int index, long diff) {
		if(index > end || index < start) {        // 범위 밖에 있는 node
			// 바꾸지 않는다
			return;
		}
		// 범위 내에 있는 node
		tree[node] += diff;       // 차이값을 update
		
		// 단말노드인 경우 -> 재귀를 끝내기 위한 조건
		if(start == end) {
			arr[index] = tree[node];
			return;
		}
		
		// 중간 노드인 경우 => 하위 노드도 변경해야 함
		int mid = (start+end)/2;
		int nn = node*2;
		update(nn, start, mid, index, diff);        // 왼쪽 노드
		update(nn+1, mid+1, end, index, diff);      // 오른쪽 노드
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		// 값이 크면 이렇게 해주는 것이 좋음
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		// 구분자 주는 것이 좋음! " "
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());        // 원소수
		int m = Integer.parseInt(st.nextToken());        // 구간합 구할 횟수
		int k = Integer.parseInt(st.nextToken());        // update 횟수
		
		arr = new long[n];
		tree = new long[n << 2];
		for(int i = 0; i < n; i++) {
			arr[i] = Long.parseLong(in.readLine());
		}
		init(1, 0, n-1);
		for(int i = 0, end = m+k; i < end; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int command = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			long b = Long.parseLong(st.nextToken());
			if(command == 1) {      // 변경
				// 1부터 시작하는 이유는 왼쪽값 = *2, 오른쪽값 = *2+1을 성립하게 하기위함(0인덱스값 비워둠)
				long diff = b - arr[a-1];
 				update(1, 0, n-1, a-1, diff);
			}else {                 // sum
				out.write(sum(1, 0, n-1, a-1, (int)b-1) + "\n");
			}
		}
		in.close();
		out.close();
	}
}