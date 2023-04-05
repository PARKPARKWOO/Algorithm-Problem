import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        Set<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            hashSet.add(nums[i]);
        }

        if ((nums.length / 2) < hashSet.size()) {
            answer = nums.length / 2;
        } else {
            answer = hashSet.size();
        }
        return answer;
    }
}