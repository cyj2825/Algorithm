import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// char 알파벳과 왼쪽 노드, 오른쪽 노드를 가진 노드 객체를 만들어 구현
public class Main {
	static class Node{
		char data;
		Node left, right;
		
		public Node(char data, Node left, Node right) {
			super();
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}
	
	static int N;
	// 루트노드를 저장
	static Node head = new Node('A', null, null);

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			char root = st.nextToken().charAt(0);
			char left = st.nextToken().charAt(0);
			char right = st.nextToken().charAt(0);
			insertNode(head, root, left, right);
		}
		
		preOrder(head);
		System.out.println();
		inOrder(head);
		System.out.println();
		postOrder(head);
	}
	
	public static void insertNode(Node tmp, char root, char left, char right) {
		// 루트노드인지 확인
		// 만약 루트노드이고 left나 right 값이 '.'이 아니라면 해당 부분에 새로운 노드 생성
		if(tmp.data == root) {
			tmp.left = (left == '.' ? null : new Node(left, null, null));
			tmp.right = (right == '.' ? null : new Node(right, null, null));
		}
		else {
			if(tmp.left != null) insertNode(tmp.left, root, left, right);
			if(tmp.right != null) insertNode(tmp.right, root, left, right);
		}
	}
	
	public static void preOrder(Node node) {
		if(node == null) return;
		System.out.print(node.data);
		preOrder(node.left);
		preOrder(node.right);
	}
	
	public static void inOrder(Node node) {
		if(node == null) return;
		inOrder(node.left);
		System.out.print(node.data);
		inOrder(node.right);
	}
	
	public static void postOrder(Node node) {
		if(node == null) return;
		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.data);
	}
}