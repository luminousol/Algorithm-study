package juyeon.PGS.gilbut.dataStructure;

import java.util.*;

public class P55_가사_검색 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"frodo", "front", "frost", "frozen", "frame", "kakao"},
                new String[]{"fro??", "????o", "fr???", "fro???", "pro?"}))); // 3, 2, 4, 1, 0
    }

    // 정확성 테스트 통과 / 효율성 테스트 실패 🚨🚨🚨
    private static int[] solution(String[] words, String[] queries) {
        int[] answer = new int[queries.length];
        StringBuilder sb = new StringBuilder();

        HashMap<String, Integer> map = new HashMap<>();

        for (String word : words) {
            for (int i = 1; i < word.length(); i++) {
                sb.append(word.substring(0, i));

                while (sb.toString().length() < word.length()) {
                    sb.append("?");
                }

                if (sb.toString().length() == word.length()) {
                    map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
                    sb = new StringBuilder();
                }
            }

            sb = new StringBuilder();

            for (int i = 1; i < word.length(); i++) {
                for (int j = 1; j <= word.length() - i; j++) {
                    sb.append("?");
                }

                sb.append(word.substring(word.length() - i, word.length()));

                if (sb.toString().length() == word.length()) {
                    map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
                    sb = new StringBuilder();
                }
            }
        }

        for (int i = 0; i < queries.length; i++) {
            answer[i] = map.getOrDefault(queries[i], 0);
        }

        return answer;
    }
}