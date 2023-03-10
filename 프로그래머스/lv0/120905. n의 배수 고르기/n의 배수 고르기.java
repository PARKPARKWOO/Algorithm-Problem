import java.util.*;
class Solution {
    public int[] solution(int n, int[] numlist) {
        ArrayList<Integer> arr1 = new ArrayList<>();
        for (int i = 0; i < numlist.length; i++) {
            if (numlist[i] % n == 0){
                arr1.add(numlist[i]);
            }
        }
        int arr1size = arr1.size();
        return arr1.stream().mapToInt(i -> i).toArray();
    }
}