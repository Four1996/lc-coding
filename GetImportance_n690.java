package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author panhao
 * @date 2021年05月01日 8:52 上午
 */
public class GetImportance_n690 {
    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }
     int ans=0;
    public  int getImportance(List<Employee> employees,int id){
        Employee e=null;
        for (Employee i:employees){
            if (id ==i.id) e=i;
        }
        ans+=e.importance;
        List<Integer> list=e.subordinates;
        if (list!=null) dfs(employees,list);
        return ans;
    }
    void dfs(List<Employee> employees,List<Integer> list){
        for (int id:list){
            for (Employee e:employees){
                if (e.id==id){
                    ans+=e.importance;
                    if (e.subordinates!=null){
                        dfs(employees,e.subordinates);
                    }
                }
            }
        }

    }
}
