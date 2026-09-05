

class Solution {
    public int lengthOfLongestSubstring(String s) {
        // 중복문자열이 있는지 확인 해야한다.
        // 길이에 대한 정보를 알아야 한다. (중복 문자열에 대한 유효한 길ㅇ ㅣ확인)
        Map<Character, Integer> map = new HashMap<>();
        int answer = 0;
        int currentLen = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c) || left > map.get(c)) {
                answer = Math.max(i - left + 1, answer);
            } else {
                left = map.get(c) + 1;
                       
            }
            map.put(c, i);
        }
        return answer;
    }
}