package leetcode.strings;

import java.util.*;

/**
 * @program: first
 * @description: 划分字母区间
 * @author: panhao
 * @date: 2021-07-09 16:45
 **/
public class PartitionLabels_n763 {
    public static List<Integer> partitionLabels(String s) {

        HashMap<Character, int[]> map = new HashMap<>();
        char[] chars = s.toCharArray();
        int len = chars.length;
        for (int i = 0; i < len; i++) {
            char c = chars[i];
            if (!map.containsKey(c)) {
                map.put(c, map.getOrDefault(c, new int[]{i, i}));
            } else {
                int[] ints = map.get(c);
                int pre = ints[0];
                map.put(c, new int[]{pre, i});
            }
        }
        int[][] nums = new int[map.size()][2];
        int idx = 0;
        for (Map.Entry<Character, int[]> entry : map.entrySet()) {
            int[] value = entry.getValue();
            nums[idx][0] = value[0];
            nums[idx][1] = value[1];
            idx++;
        }
        Arrays.sort(nums, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        List<Integer> res = new ArrayList<>();
        for (int[] num : nums) {
            if (res.isEmpty()) res.add(num[1]);
            else {
                if (num[0] < res.get(res.size() - 1) && num[1] > res.get(res.size() - 1)) {
                    res.set(res.size() - 1, num[1]);
                } else if (num[0] > res.get(res.size() - 1)) {
                    res.add(num[1]);
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        idx = 0;
        for (Integer re : res) {
            if (ans.isEmpty()) ans.add(re + 1);
            else {
                ans.add(re - res.get(idx - 1));
            }
            idx++;
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
        System.out.println(partitionLabels(s));
    }
}
