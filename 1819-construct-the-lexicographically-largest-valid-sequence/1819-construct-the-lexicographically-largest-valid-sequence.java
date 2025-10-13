class Solution {
    private int[] answer = null;
    private int maxDepth;
    private int size;
    public int[] constructDistancedSequence(int n) {
        size = (n * 2) - 1;
        maxDepth = n;
        for (int i = n; i >= 1; i--) {
            if (answer == null) {
                int[] arr = new int[size];
                full(i, arr, 0);
                boolean[] v = new boolean[n + 1];
                v[i] = true;
                recursive(arr, v, 1, n);
            }
        }
        return answer;
    }

    private void recursive(int[] arr, boolean[] v, int depth, int n) {
        if (answer != null) {
            return;
        }
        int idx = getIdx(arr);
        if (idx == -1) {
            int[] copy = new int[size];
            for (int i = 0; i < size; i++) {
                copy[i] = arr[i];
            }
            answer = copy;
            return;
        }
        
        for (int i = n; i >= 1; i--) {
            if (!v[i] && full(i, arr, idx)) {
                v[i] = true;
                recursive(arr, v, depth + 1, n);
                revoke(i, arr, idx);
                v[i] = false;
            }
        }
    }

    private int getIdx(int[] arr) {
        for (int i = 0; i < size; i++) {
            if (arr[i] == 0) {
                return i;
            }
        }
        return -1;
    }

    private boolean full(int n, int[] arr, int idx) {
        if (n == 1) {
            if ( arr[idx] == 0) {
                arr[idx] = 1;
                return true;
            }
            return false;
        }
        if (idx + n < size) {
            if (arr[idx] != 0|| arr[idx + n] != 0) {
                return false;
            }
            arr[idx] = n;
            arr[idx + n] = n;
            return true;
        } else {
            return false;
        }
    }
    private void revoke(int n, int[] arr, int idx) {
        arr[idx] = 0;
        if (n != 1) {
            arr[idx + n] = 0;
        }
    }
}