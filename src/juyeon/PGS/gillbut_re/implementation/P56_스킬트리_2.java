package juyeon.PGS.gillbut_re.implementation;

public class P56_스킬트리_2 {
    public static void main(String[] args) {
        P56_스킬트리_2 p56 = new P56_스킬트리_2();

        System.out.println(p56.solution("CBD", new String[] {"BACDE", "CBADF", "AECB", "BDA"})); // 2
    }

    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for (String str : skill_trees) {
            str = str.replaceAll("[^" + skill + "]", "");

            if (skill.startsWith(str)) answer++;
        }

        return answer;
    }
}