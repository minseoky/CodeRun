import java.util.Scanner;
/*
계단 오르는 데는 다음과 같은 규칙이 있다.

계단은 한 번에 한 계단씩 또는 두 계단씩 오를 수 있다. 즉, 한 계단을 밟으면서 이어서 다음 계단이나, 다음 다음 계단으로 오를 수 있다.
연속된 세 개의 계단을 모두 밟아서는 안 된다. 단, 시작점은 계단에 포함되지 않는다.
마지막 도착 계단은 반드시 밟아야 한다.
따라서 첫 번째 계단을 밟고 이어 두 번째 계단이나, 세 번째 계단으로 오를 수 있다. 하지만, 첫 번째 계단을 밟고 이어 네 번째 계단으로 올라가거나, 첫 번째, 두 번째, 세 번째 계단을 연속해서 모두 밟을 수는 없다.

각 계단에 쓰여 있는 점수가 주어질 때 이 게임에서 얻을 수 있는 총 점수의 최댓값을 구하는 프로그램을 작성하시오.
*/

public class Main {
	static int[] bottomUp;
	static int[] stairScore; //계단 순서별 점수 
	static int N;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		stairScore = new int[301];
		bottomUp = new int[301];
		for (int i = 1 ; i <= N ; i++) {
			stairScore[i] = scan.nextInt();
		}
		calculate(stairScore);
		System.out.println(bottomUp[N]);
		
	}
	
	public static void calculate(int[] stairScore) {
		//이하 점화식
		bottomUp[1] = stairScore[1];
		bottomUp[2] = stairScore[1] + stairScore[2];
		bottomUp[3] = Math.max(stairScore[1] + stairScore[2], stairScore[2] + stairScore[3]);
		for (int i = 3 ; i <= N ; i++) {
			bottomUp[i] = Math.max(bottomUp[i-2] + stairScore[i], bottomUp[i-3] + stairScore[i-1] + stairScore[i]);
		}
	}
}