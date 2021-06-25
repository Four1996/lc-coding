package leetcode;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
//import java.lang.Math;

public class twoSum {
    public static int[] twosum(int[] nums, int targets) {
        if (2 <= nums.length && nums.length <= Math.pow(10, 3)) {
            System.out.println("数组元素为：");
            for (int i = 0; i < nums.length; i++) {
                if(i==0){
                    System.out.print("["+nums[i]+",");
                }
                if (i!=nums.length-1&&i!=0){
                    System.out.print(nums[i]+",");
                }
                if(i== nums.length-1){
                    System.out.println(nums[i]+"]");
                }

            }
            if (-(Math.pow(10, 9)) <= targets && targets <= Math.pow(10, 9)) {
                boolean stop=false;

                for (int i = 0; i < nums.length; i++) {

                    int n = targets - nums[i];
                    int j = 0;
                    for (; j < nums.length; ) {
                        if (j == i) {
                            j++;
                        } else if (j == nums.length - 1) {
                            if (n != nums[j]&&i==nums.length-1) {
                                j = -1;
                                System.out.println("数组中没有符合目标值的元素！");
                            }
                            j++;
                        } else if (n == nums[j]) {

                            System.out.println("输出为：[" + i + ", " + j + "]");
                            stop=true;
                            break;

                        } else {
                            j++;
                        }

                    }
                    if(stop||j==-1){
                        break;
                    }
                }
            } else {
                System.out.println("请输入正确的目标值！");
            }

        } else {
            System.out.println("请输入规定范围内的数组长度！");
        }
        return nums;
    }
    //-------------------穷举方法----------------------------
    public static int[] twoSum_search(int[] nums, int targets){
        for(int i=0;i< nums.length-1;i++){
            for(int j=i;j< nums.length;j++){
                if (nums[i]+nums[j]==targets){
                    return new int[]{i,j};
                }
            }
        }
        throw new IllegalArgumentException("没找到对应元素");
    }
    //--------------------哈希表查表方法----------------------------
    public static int[] twoSum_hashmap(int[] nums, int targets){
        int len= nums.length;
        Map<Integer,Integer> hashmap=new HashMap<>(len-1);
        hashmap.put(nums[0],0);
        for (int i=1;i<len;i++){
            if (hashmap.containsValue(targets-nums[i])){
                return new int[]{i,hashmap.get(targets-nums[i])};
            }
            hashmap.put(nums[i],i);
        }

        throw new IllegalArgumentException("没有对应元素！");
    }

    public static void main(String[] args) {
        System.out.println("请输入数组长度：");
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            String arylenngth = in.readLine();
            int arraylength = Integer.valueOf(arylenngth);
            if (2 <= arraylength && arraylength <= Math.pow(10, 3)) {
                int nums[] = new int[arraylength];
                int targets;
                try {
                    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                    System.out.println("请输入数组元素：");
                    String input = br.readLine();
                    String string[] = input.split(",");
                    System.out.println("请输入目标值：");
                    String targetString = br.readLine();
                    targets = Integer.valueOf(targetString);
                    for (int i = 0; i < string.length; i++) {
                        nums[i] = Integer.valueOf(string[i]);
                    }
                    if (-Math.pow(10, 9) <= targets && targets <= Math.pow(10, 9)) {
                        int numbers[] = twosum(nums, targets);
                    } else {
                        System.out.println("请输入正确的目标值！");
                    }
                } catch (Exception exc) {
                    System.out.println(exc);
                }
            } else {
                System.out.println("请输入正确的数组长度！");
            }
        } catch (Exception exc) {
            System.out.println("错误，请重新运行！");
        }

    }
}
