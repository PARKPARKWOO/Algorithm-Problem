import java.util.*;
class Solution {
    int answer = 0;
    public int numOfPairs(String[] nums, String target) {
        Arrays.sort(nums, Comparator.comparingInt(String::length));
        
        recursive(nums, new ArrayList<>(), target);
        return answer;
    }

    private void recursive(String[] nums, List<Integer> permutation, String target) {
        if (permutation.size() == 2) {
            int idx1 = permutation.get(0);
            int idx2 = permutation.get(1);
            // 순서대로 두 문자열을 연결
            String num = nums[idx1] + nums[idx2];
            if (num.equals(target)) {
                answer++;
            }
            return;
        }
        // 모든 인덱스를 고려하여 순열 생성 (순서가 중요하므로 항상 0부터 시작)
        for (int i = 0; i < nums.length; i++) {
            if (permutation.contains(i)) continue;
            permutation.add(i);
            recursive(nums, permutation, target);
            permutation.remove(permutation.size() - 1);
        }
    }
}