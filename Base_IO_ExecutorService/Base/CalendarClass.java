package Base;

import java.util.Calendar;

public class CalendarClass {
    public static void main(String[] args) {
    
    }
}

class _calendar {
    public static void main(String[] args) {
        Calendar calendar1 = Calendar.getInstance();
        // 获取当前日期
        System.out.println(calendar1);
        // 获取年份
        System.out.println(calendar1.get(Calendar.YEAR));
        // 获取当前月份的天数最大值
        System.out.println(calendar1.getActualMaximum(Calendar.DAY_OF_MONTH));
        // 获取当前月份的天数最小值
        System.out.println(calendar1.getActualMinimum(Calendar.DAY_OF_MONTH));
        // 获取当前月份的天数
        System.out.println(calendar1.get(Calendar.DAY_OF_MONTH));
        // 获取当前月份
        System.out.println(calendar1.get(Calendar.MONTH));
        // 获取当前小时
        System.out.println(calendar1.get(Calendar.HOUR_OF_DAY));
        // 获取当前分钟
        System.out.println(calendar1.get(Calendar.MINUTE));
        // 获取当前秒
        System.out.println(calendar1.get(Calendar.SECOND));
        // 获取当前毫秒
    }
}
