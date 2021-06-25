package leetcode;

import java.util.Arrays;

public class HammingWeight {
    public int nammingWeight(int n){
        int count=0;
        for (int i=0;i<32;i++){
            if ((n&(1<<i))!=0){
                    count++;
            }
        }
        return count;
    }
}
