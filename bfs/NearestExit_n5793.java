package leetcode.bfs;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @program: first
 * @description:
 * @author: panhao
 * @date: 2021-07-10 22:44
 **/
public class NearestExit_n5793 {
    public static int nearestExit(char[][] maze, int[] entrance) {
        int row = maze.length, col = maze[0].length;
        Deque<int[]> deque = new ArrayDeque<>();
        boolean[][] vis = new boolean[row][col];
        int sx = entrance[0];
        int sy = entrance[1];
        deque.addLast(entrance);
        vis[sx][sy] = true;
        int step = 0;
        int[][] dir = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
        while (!deque.isEmpty()) {
            int size = deque.size();

            for (int i = 0; i < size; i++) {
                int[] ints = deque.pollFirst();
                int x = ints[0];
                int y = ints[1];

                if ((x == 0 || x == row - 1 || y == 0 || y == col - 1) && !(x == sx && y == sy)) {
                    return step;
                } else {
                    for (int[] dirs : dir) {
                        int xx = dirs[0] + x;
                        int yy = dirs[1] + y;
                        if (xx >= 0 && xx < row && yy >= 0 && yy < col && maze[xx][yy] == '.' && !vis[xx][yy]) {
                            deque.addLast(new int[]{xx, yy});
                            vis[xx][yy] = true;
                        }
                    }
                }
            }
            step++;
        }
        return -1;
    }

    public static void main(String[] args) {
        char[][] maze={
                {'+','+','+'},{'.','.','.'},{'+','+','+'}
        };
        System.out.println(nearestExit(maze,new int[]{1,0}));
    }
}
