package com.lts;

import java.util.Arrays;

public class Solution {

    public int maximumSwap(int num) {
        // 查看当前的最高位是否是当前数字中最大的，如果不是，表示当前位需要被调换，再向后遍历，查看是否能找到第二大的数字


        // 将num拆为字符数组

        int[] max=new int[(num+"").length()];

//        原序的nums
        int[] res=new int[(num+"").length()];

        int temp=num;

        int sum=0;
        int m=max.length-1;
        for (int i = 0; i < max.length; i++) {

            max[i]=temp%10;
            res[m]=temp%10;
            m--;
            temp=temp/10;
        }


//       升序排序的nums
        Arrays.sort(max);
        int flag=0;
        int j=res.length-1;
//        遍历nums，查看是否符合最大到最小的排序模式
        for (int i = 0 ; i < res.length; i++) {
           if(res[i]<max[j]){
                flag=1;
//                如果原序小于降序的nums，说明第i位需要被调换，应从后向前调换
                for (int k = res.length-1; k >=0; k--) {
//                    当从后向前遍历的数字满足与当前降序的max相同的时候，说明第k位为另外的一个调换位
                    if(k<i){
                        break;
                    }
                    if(res[k]==max[j]){
//                        将res对应的数组位进行调换
                        int remp=res[i];
                        res[i]=res[k];
                        res[k]=remp;
                        break;
                    }

                }
            }
            if(flag==1){
                break;
            }else {
                j--;
            }


        }

//        将res转换为int数值
        for (int i = 0; i < res.length; i++) {
            sum=sum*10+res[i];
        }
        return sum;

    }

    public static void main(String[] args) {
        Solution s=new Solution();

        System.out.println(s.maximumSwap(9973));
    }
}
