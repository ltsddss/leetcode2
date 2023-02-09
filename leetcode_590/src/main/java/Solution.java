import java.util.*;


public class Solution {
    /**
     * 过滤内容中出现的QQ号
     * @param content string字符串 待过滤内容
     * @return string字符串
     */
    public String filterContent (String content) {
        // write code here
        //滑动窗口
        int count=1;

        List<String> list=new ArrayList<>();
        for(int i=0;i<content.length()-5;i++){
            //如果当前的字母为偶数
            if(Character.isDigit(content.charAt(i))){
                for(int j=i+1;j<content.length();j++){
                    //如果j的位置也为数字
                    if(Character.isDigit(content.charAt(j))){
                        count++;
                        if(count>=10){
                            //如果数字超过10个就不认为是qq号码，切分字符串
                            int temp=j;
                            while(Character.isDigit(content.charAt(temp))){
                                temp++;
                            }
                            //将需要被切的字符串分离出来
                            list.add(content.substring(i,temp));
                            //将i指向temp
                            i=temp;
                            break;
                        }
                    }
                    else {
                        list.add(content.substring(i,j));
                        i=j;
                        break;
                    }
                }
            }
        }

        for(int i=0;i<list.size();i++){
            content=content.replace(list.get(0),"");
        }

        return content;
    }

    public static void main(String[] args) {
        Solution solution=new Solution();

        System.out.println(solution.filterContent("作者大大66666666666666666，为你点赞"));
    }
}