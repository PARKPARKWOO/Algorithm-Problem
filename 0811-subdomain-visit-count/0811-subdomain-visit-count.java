class Solution {
    Map<String, Integer> map;
    public List<String> subdomainVisits(String[] cpdomains) {
        map = new HashMap<>();
        List<String> answer = new ArrayList<>();
        for (int i = 0; i < cpdomains.length; i++) {
            String s = cpdomains[i];
            String[] split = s.split(" ");
            int visit = Integer.valueOf(split[0]);
            String domain = split[1];
            
            parse(domain, visit);
        }

        for (Map.Entry<String, Integer> entry: map.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();
            String s = value +" " + key;
            answer.add(s);
        }
        return answer;        
    }
    
    void parse(String domain, int visit) {
        String[] split = domain.split("\\.");
        
        for (int i = 0; i < split.length; i++) {
            String s = split[i];
            for (int j = i + 1; j < split.length; j++) {
                s += "." + split[j];
            }
            map.put(s, map.getOrDefault(s, 0) + visit);
        }
    }
}