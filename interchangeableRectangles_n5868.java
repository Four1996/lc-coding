package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @program: first
 * @description:
 * @author: panhao
 * @date: 2021-09-12 10:34
 **/
public class interchangeableRectangles_n5868 {
    public static long interchangeableRectangles(int[][] rectangles) {
        HashMap<Double,Integer> map=new HashMap<>();
        long ans=0;
        for (int[] rectangle : rectangles) {
            double x=rectangle[0];
            double y=rectangle[1];
            double div=x/y;
            ans+=map.getOrDefault(div,0);
            map.put(div,map.getOrDefault(div,0)+1);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] r={
                {4,5},{7,8}
        };
        System.out.println(interchangeableRectangles(r));
    }
}
