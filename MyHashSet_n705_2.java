package leetcode;

/**
 * @author panhao
 * @date 2021年04月10日 9:41 下午
 */
public class MyHashSet_n705_2 {
    int[] bucket = new int[40000];

    public MyHashSet_n705_2() {
    }

    public void add(int key) {
        int bucketindex = key / 32;
        int bitindex = key % 32;
        setval(bucketindex, bitindex);
    }

    public void remove(int key) {
        int bucketindex = key / 32;
        int bitindex = key % 32;
        removeval(bucketindex, bitindex);
    }

    public boolean contains(int key) {
        int bucketindex = key / 32;
        int bitindex = key % 32;
        int target = (bucket[bucketindex] >> bitindex) & 1;
        return target == 1;
    }

    void setval(int bucketindex, int bitindex) {
        if (((bucket[bucketindex] >> bitindex) & 1) == 0) {
            int u = 1 << bitindex | bucket[bucketindex];
            bucket[bucketindex] = u;
        }
    }

    void removeval(int bucketindex, int bitindex) {
        if (((bucket[bucketindex] >> bitindex) & 1) == 1) {
            int u = bucket[bucketindex] & (~(1 << bitindex));
            bucket[bucketindex] = u;
        }
    }
}
