import java.util.*;
class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int[] answer = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;
        for (int start = 0, end = nums.length - 1; start < nums.length; start++, end--) {
            if (nums[start] < pivot) {
                answer[left] = nums[start];
                left++;
            }

            if (nums[end] > pivot) {
                answer[right] = nums[end];
                right--;
            }
        }
        while (left <= right) {
            answer[left++] = pivot;
        }
        return answer;
    }
}