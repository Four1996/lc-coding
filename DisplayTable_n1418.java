package leetcode;

import java.util.*;

/**
 * @program: first
 * @description: 点菜展示表
 * @author: panhao
 * @date: 2021-07-06 09:05
 **/
public class DisplayTable_n1418 {
    public static List<List<String>> displayTable(List<List<String>> orders) {
        HashSet<String> foods = new HashSet<>();
        HashSet<String> idSet = new HashSet<>();
        List<Integer> idList = new ArrayList<>();
        List<String> firstRow = new ArrayList<>();
        HashMap<String, HashMap<String, Integer>> map = new HashMap<>();
        for (List<String> order : orders) {
            String foodName = order.get(2);
            String tableId = order.get(1);
            if (!idSet.contains(tableId)) {
                idList.add(Integer.valueOf(tableId));
                idSet.add(tableId);
            }
            HashMap<String, Integer> foodMap = map.getOrDefault(tableId, new HashMap<>());
            foodMap.put(foodName, foodMap.getOrDefault(foodName, 0) + 1);
            map.put(tableId, foodMap);
            if (!foods.contains(foodName)) {
                foods.add(foodName);
                firstRow.add(foodName);
            }
        }
        List<List<String>> ansList = new ArrayList<>();
        Collections.sort(firstRow);
        Collections.sort(idList);
        firstRow.add(0, "Table");
        ansList.add(firstRow);
        for (Integer tableId : idList) {
            List<String> rowList = new ArrayList<>();
            HashMap<String, Integer> foodCount = map.get(String.valueOf(tableId));
            rowList.add(String.valueOf(tableId));
            for (String s : firstRow) {
                if (s.equals("Table")) continue;
                Integer count = foodCount.getOrDefault(s, 0);
                rowList.add(String.valueOf(count));
            }
            ansList.add(rowList);
        }
        return ansList;
    }

    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        List<String> list3 = new ArrayList<>();
        List<String> list4 = new ArrayList<>();
        List<String> list5 = new ArrayList<>();
        List<String> list6 = new ArrayList<>();
        List<String> list7 = new ArrayList<>();
        List<String> list8 = new ArrayList<>();
        List<String> list9 = new ArrayList<>();
        List<String> list10 = new ArrayList<>();
        List<String> list11 = new ArrayList<>();
        List<String> list12 = new ArrayList<>();
        List<String> list13 = new ArrayList<>();
        List<String> list14 = new ArrayList<>();
        List<String> list15 = new ArrayList<>();
        List<String> list16 = new ArrayList<>();
        List<String> list17 = new ArrayList<>();
        list1.add("CWdAM");
        list1.add("10");
        list1.add(" FlzD");

        list2.add(" T");
        list2.add("17");
        list2.add("ok");

        list3.add("hai ");
        list3.add("17");
        list3.add("BlXft");

        list4.add("cTIg");
        list4.add("15");
        list4.add("MAvix");

        list5.add("jxK");
        list5.add("9");
        list5.add(" FlzD");

        list6.add("vqkCX");
        list6.add("14");
        list6.add("pLg");

        list7.add("vqkCX");
        list7.add("14");
        list7.add("pLg");

        list8.add("qwqB");
        list8.add("3");
        list8.add("yPsk");

        list9.add("YR");
        list9.add("15");
        list9.add("zG");

        list10.add("ovex");
        list10.add("11");
        list10.add("pLg");

        list11.add("zHeWJ");
        list11.add("14");
        list11.add("TdmVi");

        list12.add("L ");
        list12.add("9");
        list12.add("Ey");

        list13.add("lyS");
        list13.add("14");
        list13.add("zG");

        list14.add("vasR");
        list14.add("14");
        list14.add("ok");

        list15.add("NtfZt");
        list15.add("14");
        list15.add("yPsk");

        list16.add("IN");
        list16.add("5");
        list16.add("xau");

        list17.add("GQ");
        list17.add("5");
        list17.add("bcr");
        List<List<String>> reslist = new ArrayList<>();
        reslist.add(list1);
        reslist.add(list2);
        reslist.add(list3);
        reslist.add(list4);
        reslist.add(list5);
        reslist.add(list6);
        reslist.add(list7);
        reslist.add(list8);
        reslist.add(list9);
        reslist.add(list10);
        reslist.add(list11);
        reslist.add(list12);
        reslist.add(list13);
        reslist.add(list14);
        reslist.add(list15);
        reslist.add(list16);
        reslist.add(list17);
        System.out.println(displayTable(reslist));

    }
}
