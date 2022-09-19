import java.util.Scanner;

public class Main {
	static long[] bottomUpTable;
	public static void main(String[] args) {
		int n;
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		bottomUpTable = new long[(n+1)];
		System.out.println(bottomUp(n));

	}
	
	static long bottomUp(int n) {
		bottomUpTable[0] = 0;
		bottomUpTable[1] = 1;
		for(int i = 2 ; i <= n ; i++) {
			bottomUpTable[i] = bottomUpTable[i-1] + bottomUpTable[i-2];
		}
		return bottomUpTable[n];
		
	}
}