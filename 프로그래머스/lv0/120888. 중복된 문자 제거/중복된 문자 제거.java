import java.util.*;

class Solution {
    public String solution(String my_string) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        sb.append(my_string);
        HashSet<String> hash = new LinkedHashSet<>();
        for (int i = 0; i < sb.length(); i++) {
            hash.add(String.valueOf(my_string.charAt(i)));
        }
        return hash.toString().replace("[","").replace("]","").replace(", ","");
    }
}