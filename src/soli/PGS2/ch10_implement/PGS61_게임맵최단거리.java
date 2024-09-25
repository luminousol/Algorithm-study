package soli.PGS2.ch10_implement;


import java.util.LinkedList;
import java.util.Queue;

public class PGS61_게임맵최단거리 {

    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    boolean[][] visited;

    public int solution(int[][] maps) {

        int n = maps.length;
        int m = maps[0].length;

        visited = new boolean[n][m];

        return bfs(maps, 0, 0);
    }

    public int bfs(int[][] maps, int x, int y) {

        int n = maps.length;
        int m = maps[0].length;


        Queue<int[]> Q = new LinkedList<>();
        Q.add(new int[]{x, y, 1});
        visited[x][y] = true;

        while(!Q.isEmpty()) {
            int[] current = Q.poll();
            int cx = current[0];
            int cy = current[1];
            int count = current[2];

            if (cx == n - 1 && cy == m - 1) return count;

            for(int i = 0 ; i < 4 ; i++) {
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];


                if(nx >= 0 && nx < n && ny >= 0 && ny < m && maps[nx][ny] == 1 && !visited[nx][ny]) {
                    visited[nx][ny] = true;

                    Q.add(new int[]{nx, ny, count+1});
                }
            }

        }
        return -1;

    }
}
