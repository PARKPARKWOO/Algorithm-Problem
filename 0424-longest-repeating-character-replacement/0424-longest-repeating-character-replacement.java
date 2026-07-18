class Solution {
    public int characterReplacement(String s, int k) {
        int answer = 0;
        int[] freq = new int[26];
        int left = 0;
        int maxFreq = 0;
        for (int right = 0; right < s.length(); right++) {
            int idx = s.charAt(right) - 'A';
            freq[idx]++;
            maxFreq = Math.max(maxFreq, freq[idx]);
            
            while (right - left + 1 - maxFreq > k) {
                int id = s.charAt(left) - 'A';
                freq[id]--;
                left++;
            }
            
            answer = Math.max(answer, right - left + 1);
        }

        return answer;
    }
}