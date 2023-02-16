package cc;

import java.util.Arrays;
import java.util.Stack;

//2341. 数组能形成多少数对
public class Solution {

    public int[] numberOfPairs(int[] nums) {
        Arrays.sort(nums);
        Stack<Integer> stack=new Stack<>();
        int[] result=new int[2];
        stack.push(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if(stack.isEmpty()){
                stack.push(nums[i]);
                continue;
            }
            if(stack.peek()==nums[i]){
//                如果新进的元素与栈顶元素相同，则进行出栈操作
                result[0]+=1;
                stack.pop();
            }
            else {
//                如果新进的元素与栈顶元素不同，则进行入栈操作
                stack.push(nums[i]);
            }
        }
        result[1]=stack.size();
        return result;
    }

    public static void main(String[] args) {
        Solution solution=new Solution();

        System.out.println(Arrays.toString(solution.numberOfPairs(new int[]{0})));
    }
}
