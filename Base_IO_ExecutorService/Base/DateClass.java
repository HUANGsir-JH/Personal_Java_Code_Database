package Base;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateClass {
    public static void main(String[] args) {
        //时间戳
        long time = System.currentTimeMillis();
        System.out.println(time);
        //时间戳转换为日期
        Date date = new java.util.Date(time);
        System.out.println(date);
        //时间格式的转换，用SimpleDateFormat
        //其中：y表示年，M表示月，d表示日，h表示12进制，H表示24进制，m表示分，s表示秒，S表示毫秒
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy--MM--dd HH:mm:ss");
        System.out.println(sdf.format(date));
        
        //string ->date时间戳
        String datestring="2018--11--11 11:11:11";//需要确保字符串的格式和SimpleDateFormat的格式一致
        Date date2= null;
        try {
            date2 = sdf.parse(datestring);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        System.out.println(date2);
        
        //before & after
        Date date3 = new Date();
        System.out.println("date3:"+date3);
        System.out.println(date3.before(date2));//判断date3是否在date2之前
        System.out.println(date3.after(date2));//判断date3是否在date2之后
    }
}
