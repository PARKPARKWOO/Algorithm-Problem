class Solution {
    private int[] answer;
    public int[] executeInstructions(int n, int[] startPos, String s) {
        answer = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            int[] pos = startPos.clone();
            recursion(n, pos, s, i);
        }
        return answer;
    }

    private void recursion(int n, int[] position, String s, int idx) {
        String str = s.substring(idx);
        int cnt = 0;
        for (int i = 0; i < str.length(); i++) {
            if (check(position, n, str.charAt(i))) {
                cnt++;
            } else {
                break;
            }
        }
        answer[idx] = cnt;
    }

    private boolean check(int[] position, int n, char c) {
        if (c == 'R') {
            if (position[1] < n - 1) {
                position[1]++;
                return true;
            }
        } else if(c == 'L') {
            if (position[1] > 0) {
                position[1]--;
                return true;
            }
        } else if (c == 'U') {
            if (position[0] > 0) {
                position[0]--;
                return true;
            }
        } else {
            if (position[0] < n - 1) {
                position[0]++;
                return true;
            }
        }
        return false;
    }
}