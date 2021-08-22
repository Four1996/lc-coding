package leetcode.math;

/**
 * @program: first
 * @description: 逃脱阻碍着
 * @author: panhao
 * @date: 2021-08-22 09:58
 **/
public class EscapeGhosts_n789 {
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int distance = manDistance(0, target[0], 0, target[1]);
        for (int[] ghost : ghosts) {
            int dis = manDistance(ghost[0], target[0], ghost[1], target[1]);
            if (dis < distance) {
                return false;
            }
        }
        return true;
    }
    public int manDistance(int x1,int y1,int x2,int y2){
        return Math.abs(x1-x2)+Math.abs(y1-y2);
    }
}
