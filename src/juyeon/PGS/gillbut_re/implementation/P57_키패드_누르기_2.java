package juyeon.PGS.gillbut_re.implementation;

import java.util.*;

public class P57_키패드_누르기_2 {
    public static void main(String[] args) {
        P57_키패드_누르기_2 p57 = new P57_키패드_누르기_2();

        System.out.println(p57.solution(new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}, "right")); // "LRLLLRLLRRL"
    }

    HashMap<Integer, int[]> keypad;

    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();

        keypad = new HashMap<>();

        keypad.put(1, new int[]{0, 0});
        keypad.put(2, new int[]{0, 1});
        keypad.put(3, new int[]{0, 2});
        keypad.put(4, new int[]{1, 0});
        keypad.put(5, new int[]{1, 1});
        keypad.put(6, new int[]{1, 2});
        keypad.put(7, new int[]{2, 0});
        keypad.put(8, new int[]{2, 1});
        keypad.put(9, new int[]{2, 2});
        keypad.put(0, new int[]{3, 1});

        int[] left = new int[]{3, 0};
        int[] right = new int[]{3, 2};

        int ld = 0;
        int rd = 0;

        for (int num : numbers) {
            if (num == 1 || num == 4 || num == 7) {
                left = keypad.get(num);
                sb.append("L");
            } else if (num == 3 || num == 6 || num == 9) {
                right = keypad.get(num);
                sb.append("R");
            } else {
                ld = getDistance(left, num);
                rd = getDistance(right, num);

                if (ld == rd) {
                    if (hand.equals("left")) {
                        sb.append("L");
                        left = keypad.get(num);
                    } else {
                        sb.append("R");
                        right = keypad.get(num);
                    }
                } else {
                    if (ld > rd) {
                        sb.append("R");
                        right = keypad.get(num);
                    } else {
                        sb.append("L");
                        left = keypad.get(num);
                    }
                }
            }
        }

        return sb.toString();
    }

    private int getDistance(int[] hand, int n) {
        int[] temp = keypad.get(n);

        return Math.abs(hand[0] - temp[0]) + Math.abs(hand[1] - temp[1]);
    }
}
