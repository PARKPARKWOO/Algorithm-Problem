class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> answer = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        
        for (String str: strs) {
            int sum = 0;
            char[] charArr = str.toCharArray();
            Arrays.sort(charArr);
            String sortStr = new String(charArr);
            List<String> list = map.get(sortStr);
            if (list == null) {
                list = new ArrayList<>();
            }
            list.add(str);
            map.put(sortStr, list);
        }

        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            answer.add(entry.getValue());
        }
        return answer;
    }
}