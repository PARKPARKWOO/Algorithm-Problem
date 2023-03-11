class Solution {
    public int solution(int n) {
        int answer = 0;
        int gcd = gcd(n, 6);
        return ((n / gcd) * (6 / gcd) * gcd) / 6;
    }
    public int gcd(int a, int b){
        int c;
        if (a < b){
            c = a;
            a = b;
            b = c;
        }
        if (a % b == 0){
            return b;
        }else {
            return gcd(b, a % b);
        }
    }
}