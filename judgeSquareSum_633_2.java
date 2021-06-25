package leetcode;

/**
 * @author panhao
 * @date 2021年04月28日 10:39 上午
 */
public class judgeSquareSum_633_2 {
    public static boolean judgeSquireSum(int c){
        if (c<2) return true;
        int left=0,right=(int)Math.sqrt(c);
        while (left<=right){
            if ((left*left+right*right)==c) return true;
            if ((left*left+right*right)>c) right--;
            if ((left*left+right*right)<c) left++;
        }
        return false;
    }

    public static void main(String[] args) {
        int c=8;
        System.out.println(judgeSquireSum(c));
    }
}
