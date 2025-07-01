class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] answer = new int[2];
        int mid = getMid(nums, target);
        if (mid == -1) {
            answer[0] = -1;
            answer[1] = -1;
        } else {
            int start = getStart(nums, target);
            int end = getEnd(nums, target);
            answer[0] = start;
            answer[1] = end;
        }
        return answer;
    }
    private int getMid(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (end + start) / 2;
            int mValue = nums[mid];
            if (mValue == target) {
                return mid;
            } else if (mValue > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    private int getEnd(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int result = 0;
        while (start <= end ) {
            int mid = (end + start) / 2;
            int mValue = nums[mid];
            if (mValue > target) {
                end = mid - 1;
            } else if (mValue == target) {
                result = mid;
                start = mid + 1; 
            } else {
                start = mid + 1;
            }
        }
        return result;
    }

    private int getStart(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int result = 0;
        while (start <= end) {
            int mid = (end + start) / 2;
            int mValue = nums[mid];
            if (mValue < target) {
                start = mid + 1;
            } else if (target == mValue) {
                result = mid;
                end = mid - 1;
            } else {
                end = mid - 1;
            }
        }
        return result;
    }
}