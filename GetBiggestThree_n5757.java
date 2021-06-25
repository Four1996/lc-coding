package leetcode;

import java.util.*;

/**
 * @author panhao
 * @date 2021年05月29日 10:55 下午
 */
public class GetBiggestThree_n5757 {
    public static int[] getBiggestThree(int[][] grid) {
        int[] ans = new int[3];
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int m = grid.length, n = grid[0].length;
        int max_k = Math.min((m - 3) / 2, (n - 3) / 2);
        if (m < 3 || n < 3) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (!queue.contains(grid[i][j])){
                        if (queue.size() <3) queue.add(grid[i][j]);
                        else {
                            if (grid[i][j] > queue.peek()) {
                                queue.add(grid[i][j]);
                                queue.poll();
                            }
                        }
                    }
                }
            }
        } else {
            for (int k = 0; k <= max_k; k++) {
                for (int i = k + 1; i < (m - k -1); i++) {
                    for (int j = k + 1; j < (n - k -1); j++) {
                        int sum = 0;
                        int top = i - k - 1, bow = i + k + 1;
                        int count = 0;
                        while (top <i && count <= k + 2&&bow>i) {
                            if (count == 0) {
                                sum += grid[top][j];
                                sum += grid[bow][j];
                            } else {
                                sum += grid[top][j - count] + grid[top][j + count];
                                sum += grid[bow][j - count] + grid[bow][j + count];
                            }
                            top++;
                            bow--;
                            count++;
                        }
                        sum+=grid[i][j-k-1]+grid[i][j+k+1];
                        if (!queue.contains(sum)){
                            if (queue.size() <3) queue.add(sum);
                            else{
                                if (sum>queue.peek()){
                                    queue.add(sum);
                                    queue.poll();
                                }
                            }
                        }
                    }
                }
            }
            if (queue.size()<3){
                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) {
                        if (!queue.contains(grid[i][j])){
                            if (queue.size() <3) queue.add(grid[i][j]);
                            else {
                                if (grid[i][j] > queue.peek()) {
                                    queue.add(grid[i][j]);
                                    queue.poll();
                                }
                            }
                        }

                    }
                }
            }
        }
        int index = 2;
        while (!queue.isEmpty()) {
            ans[index] = queue.poll();
            index--;
        }
        return duplicate(ans);
    }

    public static int[] duplicate(int[] nums) {
        List<Integer> list = new LinkedList<>();
        for (int num : nums) {
            if (list.size() == 0) if (num!=0) list.add(num);
            else if (num != list.get(list.size() - 1)&&num!=0) list.add(num);
        }
        int[] num = new int[list.size()];
        Object[] objects = list.toArray();
        int index = 0;
        for (Object object : objects) {
            num[index] = (Integer) object;
            index++;
        }
        return num;
    }

    public static void main(String[] args) {
//        int[][] nums={
//                {1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536,1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536,1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768},
//        {65536,1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536,1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536,1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384},
//            {32768,65536,1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536,1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536,1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192},
//                        {16384,32768,65536,1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536,1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536,1,2,4,8,16,32,64,128,256,512,1024,2048,4096},
//                        {8192,16384,32768,65536,1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536,1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536,1,2,4,8,16,32,64,128,256,512,1024,2048},
//                        {4096,8192,16384,32768,65536,1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536,1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536,1,2,4,8,16,32,64,128,256,512,1024},
//                        {2048,4096,8192,16384,32768,65536,1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536,1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536,1,2,4,8,16,32,64,128,256,512},
//                        {1024,2048,4096,8192,16384,32768,65536,1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536,1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536,1,2,4,8,16,32,64,128,256},
//                        {512,1024,2048,4096,8192,16384,32768,65536,1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536,1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536,1,2,4,8,16,32,64,128},
//        {256,512,1024,2048,4096,8192,16384,32768,65536,1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536,1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536,1,2,4,8,16,32,64},
//                        {128,256,512,1024,2048,4096,8192,16384,32768,65536,1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536,1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536,1,2,4,8,16,32},
//                        {64,128,256,512,1024,2048,4096,8192,16384,32768,65536,1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536,1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536,1,2,4,8,16},
//                        {32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536,1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536,1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536,1,2,4,8},
//                        {16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536,1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536,1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536,1,2,4},
//                        {8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536,1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536,1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536,1,2},
//                        {4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536,1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536,1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536,1},
//                        {2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536,1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536,1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536},
//                        {1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536,1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536,1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768},
//                        {65536,1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536,1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536,1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384},
//                        {32768,65536,1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536,1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536,1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192},
//                        {16384,32768,65536,1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536,1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536,1,2,4,8,16,32,64,128,256,512,1024,2048,4096},
//                        {8192,16384,32768,65536,1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536,1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536,1,2,4,8,16,32,64,128,256,512,1024,2048},
//                        {4096,8192,16384,32768,65536,1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536,1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536,1,2,4,8,16,32,64,128,256,512,1024},
//                        {2048,4096,8192,16384,32768,65536,1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536,1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536,1,2,4,8,16,32,64,128,256,512},
//                        {1024,2048,4096,8192,16384,32768,65536,1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536,1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536,1,2,4,8,16,32,64,128,256},
//                        {512,1024,2048,4096,8192,16384,32768,65536,1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536,1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536,1,2,4,8,16,32,64,128},
//                        {256,512,1024,2048,4096,8192,16384,32768,65536,1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536,1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536,1,2,4,8,16,32,64},
//                        {128,256,512,1024,2048,4096,8192,16384,32768,65536,1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536,1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536,1,2,4,8,16,32},
//                        {64,128,256,512,1024,2048,4096,8192,16384,32768,65536,1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536,1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536,1,2,4,8,16},
//                        {32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536,1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536,1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536,1,2,4,8},
//                        {16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536,1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536,1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536,1,2,4},
//                        {8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536,1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536,1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536,1,2},
//                        {4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536,1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536,1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536,1},
//                        {2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536,1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536,1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536},
//                        {1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536,1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536,1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768},
//                        {65536,1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536,1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536,1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384},
//                        {32768,65536,1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536,1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536,1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192},
//                        {16384,32768,65536,1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536,1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536,1,2,4,8,16,32,64,128,256,512,1024,2048,4096},
//                        {8192,16384,32768,65536,1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536,1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536,1,2,4,8,16,32,64,128,256,512,1024,2048},
//                        {4096,8192,16384,32768,65536,1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536,1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536,1,2,4,8,16,32,64,128,256,512,1024},
//                        {2048,4096,8192,16384,32768,65536,1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536,1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536,1,2,4,8,16,32,64,128,256,512},
//                        {1024,2048,4096,8192,16384,32768,65536,1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536,1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536,1,2,4,8,16,32,64,128,256},
//                        {512,1024,2048,4096,8192,16384,32768,65536,1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536,1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536,1,2,4,8,16,32,64,128},
//                        {256,512,1024,2048,4096,8192,16384,32768,65536,1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536,1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536,1,2,4,8,16,32,64},
//                        {128,256,512,1024,2048,4096,8192,16384,32768,65536,1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536,1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536,1,2,4,8,16,32},
//                        {64,128,256,512,1024,2048,4096,8192,16384,32768,65536,1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536,1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536,1,2,4,8,16},
//                        {32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536,1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536,1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536,1,2,4,8},
//                        {16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536,1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536,1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536,1,2,4},
//                        {8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536,1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536,1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536,1,2},
//                        {4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536,1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536,1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536,1}
//        };
        int[][] nums={{7,7,7}};
        for (int i : getBiggestThree(nums)) {
            System.out.println(i);
        }
    }
}
