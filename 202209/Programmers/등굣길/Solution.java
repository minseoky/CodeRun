import java.util.Arrays;
//등굣길 
//dp[i][j]로 가는 경우의 수 저장
class Solution {
    int[][] dp;
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        dp = new int[m][n];
        dp[0][0] = 1;
        //현재 dp가 물웅덩이면 -1으로 초기화
        for(int k = 0 ; k < puddles.length ; k++) {
        	dp[puddles[k][0]-1][puddles[k][1]-1] = -1;
        }
        	
        for (int i = 0 ; i < m ; i++){
            for (int j = 0 ; j < n ; j++){
            	if (dp[i][j] != -1) {
                    if(i > 0 || j > 0){ //[0][0]위치 배제
                    	if (i == 0 && j > 0) {
                            dp[i][j] = dp[i][j-1];
                    	}
                    	else if (j == 0 && i > 0) {
                    		dp[i][j] = dp[i-1][j];
                    	}
                    	else {
                    		dp[i][j] = (dp[i-1][j] + dp[i][j-1])%1000000007;
                    	}
                    }
            		
            	}
            	
            	else {
            		dp[i][j] = 0;
            	}
            }
        }
        return dp[m-1][n-1];
    }
}
//원래 dp배열을 계산할때 물웅덩이를 0으로 초기화해주었는데 미리 물웅덩이에 -1을 넣고 dp배열 계산때 예외처리해주는게 효율성 면에서 더 탁월함
//효율성 1,6,8,9 에러 -> 해결