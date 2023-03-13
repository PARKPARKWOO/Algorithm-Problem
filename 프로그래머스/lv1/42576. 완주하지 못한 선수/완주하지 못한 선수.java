import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);
        int index = 0;
        int error = 0;
        for (int i = 0; i < completion.length; i++) {
            if (!(participant[i].equals(completion[i]))){
                index = i;
                error++;
                break;
            }
        }
        if (error == 0){
            index = participant.length - 1;
        }
        return participant[index];
    }
}