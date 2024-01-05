import java.util.*;

class Solution {

    boolean[][] visited;

    int[] dx = new int[]{-1, 1, 0, 0};
    int[] dy = new int[]{0, 0, -1, 1};

    public int[] solution(String[] maps) {
        int[] answer;
        int n = maps.length;
        int m = maps[0].length();

        visited = new boolean[n][m];
        List<Integer> li = new ArrayList<>();

        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] split = maps[i].split("");
            int j = 0;
            for (String s : split) {
                if (s.equals("X")) map[i][j] = -1;
                else map[i][j] = Integer.valueOf(s);
                j++;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j] || map[i][j] == -1) continue;

                int day = bfs(i, j, map);
                li.add(day);
            }
        }
        if (li.size() == 0) li.add(-1);
        answer = li.stream().sorted().mapToInt(i -> i).toArray();

        return answer;
    }

    public int bfs(int y, int x, int[][] map) {

        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{y, x});
        int day = 0;

        while (!que.isEmpty()) {
            int[] pos = que.poll();
            if (visited[pos[0]][pos[1]]) continue;

            visited[pos[0]][pos[1]] = true;
            day += map[pos[0]][pos[1]];

            for (int i = 0; i < 4; i++) {
                int ny = dy[i] + pos[0];
                int nx = dx[i] + pos[1];

                if (ny < 0 || nx < 0 || ny >= map.length || nx >= map[0].length) continue;
                if (map[ny][nx] == -1 || visited[ny][nx]) continue;

                que.add(new int[]{ny, nx});
            }
        }
        return day;
    }
}