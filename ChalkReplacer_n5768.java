package leetcode;

/**
 * @author panhao
 * @date 2021年06月12日 10:38 下午
 */
public class ChalkReplacer_n5768 {
    public static int chalkReplacer(int[] chalk, int k) {
        int len=chalk.length;
        long sum=0;
        for (int num : chalk) {
            sum+=num;
        }
        k= (int) (k%sum);
        int i=0;
        for (;i<len;i++){
            if (k==0) break;
            else{
                int val=chalk[i];
                k-=val;
                if (k<0) break;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        int[] chalk={22,25,39,3,45,45,12,17,32,9};
        int[] chalk1={5,1,5};
        int[] chalk2={3,4,1,2};
        int[] chalk3={3,4,1,2};
        System.out.println(chalkReplacer(chalk2, 25));
    }
}
