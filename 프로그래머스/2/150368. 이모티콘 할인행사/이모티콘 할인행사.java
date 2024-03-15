import java.util.*;
class Solution {
    private int service;
    private int amount;
    private int[] sales = {10, 20, 30, 40}; // 할인율
    int[] answer;
    List<Nodes[]> prices;

    public int[] solution(int[][] users, int[] emoticons) {
        answer = new int[2];
        prices = new ArrayList<>();
        recursive(emoticons, 0, new Nodes[emoticons.length], users);
        answer[0] = service;
        answer[1] = amount;
        System.out.println(Arrays.toString(answer));
        return answer;
    }

    // 이모티콘 마다 별도의 할인율 적용
    // idx = 이모티콘 idx
    private void recursive(int[] emoticons, int idx, Nodes[] price, int[][] users) {
        if (idx == price.length) {
            cal(price, users);
            return;
        }
        for (int i = 0; i < sales.length; i++) {
            price[idx] = new Nodes(sales[i], (emoticons[idx] / 100) * (100 - sales[i]));
            recursive(emoticons, idx + 1, price, users);
        }
    }

    private void cal(Nodes[] price, int[][] users) {

        int tempService = 0;
        int tempAmount = 0;

        for (int j = 0; j < users.length; j++) {
            int sum = 0;
            for (int k = 0; k < price.length; k++) {
                // 사용자가 구매할 경우
                if (users[j][0] <= price[k].per) {
                    sum += price[k].amount;
                }
            }
            if (sum >= users[j][1]) {
                tempService++;
            } else {
                tempAmount += sum;
            }
        }
        if (service < tempService) {
            service = tempService;
            amount = tempAmount;
        } else if (service == tempService && tempAmount > amount) {
            amount = tempAmount;
        }
    }
}

class Nodes {
    int per;
    int amount;

    public Nodes(int per, int amount) {
        this.per = per;
        this.amount = amount;
    }
}