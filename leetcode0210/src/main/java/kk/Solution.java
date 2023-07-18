package kk;

public class Solution {
    public boolean isRobotBounded(String instructions) {
//        困于环的条件，当机器人执行完指令后位置和朝向状态和开始一致时就可以认为机器人困于环

//        设置机器人的初始状态
        int[] robot = new int[]{0, 0};
        /**
         * 表示方向（默认为0，表示北方，1，表示东方，2表示南方，3表示西方）
         */
        int x = 0;
        for (int i = 0; i < instructions.length(); i++) {
            if ('L' == instructions.charAt(i)) {
                if (x == 0) {
                    x = 3;
                }
                else if (x == 1) {
                    x = 0;
                }
                else if (x == 2) {
                    x = 1;
                }
                else if (x == 3) {
                    x = 2;
                }
            } else if ('R' == instructions.charAt(i)) {
                if (x == 0) {
                    x = 1;
                }
                else if (x == 1) {
                    x = 2;
                }
                else if (x == 2) {
                    x = 3;
                }
                else if (x == 3) {
                    x = 0;
                }
            }
            else if('G'==instructions.charAt(i)){
                if(x==0){
                    robot[1]+=1;
                }
                if(x==1){
                    robot[0]+=1;
                }
                if(x==2){
                    robot[1]-=1;
                }
                if(x==3){
                    robot[0]-=1;
                }
            }
        }
        if((robot[0]==0&&robot[1]==0)||x!=0){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution=new Solution();

        System.out.println(solution.isRobotBounded("GLGLGGLGL"));
    }
}
