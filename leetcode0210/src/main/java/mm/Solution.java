package mm;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        String[] aAlice = arriveAlice.split("-");
        String[] lAlice = leaveAlice.split("-");
        String[] aBob = arriveBob.split("-");
        String[] lBob = leaveBob.split("-");
        int[] one=new int[31];
        int[] two=new int[28];
        int[] three=new int[31];
        int[] four=new int[30];
        int[] five=new int[31];
        int[] six=new int[30];
        int[] seven=new int[31];
        int[] eight=new int[31];
        int[] nine=new int[30];
        int[] ten=new int[31];
        int[] eleven=new int[30];
        int[] twelve=new int[31];
        List<int[]> result=new ArrayList<>();
        result.add(one);
        result.add(two);
        result.add(three);
        result.add(four);
        result.add(five);
        result.add(six);
        result.add(seven);
        result.add(eight);
        result.add(nine);
        result.add(ten);
        result.add(eleven);
        result.add(twelve);
        List<int[]> result1 = addList(result, aAlice, lAlice);
        List<int[]> result2 = addList(result1, aBob, lBob);
        return 1;
    }

    public List<int[]> addList(List<int[]> result,String[] arrive,String[] leave){
        for (int i = Integer.parseInt(arrive[0]); i < Integer.parseInt(leave[0]); i++) {
            for (int j=(i == Integer.parseInt(arrive[0]))?Integer.parseInt(arrive[1]):0; j <Integer.parseInt(leave[1]) ; j++) {

            }
        }
        return null;
    }

}
