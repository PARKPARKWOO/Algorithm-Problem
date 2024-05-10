import java.util.*;
class Solution {
    Set<String> set;
    boolean[] v;
    public int solution(String[] user_id, String[] banned_id) {
        set = new HashSet<>();
        for (int i =0; i< banned_id.length; i++) {
            banned_id[i] = banned_id[i].replace("*", ".");
        }
        v = new boolean[user_id.length];
        recursive(0, "", user_id, banned_id);
        System.out.println(set.size());
        return set.size();
    }

    private void recursive(int depth, String now, String[] user_id, String[] banned_id) {
        if (depth == banned_id.length) {
            String[] arr = now.split(" ");
            String res = "";
            Arrays.sort(arr);
            for (int i = 0; i < arr.length; i++) {
                res += arr[i];
            }
            set.add(res);
            return;
        }
        for (int i =0; i < user_id.length; i++) {
            if (v[i] || !user_id[i].matches(banned_id[depth])) continue;
            v[i] = true;
            recursive(depth + 1,user_id[i] + " " + now, user_id, banned_id);
            v[i] = false;
        }
    }
}