package juyeon.PGS.gillbut_re.implementation;

public class P58_타겟_넘버_2 {
    public static void main(String[] args) {
        P58_타겟_넘버_2 p58 = new P58_타겟_넘버_2();

        System.out.println(p58.solution(new int[]{1, 1, 1, 1, 1}, 3)); // 5
//        System.out.println(p58.solution(new int[]{4, 1, 2, 1}, 4)); // 2
    }

    int count = 0;

    public int solution(int[] numbers, int target) {
        DFS(0, target, numbers, 0);

        return count;
    }

    private void DFS(int value, int target, int[] numbers, int idx) {
        int len = numbers.length;

        if (idx == len) {
            if (value == target) count++;
        } else {
            DFS(value + numbers[idx], target, numbers, idx + 1);
            DFS(value - numbers[idx], target, numbers, idx + 1);
        }
    }
}
