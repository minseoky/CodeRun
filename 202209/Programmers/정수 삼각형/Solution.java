import java.util.*;
class Solution {
	int[][] dp; //[i]번째 줄 [j]번째 
	public int solution(int[][] triangle) {
		int answer = Integer.MIN_VALUE;
		dp = new int[triangle.length+1][triangle[triangle.length-1].length];
		dp[0][0] = triangle[0][0];
		for(int i = 1 ; i < triangle.length ; i++) {
			for(int j = 0 ; j < triangle[i].length ; j++) {
				if(j == 0) {//왼쪽 끝일경우
					dp[i][j] = dp[i-1][j]+triangle[i][j];
				}
				else if (j == triangle[i].length) {//오른쪽 끝일경우 
					dp[i][j] = dp[i-1][j-1]+triangle[i][j];
				}
				else {
					dp[i][j] = Math.max(dp[i-1][j]+triangle[i][j],dp[i-1][j-1]+triangle[i][j]);
				}
			}
		}
		answer = Arrays.stream(dp[triangle.length-1]).max().getAsInt();
		return answer;
	}
}
