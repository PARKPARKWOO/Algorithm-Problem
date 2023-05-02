import java.util.*;
class Solution {
    public int solution(int n) {
        int answer = 0;
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        list.add(1);
        for (int i = 3; i < n+1; i++) {
            list.add((list.get(i-1) + list.get(i - 2)) % 1234567);
        }
        answer = list.get(n);
        return answer;
    }
}