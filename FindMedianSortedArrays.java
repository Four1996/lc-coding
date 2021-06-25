package leetcode;

public class FindMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = nums1.length, l2 = nums2.length;
        double med = 0;
        int l=l1+l2;
        if(l%2==0){

        }













//        if (l1 == 0 && l2 != 0) {
//            if (l2 % 2 == 0) {
//                int mid = l2 / 2;
//                med = (nums2[mid] + nums2[mid - 1]) / 2;
//            } else {
//                int mid = l2 / 2;
//                med = nums2[mid];
//            }
//
//        } else if (l2 == 0 && l1 != 0) {
//            if (l1 % 2 == 0) {
//                int mid = l1 / 2;
//                med = (nums1[mid] + nums1[mid - 1]) / 2;
//            } else {
//                int mid = l1 / 2;
//                med = nums1[mid];
//            }
//
//        } else {
//            int l = l1 >= l2 ? l2 : l1;
//            if ((l1 + l2) % 2 == 0) {
//                int mid = (l1 + l2) / 2;
//                int i = 0, j = 0;
//                boolean tagi=false,tagj=false;
//                for (int count=0; count<mid;count++ ) {
//                    if (tagj==false){
//                        if (nums1[i] >= nums2[j]) {
//                            med = nums1[i];
//                            if (j<l2-1){
//                                j++;
//                            }else{
//                                tagj=true;
//                            }
//
//                        }else {
//                            med = nums2[j];
//                            if (i<l1-1){
//                                i++;
//                            }else{
//                                tagi=false;
//                            }
//                        }
//                    }else{
//                        med=nums1[i];
//                        i++;
//                    }
//
//
//                    if (count == mid - 1) {
//                        if (i+1<l1&&j+1<l2)
//                        i++;
//                        j++;
//                        med = (nums1[i] + nums2[j]) / 2;
//                        break;
//                    }
//                }
//
//            } else {
//                int mid = (l1 + l2) / 2;
//            }
////            int l=l1>=l2?l2:l1;
////            int[] newAry=new int[l];
////            for (int i=0;i<l;i++){
////                newAry[i]=nums1[i]>nums2[i]?nums1[i]:nums2[i];
////            }
//
//
//        }
        return med;
    }
    public int getKthElement(int[]nums1,int[] nums2,int k){
        int l1=nums1.length,l2=nums2.length;
        int index1=0,index2=0;
        int pivot1=nums1[k/2-1],pivot2=nums2[k/2-1];
        while (true){
            if (index1==l1){

            }
        }
    }

}
