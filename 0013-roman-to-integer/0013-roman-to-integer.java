class Solution {
    int answer;
    public int romanToInt(String s) {
        answer = 0;
        for (int i =0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'I' || c == 'X' || c == 'C') {
                i += func(s, i, 0);
            } else {
                if (c == 'V') {
                    answer += 5;
                } else if (c == 'X') {
                    answer += 10;
                } else if (c == 'L') {
                    answer += 50;
                } else if (c == 'C') {
                    answer += 100;
                } else if (c == 'D') {
                    answer += 500;
                } else {
                    answer += 1000;
                }
            }
        }
        return answer;
    }
    
    // I X C 의 경우 체크
    private int func(String s, int idx, int depth) {
        char cc = s.charAt(idx);
        if (idx >= s.length() - 1) {
            if (cc == 'I' ){
                answer += 1;
            } else if (cc == 'X') {
                answer += 10;
            } else if ( cc == 'C') {
                answer += 100;
            }
            return depth;
        }
        
        char c = s.charAt(idx + 1);
        
        if (c == 'V' &&  cc == 'I') {
            answer += 4;
            return 1;
        } else if (c == 'X' && cc == 'I') {
            answer += 9;
            return 1;
        } else if (c == 'L' && cc == 'X'){
            answer += 40;
            return 1;
        } else if (c == 'C' && cc == 'X') {
            answer += 90;
            return 1;
        } else if (c == 'D' && cc == 'C') {
            answer += 400;
            return 1;
        } else if (c== 'M' && cc == 'C') {
            answer += 900;
            return 1;
        } else if (cc == 'I' ){
            answer += 1;
        } else if (cc == 'X') {
            answer += 10;
        } else if ( cc == 'C') {
            answer += 100;
        }
        return 0;
    }
}