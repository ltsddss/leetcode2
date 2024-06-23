package date28;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public int addedInteger(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int x=nums2[0]-nums1[0];
        for (int i = 0; i < nums1.length; i++) {
            if(nums1[i]+x!=nums2[i]){
                return -1;
            }
        }
        return x;
    }

    public int minimumAddedInteger(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
//        数组转list
        List<Integer> list = new ArrayList<>();
        for (int i : nums1) {
            list.add(i);
        }
        int min=Integer.MAX_VALUE;
        for (int i = 0; i < nums1.length-1; i++) {
            for (int j = i+1; j < nums1.length; j++) {
                List<Integer> temp=new ArrayList<>();
                temp.addAll(list);
                min=Math.min(min,addedInteger1(temp,nums2,i,j));
            }
        }
        return min;
    }
    public int addedInteger1(List<Integer> nums1, int[] nums2,int m,int n) {
        nums1.remove(m);
        nums1.remove(n-1);
        int x=nums2[0]-nums1.get(0);
        for (int i = 0; i < nums1.size(); i++) {
            if(nums1.get(i)+x!=nums2[i]){
                return Integer.MAX_VALUE;
            }
        }
        return x;
    }

    public static void main(String[] args) {
        int[] nums1={3,5,5,3};
        int[] nums2={7,7};
        Solution solution=new Solution();
        System.out.println(solution.minimumAddedInteger(nums1, nums2));
    }
}
