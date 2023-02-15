package Stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListToLIst {
    public static void main(String[] args) {
        List<String> before=new ArrayList<>();
        List<String> after=new ArrayList<>();

        before.add("1");
        before.add("2");
        before.add("3");
        before.add("4");
        before.add("5");

        after.add("1");
        after.add("2");
        after.add("3");
        after.add("4");
        after.add("5");
        after.add("6");
        int len=after.size();
//        before里面的数据不存在与after(表示被取走)
        List<String> collect = before.stream().filter(item ->
        {
            if(len<before.size()){
//                after的数据小于before，说明要取走
                return !after.contains(item);
            }
            else if (len>before.size()){
//               after的数据比before大，说明有新增
                return after.remove(item);
            }
            else {
                return false;
            }
        }
        ).collect(Collectors.toList());
////        after中的数据不存在与before(表示新增)
//        List<String> collect1 = after.stream().filter(item -> !before.contains(item)).collect(Collectors.toList());

//        输出
        if(before.size()>len){
//            取
            System.out.println(collect.toString());
        }
        else if(before.size()<len){
//            增
            System.out.println(after.toString());
        }else
        System.out.println(false);

    }
}
