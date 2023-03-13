class Solution {
    public String solution(String letter) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        String[] morse = new String[]{".-","-...","-.-.","-..",".","..-.",
                "--.","....","..",".---","-.-",".-..","--","-.",
                "---",".--.","--.-",".-.","...","-","..-","...-",
                ".--", "-..-", "-.--", "--.."};
        String[] str = letter.split(" ");
        for (String st :
                str) {
            for (int i = 0; i < morse.length; i++){
                if (st.equals(morse[i])) {
                    sb.append(Character.toString('a' + i));
                }
            }


        }
        return sb.toString();
    }
}