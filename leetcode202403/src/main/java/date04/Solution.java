package date04;

import java.util.Arrays;
import java.util.Stack;

public class Solution {
    //    3069. 将元素分配到两个数组中 I
    public int[] resultArray(int[] nums) {
        Stack<Integer> s1=new Stack<>();
        Stack<Integer> s2=new Stack<>();
        int[] result=new int[nums.length];
        s1.push(nums[0]);
        s2.push(nums[1]);
        for(int i=2;i<nums.length;i++){
            if(s1.peek()>s2.peek()){
                s1.push(nums[i]);
            }else {
                s2.push(nums[i]);
            }
        }
//        合并两个栈
        int i=s1.size();
        while (!s1.empty()){
            result[i-1]=s1.pop();
            i--;
        }
        int j=result.length;
        while (!s2.empty()){
            result[j-1]=s2.pop();
            j--;
        }
        return result;
    }

//    向JSONArray中新增JSONObject
    public 
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(Arrays.toString(solution.resultArray(new int[]{5,4,3,8})));
    }
}
