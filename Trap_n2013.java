package leetcode;

/**
 * @author panhao
 * @date 2021年04月02日 4:16 下午
 */
public class Trap_n2013 {
    static int index_left = 0, index_right = -1;
    static int left, right = 0;//用来计算差值面积的长
    static int maxtag = 0;

    public static int trap(int[] height) {
        int area = 0;
        if (height.length < 3) return 0;
        int max = 0, index_right = height.length - 1;
        for (int i = 0; i < height.length; i++) {
            if (max <= height[i]){
                max = height[i];maxtag = i;
            }
        }
        area = max * height.length;//先算出总面积

        //--------------------------------------------------------------
        right = index_right = maxtag; //向左
        while (index_left != index_right) {
            int minmax = find_max_right(height, index_left, index_right);
            int differ_height = max - minmax;
            max = minmax;
            area -= countarea(differ_height, right);
        }
        //--------------------------------------------------------------

        left = index_left = maxtag;//向右
        max = height[maxtag];
        index_right = height.length;
        while (index_left != index_right) {
            int minmax = find_max_left(height, index_left, index_right);
            int diff_height = max - minmax;
            max = minmax;
            area -= countarea(left, diff_height);
        }

        return area;
    }

    static int find_max_right(int[] height, int ll, int lr) {
        int compare = 0;
        for (int i = ll; i < lr; i++) {
            if (compare < height[i]) {
                compare = height[i];
                index_right = i;
            }
        }
        return compare;
    }

    static int find_max_left(int[] height, int ll, int lr) {
        int compare = 0;
        for (int i = ll; i < lr; i++) {
            if (compare < height[i]) {
                compare = height[i];
                index_left = i;
            }
        }
        return compare;
    }

    static int countarea(int height, int weight) {
        return height * weight;
    }

    public static void main(String[] args) {
        int[] height={0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height));
    }
}
