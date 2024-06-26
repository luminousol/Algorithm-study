package soli.PGS2.ch4_exhaustive_search;

import java.util.HashSet;
import java.util.Set;

public class PGS22_불량사용자 {


    public static Set<Set<String>> answer = new HashSet<>();

    public int solution(String[] user_id, String[] banned_id) {

        HashSet<String> set = new HashSet<>();
        dfs(user_id, banned_id, set, 0);

        return answer.size();
    }

    private static void dfs(String[] user_id, String[] banned_id, HashSet<String> set, int depth){

        if(depth == banned_id.length) {
            answer.add(new HashSet<>(set));
            return;
        }

        for(int i = 0 ; i < user_id.length ; i++) {
            if(user_id[i].matches(banned_id[depth].replace("*",".")) && !set.contains(user_id[i])){
                set.add(user_id[i]);
                dfs(user_id, banned_id, set, depth +1);
                set.remove(user_id[i]);
            }
        }
    }
    public static void main(String[] args) {
        PGS22_불량사용자 pgs22 = new PGS22_불량사용자();

        System.out.println("Test1" +  pgs22.solution( new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"fr*d*", "abc1**"}));
        System.out.println("Test2" +  pgs22.solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"*rodo", "*rodo", "******"}));
        System.out.println("Test3" +  pgs22.solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"fr*d*", "*rodo", "******", "******"}));
    }
}
