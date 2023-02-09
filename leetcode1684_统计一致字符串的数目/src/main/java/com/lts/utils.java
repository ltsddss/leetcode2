package com.lts;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class utils {
    //    java获取当前时间是星期几
    public static int dayForWeek(String pTime) throws Exception {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.setTime(format.parse(pTime));
        int dayForWeek = 0;
        if (c.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
            dayForWeek = 7;
        } else {
            dayForWeek = c.get(Calendar.DAY_OF_WEEK) - 1;
        }
        return dayForWeek;
    }
    //    java判断日期区间之间的周一到周五
    public static List<String[]> getTimeForWeek(String[] time){
        List<String> result=new ArrayList<>();
        List<String[]> dateResult=new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try{
            Date start = sdf.parse(time[0]);
            Date end = sdf.parse(time[1]);
            Date temp = start;
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(start);
            while(temp.getTime()<end.getTime()){
                temp = calendar.getTime();
//                判断星期几
                int week = dayForWeek(sdf.format(temp));
                if(week>=1&&week<=5){
                    result.add(sdf.format(temp));
                }
                calendar.add(Calendar.DAY_OF_MONTH,1);
            }

//            对result进行处理，将时间集合写为时间段
            if(result.size()==0){
//                说明选择的时间段是周六日
                return null;
            }
            else if(result.size()==1){
//                仅一天工作日
                dateResult.add(new String[]{result.get(0),result.get(0)});
                return dateResult;
            }
            else {
//                时间范围
                for (int i = 0; i < result.size();i++) {
                    int first=i;
                    for (int j = i+1; j < result.size(); j++) {
                        calendar.setTime(sdf.parse(result.get(i)));
                        calendar.add(Calendar.DAY_OF_MONTH,1);
                        if(!sdf.format(calendar.getTime()).equals(result.get(j))){
//                            说明时间段断了
                            dateResult.add(new String[]{result.get(first),result.get(j)});
                            i=j;
                            break;
                        }
                        else {
                            i++;
                        }
                    }
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return dateResult;
    }

    public static String getFirstDay(int year,int month,String format) {
        Calendar cale = Calendar.getInstance();

        cale.set(Calendar.YEAR,year);	//赋值年份
        cale.set(Calendar.MONTH, month-1);//赋值月份
        int lastDay = cale.getActualMinimum(Calendar.DAY_OF_MONTH);//获取月最大天数
        cale.set(Calendar.DAY_OF_MONTH, lastDay);//设置日历中月份的最大天数
        SimpleDateFormat sdf = new SimpleDateFormat(format);//格式化日期yyyy-MM-dd
        String lastDayOfMonth = sdf.format(cale.getTime());
        return lastDayOfMonth;
    }


    public static String getLastDay(int year,int month,String format) {
        Calendar cale = Calendar.getInstance();

        cale.set(Calendar.YEAR,year);//赋值年份
        cale.set(Calendar.MONTH, month-1);//赋值月份
        int lastDay = cale.getActualMaximum(Calendar.DAY_OF_MONTH);//获取月最大天数
        cale.set(Calendar.DAY_OF_MONTH, lastDay);//设置日历中月份的最大天数
        SimpleDateFormat sdf = new SimpleDateFormat(format);	//格式化日期yyyy-MM-dd
        String lastDayOfMonth = sdf.format(cale.getTime());
        return lastDayOfMonth;
    }

    public static void main(String[] args) {
        System.out.println(getLastDay(2022, 2, "yyyy-MM-dd"));
    }

//    public static void main(String[] args) {
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        try{
////起始日期
//            Date start = sdf.parse("2019-01-01");
////结束日期
//            Date end = sdf.parse("2019-11-27");
//            Date temp = start;
//            Calendar calendar = Calendar.getInstance();
//            calendar.setTime(start);
////打印2019-01-01到2019-11-27的日期
//            while(temp.getTime()<end.getTime()){
//                temp = calendar.getTime();
//                System.out.println(sdf.format(temp));
////天数+1
//                calendar.add(Calendar.DAY_OF_MONTH,1);
//            }
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//    }
}
