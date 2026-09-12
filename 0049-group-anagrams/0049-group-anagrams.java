class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            char[] ca = str.toCharArray();
            Arrays.sort(ca);
            String newString = new String(ca);
            List<String> list = map.get(newString);
            if (list == null) list = new ArrayList<>();
            list.add(str);
            map.put(newString, list);
        }
        List<List<String>> answer = new ArrayList<>();
        
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            answer.add(entry.getValue());
        }
        return answer;
    }
}