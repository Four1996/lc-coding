package leetcode.classic;

/**
 * @program: first
 * @description: 整数转换
 * @author: panhao
 * @date: 2021-07-05 16:58
 **/
public class ConvertInteger_n2081 {
    public int convertInteger(int A, int B) {
        int count=0;
        for (int i=31;i>=0;i--){
            int a=(A>>i)&1;
            int b=(B>>i)&1;
            if (a!=b) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new ConvertInteger_n2081().convertInteger(29,15));
    }
}
