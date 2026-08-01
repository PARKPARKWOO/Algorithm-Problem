class Solution {
    public int minimumPushes(String word) {
        int[] cnts = new int[26];
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            cnts[c - 'a']++;
        }

        Arrays.sort(cnts);
        
        int sum = 0;
        for (int i = 0; i < 26; i++) {
            sum += cnts[25 - i] * ((i / 8) + 1);
        }

        return sum;
    }
}