package juyeon.PGS.gillbut_re.implementation;

import java.util.*;

public class P61_게임_맵_최단거리_3 {
    public static void main(String[] args) {
        P61_게임_맵_최단거리_3 p61 = new P61_게임_맵_최단거리_3();

        System.out.println(p61.solution(new int[][]{{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}})); // 11
        System.out.println(p61.solution(new int[][]{{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 0}, {0, 0, 0, 0, 1}})); // -1
    }

    int n, m;
    boolean[][] visited;

    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;

        visited = new boolean[n + 1][m + 1];

        return BFS(1, 1, maps);
    }

    private int BFS(int x, int y, int[][] maps) {
        Queue<int[]> q = new LinkedList<>();

        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        q.add(new int[]{x, y, 1});
        visited[x][y] = true;

        while (!q.isEmpty()) {
            int[] point = q.poll();

            if (point[0] == n && point[1] == m) return point[2];

            for (int i = 0; i < 4; i++) {
                int nx = point[0] + dx[i];
                int ny = point[1] + dy[i];

                if (nx >= 1 && ny >= 1 && nx <= n && ny <= m && maps[nx - 1][ny - 1] == 1 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny, point[2] + 1});
                }

            }
        }

        return -1;
    }
}