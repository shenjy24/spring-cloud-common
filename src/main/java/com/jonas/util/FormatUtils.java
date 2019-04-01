package com.jonas.util;

import java.text.DecimalFormat;

/**
 * 【 容量转换 】
 *
 * @author shenjy 2018/09/21
 */
public class FormatUtils {

    /**
     * 时长转化为00:00:00的格式
     *
     * @param second
     * @return
     */
    public static String formatDuration(int second) {
        int h = second / 3600;
        int m = (second % 3600) / 60;
        int s = (second % 3600) % 60;

        return String.format("%s:%s:%s", parse(h), parse(m), parse(s));
    }

    private static String parse(int num) {
        if (0 == num) {
            return "00";
        } else if (10 > num) {
            return "0" + num;
        } else {
            return String.valueOf(num);
        }
    }

    /**
     * 容量大小转换
     *
     * @param size
     * @return
     */
    public static String formatSize(long size) {
        DecimalFormat df = new DecimalFormat("#.00");
        String sizeString = "";
        if (size < 1024) {
            sizeString = df.format((double) size) + "B";
        } else if (size < 1048576) {
            sizeString = df.format((double) size / 1024) + "K";
        } else if (size < 1073741824) {
            sizeString = df.format((double) size / 1048576) + "M";
        } else {
            sizeString = df.format((double) size / 1073741824) + "G";
        }
        return sizeString;
    }

    /**
     * 时间大小转换
     *
     * @param second
     * @return
     */
    public static String formatSecond(int second) {
        int h = second / 3600;
        int m = (second % 3600) / 60;
        int s = (second % 3600) % 60;

        StringBuilder time = new StringBuilder();
        if (0 != h) {
            time.append(h + "小时");
        }
        if (0 != m) {
            time.append(m + "分");
        }
        if (0 != s) {
            time.append(s + "秒");
        }

        return time.toString();
    }

    /**
     * 日期格式转换
     * 1、1小时内显示XX分钟前。
     * 2、今天之内显示XX小时前。
     * 3、非今天显示：X天前。昨天：1天前，前天：2天前
     * 4、非本月显示：1个月前
     * 5、非本年度显示：1年前
     *
     * @param millisecond
     * @return
     */
    public static String formatTime(long millisecond) {
        Integer past = DateUtils.parseToSecond(millisecond);
        Integer now = DateUtils.currentSecond();
        Integer between = now - past;

        if (between < 0) {
            return "";
        } else if (between < DateUtils.MINUTE_SECOND) {
            return "1分钟前";
        } else if (between < DateUtils.HOUR_SECOND) {
            Integer minute = between / 60;
            return minute + "分钟前";
        } else if (between < DateUtils.DAY_SECOND) {
            Integer hour = between / DateUtils.HOUR_SECOND;
            return hour + "小时前";
        } else if (between < DateUtils.MONTH_SECOND) {
            Integer day = between / DateUtils.DAY_SECOND;
            return day + "天前";
        } else if (between < DateUtils.YEAR_SECOND) {
            Integer month = between / DateUtils.MONTH_SECOND;
            return month + "个月前";
        } else {
            Integer year = between / DateUtils.YEAR_SECOND;
            return year + "年前";
        }
    }

    /**
     * 1. 9999以内含9999，全文显示数值。精确到个位数
     * 2. 10000以上含10000，显示简写。例：10900:1W 16908:1.6W
     *
     * @param num
     * @return
     */
    public static String formatNum(int num) {
        if (9999 >= num) {
            return String.valueOf(num);
        }

        int quotient = num / 10000;
        int remainder = num % 10000;
        int thousand = remainder / 1000;
        return quotient + "." + thousand + "W";
    }

    /**
     * 隐藏手机号中间4位
     *
     * @param mobile
     * @return
     */
    public static String formatMobile(String mobile) {
        return mobile.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");
    }
}
