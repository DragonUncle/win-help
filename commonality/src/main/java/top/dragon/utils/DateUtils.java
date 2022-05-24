package top.dragon.utils;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateUtils {

    public static DateTimeFormatter dfDateTime = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    public static DateTimeFormatter dfDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public static Date getToDayStartTimeDate() {
        return getToDayStartTimeDate(LocalDateTime.now());
    }

    public static Date getToDayStartTimeDate(LocalDateTime localDateTime) {
        //获取当前时间-在这里可以增加或者减少时间求出非当前天的最小时间
        LocalDateTime day = localDateTime.with(LocalTime.MIN);
        return Date.from(day.atZone(ZoneId.systemDefault()).toInstant());
    }
    public static Date getToDayEndTimeDate() {
        return getToDayEndTimeDate(LocalDateTime.now());
    }
    public static Date getToDayEndTimeDate(LocalDateTime localDateTime) {
        //获取当前时间-在这里可以增加或者减少时间求出非当前天的最大时间.plusDays()
        LocalDateTime day = localDateTime.with(LocalTime.MAX);
        return Date.from(day.atZone(ZoneId.systemDefault()).toInstant());
    }
}
