import java.text.DecimalFormat;
import java.util.*;
class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        String binary;
        for (int i = 0; i < n; i++) {
            binary = Integer.toBinaryString(arr1[i] | arr2[i]);
            binary = String.format("%" + n + "s", binary).replace( " ", "0");
            System.out.println(binary);
            answer[i] = binary.replace("1", "#").replace("0", " ");
        }
        return answer;
    }
}