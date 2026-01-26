class Solution {
    List<List<Integer>> answer = new ArrayList<>();
    boolean[] v;
    public List<List<Integer>> permute(int[] nums) {
        v = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            v[i] = true;
            List<Integer> list = new ArrayList<>();
            list.add(nums[i]);
            recursive(nums, list, i);   
            v[i] = false;
        }
        return answer;
    }

    private void recursive(int[] nums, List<Integer> list, int idx) {
        if (list.size() == nums.length) {
            List<Integer> copy = new ArrayList<>(list);
            answer.add(copy);
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (!v[i]) {
                v[i] = true;
                list.add(nums[i]);
                recursive(nums, list, i);
                list.remove(list.size() - 1);
                v[i] = false;
            }
        }
    }
}