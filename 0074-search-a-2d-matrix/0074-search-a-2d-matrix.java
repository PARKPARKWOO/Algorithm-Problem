class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = getM(matrix, target);
        boolean answer = getAnswer(matrix[m], target);
        return answer;
    }
    private int getM(int[][] matrix, int target) {
        int end = matrix.length - 1;
        int start = 0;
        int idx = 0;
        while (start <= end) {
            int mid = (start + end) / 2;
            int v = matrix[mid][0];
            if (v <= target) {
                idx = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return idx;
    }
    private boolean getAnswer(int[] arr, int target) {
        if (arr.length == 1){ 
            return arr[0] == target;
        }
        int end = arr.length - 1;
        int start = 0;
        boolean result = false;
        while (start <= end) {
            int mid = (start + end) / 2;
            int v = arr[mid];
            if (v < target) {
                start = mid + 1;
            } else if (v == target) {
                return true;
            }else {
                end = mid - 1;
            }
        }
        return false;
    }
}