class Solution {
    public int findKthLargest(int[] nums, int k) {
        Integer[] n = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(n, Collections.reverseOrder());
        return n[k - 1];
    }
}