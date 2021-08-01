package leetcode.prefix_sum;

/**
 * @program: first
 * @description: 线段树测试
 * @author: panhao
 * @date: 2021-07-31 21:43
 **/
public class segmentTree_test {
    static int[] nums={1,3,5,7,9,11};
    static int[] trees;
    static int max_len=100;
    public static void buildTrees(int node,int start,int end){
        int mid=(start+end)/2;
        int left_nodes=node*2+1;
        int right_nodes=node*2+2;


    }
    public static void main(String[] args) {
        trees=new int[max_len];



    }
}
