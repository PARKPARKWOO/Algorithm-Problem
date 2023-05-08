import java.util.*;
class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;
        int[] temp = new int[1];

        Arrays.sort(A);
        Arrays.sort(B);
        for (int i = 0; i < A.length; i++) {
            temp[0] +=  A[i] * B[B.length - 1 -i];
        }

        return temp[0];
    }
}