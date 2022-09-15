import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> que1 = new LinkedList<>();
        Queue<Integer> que2 = new LinkedList<>();
        int count = 0;
        long sum1 = 0;
        long sum2 = 0;
        
        for (int i = 0 ; i < queue1.length ; i++){
            que1.add(queue1[i]);
            sum1 += queue1[i];
        }
        for (int i = 0 ; i < queue2.length ; i++){
            que2.add(queue2[i]);
            sum2 += queue2[i];
        }
        if ((sum1 + sum2)%2 != 0){
            return -1;
        }
        while(sum1 != sum2){
            count ++;
            
            if (sum1 > sum2){
                int value = que1.poll();
                que2.add(value);
                sum1 -= value;
                sum2 += value;
            }
            else{
                int value = que2.poll();
                que1.add(value);
                sum1 += value;
                sum2 -= value;
            }
            
            if (count > (queue1.length + queue2.length)*3){
                return -1;
            }
        }
        
        return count;
    }
}