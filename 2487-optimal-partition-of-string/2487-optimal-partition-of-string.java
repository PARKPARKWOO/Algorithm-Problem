class Solution {
    public int partitionString(String s) {
        int[] leastIdx = new int[26];
        int size = s.length();
        int cur = 0;
        int answer = 1;
        Arrays.fill(leastIdx, -1);
        for (int i = 0; i < size; i++) { 
            int n = s.charAt(i);
            if (leastIdx[n - 'a'] >= cur) {
                answer++;
                cur = i;
            }
            leastIdx[n - 'a'] = i;
        }
        return answer;
    }
}