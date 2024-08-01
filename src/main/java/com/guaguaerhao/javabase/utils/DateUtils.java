package com.guaguaerhao.javabase.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 抄袭 org.apache.commons.lang3.time.DateUtils
 */
public class DateUtils {
    public static final long MILLIS_PER_SECOND = 1000L;
    public static final long MILLIS_PER_MINUTE = 60000L;
    public static final long MILLIS_PER_HOUR = 3600000L;

    public static final String DATE_TIME_FORMAT ="yyyy-MM-dd HH:mm:ss";

    public DateUtils() {
    }

    /**
     * 格式化Date
     * @param d 时间
     * @return String
     */
    public static String formatDateTime(Date d) {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_TIME_FORMAT);
        return sdf.format(d);
    }

    /**
     * 是否同一天
     */
    public static boolean isSameDay(Date date1, Date date2) {
        if (date1 != null && date2 != null) {
            Calendar cal1 = Calendar.getInstance();
            cal1.setTime(date1);
            Calendar cal2 = Calendar.getInstance();
            cal2.setTime(date2);
            return isSameDay(cal1, cal2);
        } else {
            throw nullDateIllegalArgumentException();
        }
    }

    /**
     * 是否同一个瞬息（Instant）
     */
    public static boolean isSameInstant(Date d1, Date d2) {
        if (d1 != null && d2 != null) {
            return d1.getTime() == d2.getTime();
        } else {
            throw nullDateIllegalArgumentException();
        }
    }

    /**
     * 是否同一个瞬息（Instant）
     */
    public static boolean isSameInstant(Calendar c1, Calendar c2) {
        if (c1 != null && c2 != null) {
            return c1.getTime().getTime() == c2.getTime().getTime();
        } else {
            throw nullDateIllegalArgumentException();
        }
    }

    /**
     * 编译之后，Calendar.ERA、Calendar.YEAR 等常量都会变成具体数值
     *
     * @param cal1
     * @param cal2
     * @return
     */
    private static boolean isSameDay(Calendar cal1, Calendar cal2) {
        // Calendar.ERA    ERA表示纪元，只能为0或1。0表示BC(“before Christ”，即公元前)；1表示AD(拉丁语“Anno Domini”，即公元)。
        // Calendar.YEAR 表示年份
        // Calendar.DAY_OF_YEAR 表示一年中第几天
        if (cal1 != null && cal2 != null) {
            return cal1.get(Calendar.ERA) == cal2.get(Calendar.ERA) && cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) && cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR);
        } else {
            throw nullDateIllegalArgumentException();
        }
    }

    /**
     * 返回异常 date 不能为空
     *
     * @return
     */
    private static IllegalArgumentException nullDateIllegalArgumentException() {
        return new IllegalArgumentException("The date must not be null");
    }
}
