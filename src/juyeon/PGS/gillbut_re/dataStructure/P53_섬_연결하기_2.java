package juyeon.PGS.gillbut_re.dataStructure;

import java.util.Arrays;

public class P53_섬_연결하기_2 {
    public static void main(String[] args) {
        P53_섬_연결하기_2 p53 = new P53_섬_연결하기_2();

        System.out.println(p53.solution(4, new int[][] {{0, 1, 1}, {0, 2, 2}, {1, 2, 5}, {1, 3, 1}, {2, 3, 8}})); // 4
    }

    private static int[] parent;

    public int solution(int n, int[][] costs) {
        int answer = 0;

        parent = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        Arrays.sort(costs, (o1, o2) -> o1[2] - o2[2]);

        for (int[] arr : costs) {
            int x = arr[0];
            int y = arr[1];
            int cost = arr[2];

            if (find(x) != find(y)) {
                union(x, y);
                answer += cost;
            }
        }

        return answer;
    }

    private void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) parent[y] = x;
    }

    private int find(int x) {
        if (x == parent[x]) return x;
        else return parent[x] = find(parent[x]);
    }
}
