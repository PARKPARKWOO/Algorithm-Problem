class Solution {
    private int result;
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        int gdcA = arrayA[0];
        int gdcB = arrayB[0];
        for (int i = 1; i < arrayA.length; i++) {
            gdcA = gdc(gdcA, arrayA[i]);
            gdcB = gdc(gdcB, arrayB[i]);
        }
        if (!check(gdcA, arrayB)) {
            answer = Math.max(answer, gdcA);
        }
        
        if (!check(gdcB, arrayA)) {
            answer = Math.max(answer, gdcB);
        }
        return answer;
    }
    // true 일시 나눌수 있음
    private boolean check(int gdc, int[] arr) {
        for (int n: arr) {
            if (n % gdc == 0) return true;
        }
        return false;
    }
    private int gdc(int a, int b) {
        if (a % b == 0) return b;
        return gdc(b, a % b);
    }
    
    
}