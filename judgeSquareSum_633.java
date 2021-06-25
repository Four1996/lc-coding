package leetcode;

import java.nio.file.FileAlreadyExistsException;

/**
 * @author panhao
 * @date 2021年04月28日 10:39 上午
 */
public class judgeSquareSum_633 {
    public static boolean judgeSquireSum(int c){
        if (c<2) return true;
        int u=0;
        while (u<=Math.sqrt(c)){
            int x= (int) Math.sqrt(c-u*u);
            if (x*x+u*u==c) return true;
            else{
                u++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int c=1;
        System.out.println(judgeSquireSum(c));
    }
}
