package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author panhao
 * @date 2021年05月04日 4:29 下午
 */
public class GetRow_n119 {
    //倒着计算第i行的值，这样当计算第i项的时候，第i-1项仍然是第i-1行的值。
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<Integer>();
        row.add(1);
        for (int i = 1; i <= rowIndex; ++i) {
            row.add(0);
            for (int j = i; j > 0; --j) {
                row.set(j, row.get(j) + row.get(j - 1));
            }
        }
        return row;

    }

    public static void main(String[] args) {
        GetRow_n119 g=new GetRow_n119();
        System.out.println(g.getRow(5));
    }
}
