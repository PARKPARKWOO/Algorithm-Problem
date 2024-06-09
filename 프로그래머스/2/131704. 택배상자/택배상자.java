import java.util.*;
class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        int num = 1;
        int idx = 0;
        while (order.length > idx) {
            int now = order[idx];
            // 배열에서 꺼낼때 같음
            if (now == num) {
                answer++;
                idx++;
                num++;
            } else {
                // 보조 레일에서 꺼낸 값이랑 같으면
                if (!stack.isEmpty() && stack.peek() == now) {
                    stack.pop();
                    idx++;
                    answer++;
                } else if (num < now ) {
                    stack.add(num++);
                } else if(!stack.isEmpty() && stack.peek() < now) {
                    stack.add(num++);
                } else if (stack.isEmpty() && now > num){
                    stack.add(num++);
                } else {
                    break;
                }
                
            }
        }
        return answer;
    }
}

