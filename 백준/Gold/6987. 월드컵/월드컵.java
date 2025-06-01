import java.util.*;

public class Main {
    private static int answer;
    private static Score[] scores = new Score[6];
    private static int isPossible = 0;
    private static boolean[] v = new boolean[6];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 4; i++) {
            isPossible = 0;
            for (int j = 0; j < 6; j++) {
                int win = scanner.nextInt();
                int draw = scanner.nextInt();
                int lose = scanner.nextInt();
                Score score = new Score(win, draw, lose);
                scores[j] = score;
            }
            v[0] = true;
            recursive(0, 1);
            System.out.print(isPossible + " ");
        }
    }

    private static void recursive(int source, int target) {
        if (source >= 5) {
            for (Score score : scores) {
                if (!score.isSuccess()) {
                    return;
                }
            }
            isPossible = 1;
            return;
        }

        if (target >= 6) {
            recursive(source + 1, source + 2);
            return;
        }
        Score score = scores[source];
        Score targetScore = scores[target];
        if (score.canWin() && targetScore.canLose()) {
            score.win();
            targetScore.lose();
            recursive(source, target + 1);
            score.rollbackWin();
            targetScore.rollbackLose();
        }
        if (score.canDraw() && targetScore.canDraw()) {
            score.draw();
            targetScore.draw();
            recursive(source, target + 1);
            score.rollbackDraw();
            targetScore.rollbackDraw();
        }

        if (score.canLose() && targetScore.canWin()) {
            score.lose();
            targetScore.win();
            recursive(source, target + 1);
            score.rollbackLose();
            targetScore.rollbackWin();
        }
    }
}

class Score {
    int win;
    int draw;
    int lose;

    public Score(int win, int draw, int lose) {
        this.win = win;
        this.draw = draw;
        this.lose = lose;
    }

    public boolean canWin() {
        return win > 0;
    }

    public boolean canDraw() {
        return draw > 0;
    }

    public boolean canLose() {
        return lose > 0;
    }

    public void win() {
        this.win--;
    }

    public void draw() {
        this.draw--;
    }

    public void lose() {
        this.lose--;
    }

    public void rollbackWin() {
        this.win++;
    }

    public void rollbackDraw() {
        this.draw++;
    }

    public void rollbackLose() {
        this.lose++;
    }

    public boolean isSuccess() {
        return win == 0 && draw == 0 && lose == 0;
    }
}