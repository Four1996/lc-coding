package leetcode;

import java.util.*;

/**
 * @program: first
 * @description:
 * @author: panhao
 * @date: 2021-09-05 10:38
 **/
public class numberOfWeakCharacters_n5864 {
    public static int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                } else {
                    return o1[1] - o2[1];
                }
            }
        });
        int ans = 0;
        HashMap<Integer,Integer> attackMap =new HashMap<>();
        HashMap<Integer,Integer> defenceMap =new HashMap<>();
        TreeSet<Integer> attackSet =new TreeSet<>();
        TreeSet<Integer> defenceSet=new TreeSet<>();
        for (int[] ints : properties) {
            if (attackMap.containsKey(ints[0])) {
                if (attackMap.get(ints[0]) < ints[1]) {
                    attackMap.put(ints[0], ints[1]);
                }
            } else {
                attackMap.put(ints[0], ints[1]);
                attackSet.add(ints[0]);
            }
            if (defenceMap.containsKey(ints[1])) {
                if (defenceMap.get(ints[1]) < ints[0]) {
                    defenceMap.put(ints[1], ints[0]);
                }
            } else {
                defenceMap.put(ints[1], ints[0]);
                defenceSet.add(ints[1]);
            }

        }
        for (int[] property : properties) {
            Integer ahigher = attackSet.higher(property[0]);
            Integer dhigher = defenceSet.higher(property[1]);
            while (ahigher != null && dhigher != null) {
                Integer defense = attackMap.get(ahigher);
                Integer attack = defenceMap.get(dhigher);
                if (defense > property[1] || attack > property[0]) {
                    ans++;
                    break;
                } else {
                    ahigher = attackSet.higher(ahigher);
                    dhigher = defenceSet.higher(dhigher);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] nums={
                {5,5},{6,3},{3,6}
        };
        System.out.println(numberOfWeakCharacters(nums));
    }
}
