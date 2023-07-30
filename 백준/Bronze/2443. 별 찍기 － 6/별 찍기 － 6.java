import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		for (int i = n; 1 <= i; i--) {
			for (int j = 0; j < n-i; j++) {
				System.out.print(" ");
			}
			for(int k = 0; k < i*2 - 1; k++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}