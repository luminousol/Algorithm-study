package soli.PGS2.ch10_implement;


public class PGS58_타겟넘버 {

    int answer = 0;

    public int solution(int[] numbers, int target){

        dfs(numbers, target, 0,0);
        return answer;
    }

    private void dfs(int[] numbers, int target, int depth, int sum) {
        if(depth == numbers.length) {
            if(sum == target) answer++;
        } else {
            dfs(numbers, target, depth + 1, sum + numbers[depth]);
            dfs(numbers, target, depth + 1, sum - numbers[depth]);
        }
    }

    public static void main(String[] args) {

        PGS58_타겟넘버 pgs58_타겟넘버 = new PGS58_타겟넘버();

        System.out.println(pgs58_타겟넘버.solution(new int[]{1,1,1,1,1}, 3));
        System.out.println(pgs58_타겟넘버.solution(new int[]{4,1,2,1}, 4));

    }
}
