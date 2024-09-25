package juyeon.PGS.gillbut_re.implementation;

import java.util.*;

public class P60_단어_변환_2 {
    public static void main(String[] args) {
        P60_단어_변환_2 p60 = new P60_단어_변환_2();

        System.out.println(p60.solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"})); // 4
        System.out.println(p60.solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log"})); // 0
    }

    boolean[] visited;
    int answer = Integer.MAX_VALUE;

    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];

        Set<String> set = new HashSet<>(Arrays.asList(words));

        if (!set.contains(target)) return 0;

        DFS(begin, target, words, 0);

        return answer == Integer.MAX_VALUE ? 0 : answer;
    }

    private void DFS(String current, String target, String[] words, int count) {
        if (current.equals(target)) {
            answer = Math.min(answer, count);
            return;
        }

        for (int i = 0; i < words.length; i++) {
            if (!visited[i] && canTransform(current, words[i])) {
                visited[i] = true;
                DFS(words[i], target, words, count + 1);

                visited[i] = false;
            }
        }
    }

    private boolean canTransform(String from, String to) {
        int count = 0;

        for (int i = 0; i < from.length(); i++) {
            if (from.charAt(i) != to.charAt(i)) {
                count++;
                if (count > 1) return false;
            }
        }

        return count == 1;
    }
}