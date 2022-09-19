import java.util.Scanner;

//정수 n이 주어졌을 때, n을 1, 2, 3의 합으로 나타내는 방법의 수를 구하는 프로그램을 작성하시오.
//동적 프로그래밍 연습
public class Main {
	static int[] bottomUp = new int[11];
	//bottomUp[1] =1을 나타내는 방법의 수
	//bottomUp[2] =2를 나타내는 방법의 수 
	static int[] testCase;
	public static void main(String[] args) {
		int T;
		Scanner scan = new Scanner(System.in);
		T = scan.nextInt();
		testCase = new int[T+1];
		for (int i = 0 ; i < T ; i++) {
			testCase[i] = scan.nextInt();
		}
		for (int i = 0 ; i < T ; i++) {
			System.out.println(calculate(testCase[i]));
		}
		
		

	}
	
	public static int calculate(int testCase) {
		bottomUp[0] = 0;
		bottomUp[1] = 1; //1
		bottomUp[2] = 2; //2, 1+1
		bottomUp[3] = 4; //3, 2+1, 1+2, 1+1+1
		for (int i = 4 ; i <= testCase ; i++) {//testCase 만큼 반복
			bottomUp[i] = bottomUp[i-1] + bottomUp[i-2] + bottomUp[i-3];
			
		}
		return bottomUp[testCase];
	}
}