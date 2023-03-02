package hh;

//877. 石子游戏
public class Solution {
    public boolean stoneGame(int[] piles) {
        int sumAlice = 0;
        int sumBob = 0;
        for (int left = 0, right = piles.length - 1, i = 0; left <= right; i++) {
            if (i % 2 == 0) {
//                为Alice
                if(piles[left]>piles[right]){
                    sumAlice += piles[left];
                    left++;
                }else {
                    sumAlice += piles[right];
                    right--;
                }

            } else {
                if(piles[left]>piles[right]){
                    sumBob += piles[left];
                    left++;
                }else {
                    sumBob += piles[right];
                    right--;
                }
            }
        }

        return sumAlice>sumBob;
    }
}
