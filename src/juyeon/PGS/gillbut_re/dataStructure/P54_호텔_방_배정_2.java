package juyeon.PGS.gillbut_re.dataStructure;

import java.util.*;

public class P54_호텔_방_배정_2 {
    public static void main(String[] args) {
        P54_호텔_방_배정_2 p54 = new P54_호텔_방_배정_2();

        System.out.println(Arrays.toString(p54.solution(10, new long[]{1, 3, 4, 1, 3, 1}))); // 1, 3, 4, 2, 5, 6
    }

    private static HashMap<Long, Long> map;

    public long[] solution(long k, long[] room_number) {
        long[] answer = new long[room_number.length];

        map = new HashMap<>();

        for (int i = 0; i < room_number.length; i++) {
            answer[i] = findRoom(room_number[i]);
        }

        return answer;
    }

    private long findRoom(long n) {
        if (!map.containsKey(n)) {
            map.put(n, n + 1);
            return n;
        }

        long num = findRoom(map.get(n));
        map.put(n, num);
        return num;
    }
}
