package leetcode.dfs;

import java.net.Inet4Address;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @program: first
 * @description: 被围绕的区域
 * @author: panhao
 * @date: 2021-07-10 17:15
 **/
public class Solve_n130 {
    boolean[][] vis;
    boolean tag=false;
    Deque<int[]> deque;
    public void solve(char[][] board) {
        int row = board.length, col = board[0].length;
        vis=new boolean[row][col];
        deque =new ArrayDeque<>();

        for (int i=0;i<row;i++){
            for (int j=0;j<col;j++){
                if (!vis[i][j]&&board[i][j]=='O'){
                    dfs(board,i,j);
                    if (!tag) {
                        while (!deque.isEmpty()){
                            int[] ints = deque.pollFirst();
                            board[ints[0]][ints[1]]='X';
                        }
                    }
                    deque.clear();
                    tag=false;
                }
            }
        }
    }
    void dfs(char[][] board,int r,int c){
        int row = board.length, col = board[0].length;
        if (r<0||c<0||r>=row||c>=col||vis[r][c]||board[r][c]=='X') return;
        vis[r][c]=true;
        if (r==0||c==0||r==row-1||c==col-1) tag=true;
        deque.addLast(new int[]{r,c});
        dfs(board,r+1,c);
        dfs(board,r,c+1);
        dfs(board,r-1,c);
        dfs(board,r,c-1);
    }

    public static void main(String[] args) {
        char[][] board={
                {'O','X','O'},{'X','O','X'},{'O','X','O'}
        };
        Solve_n130 s=new Solve_n130();
        s.solve(board);
    }
}
