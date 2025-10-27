class Solution {
    private int[] cnt = new int[26];
    public int minimumPushes(String word) {
        for (char c: word.toCharArray()) {
            cnt[c - 'a']++;
        }

        Arrays.sort(cnt);
        int answer = 0;
        for (int i = 25; i >= 0; i--) {
            int c = cnt[i];
            if (c > 0) {
                if (i >= 18) {
                    answer += (c * 1);
                } else if (i >= 10) {
                    answer += (c * 2);
                } else if (i >= 2) {
                    answer += (c * 3);
                } else {
                    answer += (c * 4);
                }
            }
        }
        return answer;
    }
}