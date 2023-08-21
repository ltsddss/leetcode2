import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class text {

    public static String minusOneDay(String time){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        //将接收的time中的年月日截取成String数组
        String[] timeStr = time.split("-");
        Calendar calendar = Calendar.getInstance();
        int year = Integer.valueOf(timeStr[0]);
        int month = Integer.valueOf(timeStr[1]);
        int day = Integer.valueOf(timeStr[2]);

        try {
            //判断time中的日期是否是该年该月的一号，如果不是就往前减一天;如果是就看情况减月份和年份
            if (day <= 1) {
                String date = null;
                //如果月份不是1月，就对月份减一；如果月份是1月，就对年份减一；
                if (month > 1) {
                    month--;
                    Calendar c = Calendar.getInstance();
                    c.set(year, month, 0);
                    Date parse = dateFormat.parse(year + "-" + month + "-" + c.get(c.DAY_OF_MONTH));
                    date = dateFormat.format(parse);
                } else if (month == 1) {
                    year--;
                    date = year + "-12-31";
                }
                return date;
            }
            //time中的日期不是该年该月的一号，直接往前减一天
            Date date = dateFormat.parse(time);
            calendar.setTime(date);
            calendar.add(calendar.DATE, -1);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return dateFormat.format(calendar.getTime());
    }
    public static void main(String[] args) {
        String s = minusOneDay("2023-07-22");
        System.out.println(s);

    }
}
