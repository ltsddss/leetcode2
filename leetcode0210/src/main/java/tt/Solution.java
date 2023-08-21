package tt;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。
 *
 * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
 */
public class Solution {

    public boolean result=false;

    public boolean wordBreak(String s, List<String> wordDict) {
//        利用回溯完成对于所有单词的遍历
        huisu(wordDict,s,0);
        return result;
    }

    public void huisu(List<String> wordDict,String s,int idx){
        if(idx==wordDict.size()){
            return;
        }
        if(s.replaceFirst(wordDict.get(idx),"").equals("")){
            result=true;
            return;
        }
        huisu(wordDict,s,idx+1);
        if(!s.replaceFirst(wordDict.get(idx),"").equals("")){
            huisu(wordDict,s.replaceFirst(wordDict.get(idx),""),idx);
        }
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        ArrayList<String> list = new ArrayList<>();
        list.add("apple");
        list.add("pen");
        System.out.println(solution.wordBreak("applepenapple", list));
    }
}
