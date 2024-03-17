class Solution {
    private int cnt;
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        boolean cant = true;
        for (String word: words) {
            if (word.equals(target)) {
                cant = false;
            }
        }
        if (cant) return 0;
        cnt = Integer.MAX_VALUE;
        recursive(begin, target, words, -1, new boolean[words.length]);
        return cnt;
    }

    private void recursive(String now, String target, String[] words, int depth, boolean[] check) {
        if (depth == words.length) return;
        if (now.equals(target)) {
            cnt = Math.min(cnt, depth + 1);
            return;
        }
        System.out.println(now);
        for (int i = 0; i < words.length; i++) {
            if (i == depth) continue;
            if (!check[i] && canChange(now, words[i])) {
                check[i] = true;
                recursive(words[i], target, words, depth + 1, check);
                check[i] = false;
            }
        }
    }
    private boolean canChange(String begin, String target) {
        int c = 0;
        for (int i = 0; i < begin.length(); i++) {
            if (begin.charAt(i) != target.charAt(i)) c++;
        }
        if (c == 1) return true;
        return false;
    }
}