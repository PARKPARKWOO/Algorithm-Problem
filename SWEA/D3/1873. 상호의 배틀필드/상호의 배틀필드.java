import java.util.Scanner;
import java.io.FileInputStream;
public class Solution {
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // 테스트 케이스의 개수
        for (int tc = 1; tc <= T; tc++) {
            int H = sc.nextInt();
            int W = sc.nextInt();
            char[][] map = new char[H][W];
            for (int i = 0; i < H; i++) {
                String line = sc.next();
                map[i] = line.toCharArray();
            }
            int N = sc.nextInt();
            String command = sc.next();
            for (int i = 0; i < command.length(); i++) {
                switch (command.charAt(i)) {
                    case 'U':
                        uCommand(map);
                        break;
                    case 'D':
                        dCommand(map);
                        break;
                    case 'L':
                        lCommand(map);
                        break;
                    case 'R':
                        rCommand(map);
                        break;
                    case 'S':
                        sCommand(map);
                        break;
                }
            }
            System.out.print("#" + tc + " ");
            for (int i = 0; i < H; i++) {
                System.out.println(String.valueOf(map[i]));
            }
        }
    }

    static void uCommand(char[][] map) {
        boolean stop = false;
        for (int i = 0; i < map.length; i++) {
            if (stop) break;
            for (int j = 0; j < map[i].length; j++) {
                if (stop) break;
                if (map[i][j] == '^' || map[i][j] == 'v' || map[i][j] == '>' || map[i][j] == '<') {
                    if (i > 0 && map[i - 1][j] == '.') {
                        map[i][j] = '.';
                        map[i - 1][j] = '^';
                    }
                    else map[i][j] = '^';
                    stop = true;
                }
            }
        }
    }
    static void dCommand(char[][] map) {
        boolean stop = false;
        for (int i = 0; i < map.length; i++) {
            if (stop) break;
            for (int j = 0; j < map[i].length; j++) {
                if (stop) break;
                if (map[i][j] == '^' || map[i][j] == 'v' || map[i][j] == '>' || map[i][j] == '<') {
                    if (i < map.length - 1 && map[i + 1][j] == '.') {
                        map[i][j] = '.';
                        map[i + 1][j] = 'v';
                    }
                    else {
                        map[i][j] = 'v';
                    }
                    stop = true;
                }
            }
        }
    }
    static void lCommand(char[][] map) {
        boolean stop = false;
        for (int i = 0; i < map.length; i++) {
            if (stop) break;
            for (int j = 0; j < map[i].length; j++) {
                if (stop) break;
                if (map[i][j] == '^' || map[i][j] == 'v' || map[i][j] == '>' || map[i][j] == '<') {
                    if (j > 0 && map[i][j - 1] == '.') {
                        map[i][j] = '.';
                        map[i][j - 1] = '<';
                    }
                    else map[i][j] = '<';
                    stop = true;
                }
            }
        }
    }
    static void rCommand(char[][] map) {
        boolean stop = false;
        for (int i = 0; i < map.length; i++) {
            if (stop) break;
            for (int j = 0; j < map[i].length; j++) {
                if (stop) break;
                if (map[i][j] == '^' || map[i][j] == 'v' || map[i][j] == '>' || map[i][j] == '<') {
                    if (j < map[i].length - 1 && map[i][j + 1] == '.') {
                        map[i][j] = '.';
                        map[i][j + 1] = '>';
                    } else map[i][j] = '>';
                    stop = true;
                }
            }
        }
    }
    static void sCommand(char[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == '^' || map[i][j] == 'v' || map[i][j] == '>' || map[i][j] == '<') {
                    switch (map[i][j]) {
                        case '^' :
                            for (int k = i - 1; k >= 0; k--) {
                                if (map[k][j] == '*') {
                                    map[k][j] = '.';
                                    break;
                                } else if (map[k][j] == '#') break;
                            }
                            break;
                        case 'v' :
                            for (int k = i + 1; k < map.length; k++) {
                                if (map[k][j] == '*') {
                                    map[k][j] = '.';
                                    break;
                                } else if (map[k][j] == '#') break;
                            }
                            break;
                        case '<' :
                            for (int k = j - 1; k >= 0; k--) {
                                if (map[i][k] == '*') {
                                    map[i][k] = '.';
                                    break;
                                } else if (map[i][k] == '#') break;
                            }
                            break;
                        case '>' :
                            for (int k = j + 1; k < map[i].length; k++) {
                                if (map[i][k] == '*') {
                                    map[i][k] = '.';
                                    break;
                                } else if (map[i][k] == '#') break;
                            }
                            break;
                    }
                }
            }
        }
    }
}