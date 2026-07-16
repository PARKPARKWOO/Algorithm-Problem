class Solution {
    List<String> answer = new ArrayList<>();
    Map<String, Integer> map = new HashMap<>();
    public List<String> subdomainVisits(String[] cpdomains) {
        for (String s: cpdomains) {
            String[] split = s.split(" ");
            String domain = split[1];
            int cnt = Integer.valueOf(split[0]);
            parse(domain, cnt);
        }

        for (Map.Entry<String, Integer> entry: map.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();
            answer.add(value + " " + key);
        }
        return answer;
    }
    void parse(String domain, int cnt) {
        String[] d = domain.split("\\.");
        
        for (int i = 0; i < d.length; i++) {
            String s = d[i];
            for (int j = i + 1; j < d.length; j++) {
                s += "." + d[j];
            }
            map.put(s, map.getOrDefault(s, 0) + cnt);
        }
    }
}