import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

class Solution {
    // 차 번호 입장 시간
    private Map<Integer, LocalTime> in;
    // 차번호, 시간
    private Map<Integer, Integer> bills;
    private Set<Integer> car;
    private List<Integer> result;
    private int defaultBill;
    private int defaultTime;
    private int plusTime; // 분마다 더하기
    private int plusMoney; // 분마다 더해야할 금액
    private int carCnt;

    private LocalTime endTime = LocalTime.MAX;
    public int[] solution(int[] fees, String[] records) {
        carCnt = 0;
        in = new HashMap<>();
        bills = new HashMap<>();
        defaultBill = fees[1];
        car = new HashSet<>();
        defaultTime = fees[0];
        plusTime = fees[2];
        plusMoney = fees[3];
        for (String str: records) {
            switch (checkInOut(str)) {
                case "IN" -> {
                    in(str);
                }
                case "OUT" -> {
                    out(str);
                }
            }
        }
        carCnt = car.size();
        result = new ArrayList<>();
        end();
        System.out.println(Arrays.toString(result.stream().mapToInt(i -> i).toArray()));
        return result.stream().mapToInt(i -> i).toArray();
    }
    // out 시
    private void out(String str) {
        int carNum = getCarNum(str);
        LocalTime outTime = getTime(str);
        LocalTime inTime = in.get(carNum);
        int min = getMin(inTime, outTime);
        if (bills.get(carNum) != null) {
            min += bills.get(carNum);
        }
        in.remove(carNum);
        bills.put(carNum, min);
    }

    private int getMin(LocalTime inTime, LocalTime outTime) {
        int hourToMin = ((outTime.getHour() - inTime.getHour()) * 60);
        if (outTime.getMinute() < inTime.getMinute()) {
            hourToMin -= 60;
            int min = (outTime.getMinute() + 60) - (inTime.getMinute());
            return hourToMin + min;
        }
        return hourToMin + (outTime.getMinute() - inTime.getMinute());
    }
    private void end() {
        if (!in.isEmpty()) {
            for (Map.Entry<Integer, LocalTime> integerLocalTimeEntry : in.entrySet()) {
                int carNum = integerLocalTimeEntry.getKey();
                LocalTime time = integerLocalTimeEntry.getValue();
                // 시간 구하기
                int min = getMin(time, endTime);
                // 나간적 있다면 추가 금액을 더한다.
                if (bills.get(carNum) != null){
                    Integer beforeMin = bills.get(carNum);
                    beforeMin += min;
                    bills.put(carNum, beforeMin);
                }
                // 없다면 result에 담기
                else {
                    bills.put(carNum, min);
                }
            }
        }
        Map<Integer, Integer> tree = new TreeMap<>(bills);
        for (Integer value : tree.values()) {
            result.add(returnMoney(value));
        }
    }

    // 초과한 시간만큼 돈 더하기
    private int returnMoney(int min) {
        if (defaultTime >= min) return defaultBill;
        int money = defaultBill;
        int time = min - defaultTime;
        if (time % plusTime != 0) {
            int i = time / plusTime;
            return money + (plusMoney * (i + 1));
        }
        return money + plusMoney * (time / plusTime);
    }
    private void in(String str){
        in.put(getCarNum(str), getTime(str));
        car.add(getCarNum(str));
    }

    private int getCarNum(String str) {
        return Integer.parseInt(str.substring(6, 10));
    }

    private LocalTime getTime(String str) {
        return LocalTime.parse(str.substring(0, 5), DateTimeFormatter.ofPattern("HH:mm"));
    }

    private String checkInOut(String str) {
        return str.substring(11);
    }
}