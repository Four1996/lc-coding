package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * @program: first
 * @description:皇位继承顺序
 * @author: panhao
 * @date: 2021-06-20 09:21
 **/
public class ThroneInheritance_n1600 {
    HashMap<String,List<String>> map;
    HashSet<String> set;
    String king;
    public ThroneInheritance_n1600(String kingname) {
        map=new HashMap<>();
        set=new HashSet<>();
        king=kingname;
    }
    public void birth(String parentName, String childName) {
        List<String> childrenList= map.getOrDefault(parentName, new ArrayList<String>());
        childrenList.add(childName);
        map.put(parentName,childrenList);
    }

    public void death(String name) {
        set.add(name);
    }

    public List<String> getInheritanceOrder() {
        List<String> ans=new ArrayList<>();
        preorder(ans,king);
        return ans;
    }
    private void preorder(List<String> ans,String name){
        if (!set.contains(name)){
            ans.add(name);
        }
        List<String> children = map.getOrDefault(name, new ArrayList<>());
        for (String child : children) {
            preorder(ans,child);
        }
    }
}
