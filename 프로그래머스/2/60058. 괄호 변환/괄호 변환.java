class Solution {
    public String solution(String p) {
        if (check(p)) return p;
        String answer = right(p);
        return answer;
    }
    
    private String right(String str) {
        int error = 0;
        StringBuilder u = new StringBuilder();
        StringBuilder v = new StringBuilder();
        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) == '(') error++;
            else error--;
            
            if (error == 0) {
                u.append(str.substring(0, i + 1));
                v.append(str.substring(i + 1));
                if (check(u.toString())) {
                    u.append(right(v.toString()));
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("(");
                    sb.append(right(v.toString()));
                    sb.append(")");
                    sb.append(reverse(u.toString()));
                    return sb.toString();
                }
                break;
            }
        }
        return u.toString();
    }
    
    private String reverse(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i< str.length()- 1; i++){
            if (str.charAt(i) == '(') {
                sb.append(")");
            } else {
                sb.append("(");
            }
        }
        return sb.toString();
    }
    
    private boolean check(String str) {
        int error = 0;
        String[] result = new String[2];
        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) == '(') {
                error++;
            } else {
                error--;
            }
            if (error < 0) {
                return false;
            }
        }
        return true;
    }
}