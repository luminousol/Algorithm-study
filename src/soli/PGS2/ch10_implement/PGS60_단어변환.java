package soli.PGS2.ch10_implement;

import java.util.Arrays;

public class PGS60_단어변환 {

    public static int solution(String begin, String target, String[] words) {

        int n = words.length;
        boolean[] visited = new boolean[n];

        if(Arrays.asList(words).contains(target)) {
            return changeword(begin, target, words, visited);
        }

        return 0;
    }

    public static int changeword(String begin, String target, String[] words, boolean[] visited){
        int targetchar = 0;

        for(int i = 0 ; i < begin.length() ; i++) {
            if(begin.charAt(i) != target.charAt(i)) {
                targetchar++;
            }
        }

        if(targetchar == 1) {
            return 1;
        }

        for(int i = 0 ;  i < words.length ; i++) {
            if(!visited[i] && check(begin, words[i])) {
                visited[i] = true;
                int answer = changeword(words[i], target, words, visited);
                if(answer > 0) {
                    return ++answer;
                }
                visited[i] = false;
            }
        }
        return 0;
    }

    public static boolean check(String begin, String word) {
        int charcount = 0;

        for(int i = 0 ; i < begin.length() ; i++) {
            if(begin.charAt(i) != word.charAt(i)) {
                charcount++;
                if(charcount > 1) {
                    return false;
                }
            }
        }
        return charcount == 1;
    }


    public static void main(String[] args) {
        System.out.println(solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"})); // 4
        System.out.println(solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log"})); // 0
    }


}
