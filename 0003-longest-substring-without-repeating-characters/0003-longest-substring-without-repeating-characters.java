class Solution {
    public int lengthOfLongestSubstring(String s) {
        // right - left -> 현재 길이 -> 가장 긴 값
        // 중복이 연속적으로 나오는 경우, 중복이지만 우리가 현재 탐색하고 있는 범위 밖의 중복인 경우
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int answer = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (map.containsKey(c) && left <= map.get(c)) {
                left = map.get(c) + 1;
            }
            answer = Math.max(answer, right - left + 1);
            map.put(c, right);
        }

        return answer;
    }
}