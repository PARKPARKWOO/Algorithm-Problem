import java.util.*;
class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        PriorityQueue<Room> inQ = new PriorityQueue<>((a, b) -> a.in - b.in);
        PriorityQueue<Room> outQ = new PriorityQueue<>((a, b) -> a.out - b.out);

        for (String[] book : book_time) {
            Room r = new Room(book[0], book[1]);
            inQ.add(r);
        }

        while (!inQ.isEmpty()) {
            Room current = inQ.poll();
            // 현재 예약의 시작 시간이 outQ의 가장 빠른 종료 시간보다 늦거나 같으면, 방을 비울 수 있음
            while (!outQ.isEmpty() && outQ.peek().out <= current.in) {
                outQ.poll();
              //  answer--; // 방 하나를 비웠으므로 필요한 방의 수 감소
            }
            // 현재 예약을 처리하기 위해 방 하나 추가
            outQ.add(current);
            //answer++; // 필요한 방의 수 증가

            // 최대 필요한 방의 수를 갱신
            answer = Math.max(answer, outQ.size());
        }

        return answer;
    }
}

class Room {
    int in;
    int out;

    public Room(String in, String out) {
        String[] inArr = in.split(":");
        String[] outArr = out.split(":");
        this.in = (Integer.parseInt(inArr[0]) * 60) + Integer.parseInt(inArr[1]);
        this.out = (Integer.parseInt(outArr[0]) * 60) + Integer.parseInt(outArr[1]) + 10; // 체크아웃 후 10분 추가
    }
}
