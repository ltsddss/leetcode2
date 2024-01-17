package date07;

import java.util.ArrayList;
import java.util.List;

public class StockSpanner {
    //    901. 股票价格跨度
    private static List<Integer> list;

    public StockSpanner() {
        list=new ArrayList<>();
    }

    public int next(int price) {
        int result=0;
        for (Integer integer : list) {
            if(price>integer){
                result++;
            }
        }
        return result;
    }
}
