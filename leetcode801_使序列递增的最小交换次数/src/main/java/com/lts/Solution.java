package com.lts;

public class Solution {
    public int minSwap(int[] nums1, int[] nums2) {
//        当前位置交换时的最小交换数
        int[] change=new int[nums1.length];
        change[0]=1;

//        当前位置不交换时的最小交换数
        int[] unchange=new int[nums2.length];

        for (int i = 1; i < nums1.length; i++) {
            if(nums1[i]>nums1[i-1]&&nums2[i]>nums2[i-1]){
                if(nums1[i]>nums2[i-1]&&nums2[i]>nums1[i-1]){
                    change[i]=Math.min(change[i-1],unchange[i-1])+1;
                    unchange[i]=Math.min(change[i-1],unchange[i-1]);
                }
                else {
                    change[i]=change[i-1]+1;
                    unchange[i]=unchange[i-1];
                }
            }
            else {
                change[i]= unchange[i-1]+1;
                unchange[i]=change[i-1];
            }
        }

        return Math.min(change[nums1.length-1],unchange[nums1.length-1]);
    }

    public static void main(String[] args) {
        Solution s=new Solution();


        System.out.println(s.minSwap(new int[]{1, 3, 5, 4}, new int[]{1, 2, 3, 7}));
    }
}
