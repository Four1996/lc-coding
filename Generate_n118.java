package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author panhao
 * @date 2021年05月04日 4:11 下午
 */
public class Generate_n118 {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans=new ArrayList<>();
        for (int i=0;i<numRows;i++){
            List<Integer> list=new ArrayList<>();
            List<Integer> pre=null;
            if (i>0) {
                pre = ans.get(i - 1);
            }
            for (int j=0;j<i+1;j++){
                if (i == 0) list.add(1);
                else{
                    if (j==0||j==i) list.add(1);
                    else{
                        list.add(pre.get(j-1)+pre.get(j));
                    }
                }
            }
            ans.add(list);
        }
        return ans;
    }

    public static void main(String[] args) {
        generate(5);
    }
}
