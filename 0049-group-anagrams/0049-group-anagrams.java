class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // 요소들의 알파벳 순서와 상관없이 동일한 단어라면 group 화를 시키는 것
        // M * n log n 을 만족하는 방식
        List<List<String>> answer = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            char[] charArr = str.toCharArray();
            // eat, tae -> aet
            Arrays.sort(charArr);
            String sortStr = new String(charArr);
            List<String> list = map.get(sortStr);
            if (list == null) list = new ArrayList<>();
            list.add(str);
            map.put(sortStr, list);
        }

        for (Map.Entry<String, List<String>> entry: map.entrySet()) {
            answer.add(entry.getValue());
        }

        return answer;
    }
}