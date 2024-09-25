package juyeon.PGS.gillbut_re.implementation;

public class P59_네트워크_2 {
    public static void main(String[] args) {
        P59_네트워크_2 p59 = new P59_네트워크_2();

        System.out.println(p59.solution(3, new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}})); // 2
        System.out.println(p59.solution(3, new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}})); // 1
    }

    private boolean[] visited;

    public int solution(int n, int[][] computers) {
        int count = 0;
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                count++;
                DFS(i, computers);
            }
        }

        return count;
    }

    private void DFS(int i, int[][] computers) {
        visited[i] = true;

        for (int j = 0; j < computers.length; j++) {
            if (!visited[j] && computers[i][j] == 1) DFS(j, computers);
        }
    }
}
