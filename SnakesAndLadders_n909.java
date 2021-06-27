package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Queue;

/**
 * @program: first
 * @description: 蛇梯棋
 * @author: panhao
 * @date: 2021-06-27 09:47
 **/
public class SnakesAndLadders_n909 {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int[] nums = converse(board, n);
        int step = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        HashSet<Integer> set=new HashSet<>();
        deque.addFirst(1);
        while (!deque.isEmpty()) {
            int size=deque.size();
            for (int k=0;k<size;k++){
                Integer cur = deque.pollLast();
                if (cur==n*n) return step;
                if (!set.contains(cur)){
                    bfs(deque,cur,nums);
                    set.add(cur);
                }
            }
            step++;
        }
        return -1;
    }
    public void bfs(Deque<Integer> deque,int cur,int[] nums){
        for (int i=0;i<6&&(cur+i+1)<nums.length;i++){
            //如果走到传送阵，就进行传送
            if (nums[cur+i+1]!=-1){
                deque.addFirst(nums[cur+i+1]);
            }else{
                deque.addFirst(cur+i+1);
            }
        }
    }
    public int[] converse(int[][] board,int n){
        int[] nums=new int[n*n+1];
        int index=0;
        for (int i=n-1;i>=0;i--){
            int row=n-i;
            if (row%2==0){
                for (int j=n-1;j>=0;j--){
                    nums[++index]=board[i][j];
                }
            }else{
                for (int j=0;j<n;j++){
                    nums[++index]=board[i][j];
                }
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[][] nums={
                {1,1,-1},
                {1,1,1},
                {-1,1,1}
        };
        System.out.println(new SnakesAndLadders_n909().snakesAndLadders(nums));

    }

}
