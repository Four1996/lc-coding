package leetcode.classic;

/**
 * @program: first
 * @description: 三合一，实现三个栈
 * @author: panhao
 * @date: 2021-06-23 13:59
 **/
public class TripleInOne_n2040 {
    int size;
    int[] nums;
    int[] index;
    int stackSize;
    public TripleInOne_n2040(int stackSize) {
        this.stackSize=stackSize;
        size=stackSize*3;
        nums=new int[size];
        index=new int[]{0,1,2};
    }

    public void push(int stackNum, int value) {
        int cur=index[stackNum];
        int count=(cur/3);
        if (count+1>stackSize) return;
        else{
            nums[cur]=value;
            cur+=3;
            index[stackNum]=cur;
        }
    }

    public int pop(int stackNum) {
        int idx=index[stackNum];
        if (idx<3) return -1;
        int value=nums[idx-3];
        nums[idx-3]=0;
        index[stackNum]=idx-3;
        return value;
    }

    public int peek(int stackNum) {
        int idx=index[stackNum];
        if (idx<3) return -1;
        int value=nums[idx-3];
        return value;
    }

    public boolean isEmpty(int stackNum) {
        int idx=index[stackNum];
        if (idx<3) return true;
        return false;
    }
}
