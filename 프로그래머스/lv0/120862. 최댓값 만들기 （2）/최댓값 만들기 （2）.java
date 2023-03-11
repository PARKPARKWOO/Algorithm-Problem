import java.util.*;
class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        Arrays.sort(numbers);
        int arr1 = numbers[0] * numbers[1];
        int arr2 = numbers[numbers.length-1] * numbers[numbers.length-2];
        if (arr1 < arr2){
            answer = arr2;
        } else {answer = arr1;}
        return answer;
    }
}