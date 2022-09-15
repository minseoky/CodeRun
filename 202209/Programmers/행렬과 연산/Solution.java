package programmersTest;

import java.util.Arrays;
import java.util.LinkedList;

class Solution {
	int r,c;
	LinkedList<Integer> column1 = new LinkedList<>();
	LinkedList<Integer> column2 = new LinkedList<>();
	LinkedList<LinkedList<Integer>> rows = new LinkedList<>();
	
	void setup(int[][] rc) {
		r = rc.length;
		c = rc[0].length;
    	
    	for (int i = 0 ; i < r ; i++) { //column 리스트 생성
    		column1.add(rc[i][0]);
    		column2.add(rc[r-i-1][c-1]);
    	}
    	
    	for (int j = 0 ; j < r ; j++) {
    		LinkedList<Integer> row = new LinkedList<>();
    		for(int k = 1 ; k < c-1 ; k++) {
    			row.add(rc[j][k]);
    		}
    		rows.add(row);
    	}
    	
		
	}
    void shiftrow(int[][] rc){ //rows배열 한칸씩 뒤로 
    	rows.addFirst(rows.pollLast());
    	column1.addFirst(column1.pollLast());
    	column2.addLast(column2.pollFirst());
    }
    
    void rotate(int[][] rc){
    	rows.peekFirst().addFirst(column1.pollFirst());
    	column2.addLast(rows.peekFirst().pollLast());
    	rows.peekLast().addLast(column2.pollFirst());
    	column1.addLast(rows.peekLast().pollFirst());
    }
    
    private int[][] getanswer() {
    	int[][] ans = new int[r][c];
    	for(int i = 0 ; i < r ; i++) {
    		ans[i][0] = column1.pollFirst();
    		ans[i][c-1] = column2.pollLast();
    	}
    	for(int j = 0 ; j < r ; j++) {
    		for(int k = 1 ; k < c-1 ; k++) {
    			ans[j][k] = rows.peekFirst().pollFirst();
    		}
    		rows.removeFirst();
    	}
    	
		return ans;
    	
    }
    public int[][] solution(int[][] rc, String[] operations) {
        setup(rc);
        for(int i = 0 ; i < operations.length ; i++){
            if (operations[i].equals("Rotate")){
                rotate(rc);
            }
            else if (operations[i].equals("ShiftRow")){
                shiftrow(rc);
            }
        }
        //System.out.println(Arrays.deepToString(getanswer()));
        return getanswer();
    }
}