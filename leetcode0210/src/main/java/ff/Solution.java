package ff;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//2347. 最好的扑克手牌
public class Solution {
    public String bestHand(int[] ranks, char[] suits) {
//        先判断是否时同花
        String result="Flush";
        int max=0;
        int num=0;
        int temp=ranks[0];
        Arrays.sort(ranks);
        for (int i = 0; i < suits.length; i++) {
            if(suits[i]!=suits[0]){
                result="Three of a Kind";
            }
            if(ranks[i]==temp){
                num++;
                max=Math.max(max,num);
            }
            else {
                temp=ranks[i];
                num=1;
            }
        }
        if("Three of a Kind".equals(result)){
            if(max>=3){
                return result;
            }
            else if(max==2){
                return "Pair";
            }
            else{
                return "High Card";
            }
        }
        else {
            return result;
        }
    }

    public static void main(String[] args) {
        Solution solution=new Solution();

        System.out.println(solution.bestHand(new int[]{4,4,2,4,4}, new char[]{'d', 'a', 'a', 'b', 'c'}));
    }
}
