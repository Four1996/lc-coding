package leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//public class NestedIterator implements Iterator<Integer> {
////    public List<Integer> list;
////    public Iterator<Integer> cur;
////
////    public NestedIterator(List<NestedInteger> nestedList) {
////        list = new ArrayList<Integer>();
////        dfs(nestedList);
////        cur = list.iterator();
////    }
////
////    @Override
////    public Integer next() {
////        return cur.next();
////    }
////
////    @Override
////    public boolean hasNext() {
////        return cur.hasNext();
////    }
////
////    public void dfs(List<NestedInteger> nestedList) {
////        for (NestedInteger nest : nestedList) {
////            if (nest.isInteger()) {
////                list.add(nest.getInteger());
////            } else {
////                dfs(nest.getList());
////            }
////        }
////    }
//}
