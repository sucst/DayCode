package cn.atsuc.data;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

/**
 * @author atsuc
 * @date 2024/6/3 23:05
 * @email s202011105851@163.com
 * @description
 */
public class systemDataTest {
    @Test
    public void systemDataTest01() {
        Date date = new Date();
        System.out.println(date);

        System.out.println(System.currentTimeMillis());
        System.out.println(date.getTime());

        Date date1 = new Date(date.getTime());
        System.out.println(date1.getTime());
        System.out.println(date1.toString());
    }

    @Test
    public void systemDataTest02() {
        Date date = new Date();
        // 格式化实例
        SimpleDateFormat format = new SimpleDateFormat();
        System.out.println(format.format(date)); // 默认格式

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(dateFormat.format(date));

        SimpleDateFormat foreFormat = new SimpleDateFormat("yyyy年MM月dd日 EEE HH:mm:ss");
        System.out.println(foreFormat.format(date));
        // 实例化一个指定的格式对象
        try {
            Date parse = dateFormat.parse("2023-08-08 08:08:08");
            System.out.println(parse.toString());

            Date date1 = foreFormat.parse("2023年08月08日 星期六 08:08:08");
            System.out.println(date1.toString());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void systemDataTest03() {
        Calendar calendar = Calendar.getInstance();
        // 从calendar获取一个Date对象
        Date date = calendar.getTime();
        // 使用给定的Date设置Calendar的时间
        date = new Date(1717428503542L);
        calendar.setTime(date);
        System.out.println(" 初始时间：" + calendar.getTime());
        calendar.set(Calendar.DAY_OF_MONTH, 8);
        System.out.println(" 当前时间设置为8后，时间为：" + calendar.getTime());

        calendar.set(Calendar.HOUR, 2);
        System.out.println(" 当前时间加2h后： 时间为： " + calendar.getTime());

        calendar.add(Calendar.MONTH, -2);
        System.out.println(" 当前时间设置为减2个月后，时间为：" + calendar.getTime());

    }

    @Test
    public void systemDataTest04() {
        // ZoneId类包含了所有时区信息
        Set<String> zoneIds = ZoneId.getAvailableZoneIds();
        for (String zoneId : zoneIds) {
            System.out.println(zoneId);
        }
        System.out.println("---------------------------------");
        // of() : 获取指定时区时间
        LocalDateTime localDateTime = LocalDateTime.now(ZoneId.of("Asia/Shanghai"));
        System.out.println(localDateTime);

        // 带时区的时间和日期
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println(zonedDateTime);

        // 获取指定的对象
        ZonedDateTime zonedDateTime1 = zonedDateTime.now(ZoneId.of("Asia/Shanghai"));
        System.out.println(zonedDateTime1);
    }

    @Test
    public void systemDataTest05() {
        // Duration:用于计算两个“时间”间隔，以秒和纳秒为基准
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalTime localTime = LocalTime.of(15, 23, 32);
        Duration duration = Duration.between(localTime, localDateTime);
        System.out.println(duration);
        System.out.println(duration.getSeconds() + " " + duration.getNano());

        LocalDateTime dateTime = LocalDateTime.of(2023, 2, 12, 21, 23, 45);
        LocalDateTime dateTime1 = LocalDateTime.of(2024, 2, 12, 21, 23, 45);

        Duration duration1 = Duration.between(dateTime, dateTime1);
        System.out.println(duration1.toDays() + " " + duration1.getNano());

        // Period:用于计算两个“日期”间隔，以年、月、日衡量
        LocalDate now = LocalDate.now();
        LocalDate localDate = LocalDate.of(2084, 5, 23);
        Period between = Period.between(now, localDate);
        System.out.println(between+ " " + between.getYears() + " " + between.getMonths() + " " + between.getDays());
    }
}
