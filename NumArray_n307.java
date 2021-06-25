package leetcode;

import java.util.Arrays;

/**
 * @author panhao
 * @date 2021年04月15日 7:21 下午
 */
public class NumArray_n307 {
    int[] treeArray;
    int[] array;
    int lowbit(int x){
        return x&(-x);
    }
    public NumArray_n307(int[] nums) {
        int len=nums.length;
        array= Arrays.copyOfRange(nums,0,len);
        treeArray=new int[len+1];
        for (int i=1;i<treeArray.length;i++){
            add(i,nums[i-1]);
        }
    }
    void add(int x,int u){
        while (x<treeArray.length){
            treeArray[x]+=u;
            x+=lowbit(x);
        }
    }
    public int query(int n){//返回树状数组的前n项和
        int sum=0;
        while(n>0){
            sum+=treeArray[n];
            n-=lowbit(n);
        }
        return sum;
    }
    public void update(int index,int val){
        int diff=val-array[index];
        array[index]=val;
        index++;
        while(index<treeArray.length){
            treeArray[index]+=diff;
            index+=lowbit(index);
        }
    }
    public int sumRange(int left,int right){
        return query(right+1)-query(left);
    }

    public static void main(String[] args) {
        int[] nums={7,2,7,2,0};
        NumArray_n307 numArray_n303=new NumArray_n307(nums);
        numArray_n303.update(4,6);
        numArray_n303.update(0,2);
        numArray_n303.update(0,9);
        System.out.println(numArray_n303.sumRange(4,4));
        numArray_n303.update(3,8);
        System.out.println(numArray_n303.sumRange(0,4));
        numArray_n303.update(4,1);
        System.out.println(numArray_n303.sumRange(0,3));
        System.out.println(numArray_n303.sumRange(0,4));
        numArray_n303.update(0,4);
    }
}
