import java.util.*;
class Solution {
    List<List<Integer>> answer;
    public List<List<Integer>> subsets(int[] nums) {
        answer = new ArrayList<>();

        recursion(nums, 0, new ArrayList<>());
        
        return answer;
    }

    private void recursion(int[] nums, int idx, List<Integer> list) {
        answer.add(new ArrayList<>(list));
        for (int i = idx; i < nums.length; i++) {
            list.add(nums[i]);
            recursion(nums, i + 1, list);            
            list.remove(list.size() - 1);
        }

    }
}