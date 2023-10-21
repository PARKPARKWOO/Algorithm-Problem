import java.util.*;
class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        int orderIdx = 0;
        for (int i = 1; i <= order.length + 1; i++){
            if (i == order[orderIdx]) {
                answer++;
                orderIdx++;
            }
            else{
                if (stack.isEmpty()) stack.push(i);
                else{
                    while (!stack.isEmpty() && stack.peek() == order[orderIdx]){
                        stack.pop();
                        answer++;
                        orderIdx++;
                    }
                    stack.push(i);
                }
            }
        }
        return answer;
    }
}