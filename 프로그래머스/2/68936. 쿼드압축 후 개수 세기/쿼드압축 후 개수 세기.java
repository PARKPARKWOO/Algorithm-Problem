class Solution {
    int[] answer = new int[2];
    public int[] solution(int[][] arr) {
        int size = arr.length;
        recursive(arr, 0, 0, size);
        return answer;
    }
    
    private void recursive(int[][] arr, int x, int y, int size) {
        if (check(x, y, size, arr)) {
            answer[arr[x][y]]++;
            return;
        }
        recursive(arr, x, y, size / 2);
        recursive(arr, x + size/2, y, size/2);
        recursive(arr, x, y + size / 2, size/2);
        recursive(arr, x + size/2, y + size/2, size / 2);
    }
    
    private boolean check(int x, int y, int size, int[][] arr) {
        for (int i = x; i < x + size; i++){
            for (int j = y; j < y + size; j++){
                if (arr[x][y] != arr[i][j]) return false;
            }
        }
        return true;
    }
}