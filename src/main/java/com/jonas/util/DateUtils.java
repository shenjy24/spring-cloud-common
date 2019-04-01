package com.jonas.util;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;

/**
 * 【 时间工具类 】
 *
 * @author shenjy 2018/08/25
 */
public class DateUtils {

    public static final String FORMAT_YYYY_MM_DD = "yyyy-MM-dd";

    public static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HHmmss");

    public static final DateTimeFormatter MONTH_FORMATTER = DateTimeFormatter.ofPattern("yyyyMM");

    public static final DateTimeFormatter SHORT_DATE_FORMATTER = DateTimeFormatter.ofPattern("yyMMdd");

    public static final DateTimeFormatter SHORT_DATETIME_FORMATTER = DateTimeFormatter.ofPattern("yyMMddHHmmss");

    public static final DateTimeFormatter DATETIME_FORMATTER = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

    public static final DateTimeFormatter YYYYMMDD_FORMATTER = DateTimeFormatter.ofPattern("yyyyMMdd");

    public static final DateTimeFormatter YYYY_MM_DD_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static final String FORMAT_YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

    public static final String FORMAT_ZERO_ZONE = "yyyy-MM-dd'T'HH:mm:ss'Z'";

    public static final Integer MINUTE_SECOND = 60;

    public static final Integer HOUR_SECOND = 60 * 60;

    public static final Integer DAY_SECOND = HOUR_SECOND * 24;

    public static final Integer MONTH_SECOND = DAY_SECOND * 30;

    public static final Integer YEAR_SECOND = MONTH_SECOND * 12;

    /**
     * 获取当前日期字符串
     *
     * @return
     */
    public static String getCurrentDate() {
        LocalDate now = LocalDate.now();
        return now.format(DateTimeFormatter.ofPattern(FORMAT_YYYY_MM_DD));
    }

    /**
     * 获取某一个时间段之后的毫秒时间戳
     *
     * @param stamp
     * @param amount
     * @param unit
     * @return
     */
    public static Long getNextStamp(Long stamp, Integer amount, ChronoUnit unit) {
        LocalDateTime now = Instant.ofEpochMilli(stamp).atZone(ZoneId.systemDefault()).toLocalDateTime();
        LocalDateTime next = now.plus(amount, unit);
        return next.toInstant(ZoneOffset.of("+8")).toEpochMilli();
    }

    /**
     * 根据毫秒时间戳比较日期大小
     *
     * @param stamp1
     * @param stamp2
     * @return
     */
    public static Integer compareDate(Long stamp1, Long stamp2) {
        LocalDate localDate1 = Instant.ofEpochMilli(stamp1).atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate localDate2 = Instant.ofEpochMilli(stamp2).atZone(ZoneId.systemDefault()).toLocalDate();

        Integer result = localDate1.compareTo(localDate2);
        if (0 == result) {
            return 0;
        } else if (0 > result) {
            return -1;
        } else {
            return 1;
        }
    }

    /**
     * "yyyy-MM-dd"格式 转化为 毫秒时间戳
     *
     * @param date
     * @return
     */
    public static Long getStampFromDate(String date) {
        LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern(FORMAT_YYYY_MM_DD));
        LocalDateTime localDateTime = localDate.atStartOfDay();
        return localDateTime.toInstant(ZoneOffset.of("+8")).toEpochMilli();
    }

    /**
     * "yyyy-MM-dd HH:mm:ss"格式 转化为 毫秒时间戳
     *
     * @param dateTime
     * @return
     */
    public static Long getStampFromTime(String dateTime) {
        LocalDateTime localDateTime = LocalDateTime.parse(dateTime, DateTimeFormatter.ofPattern(FORMAT_YYYY_MM_DD_HH_MM_SS));
        return localDateTime.toInstant(ZoneOffset.of("+8")).toEpochMilli();
    }

    /**
     * 处理0时区时间为本地时间
     *
     * @param time
     * @return
     */
    public static Long parseZeroZoneTime(String time) {
        LocalDateTime localDateTime = LocalDateTime.parse(time, DateTimeFormatter.ofPattern(FORMAT_ZERO_ZONE));
        return localDateTime.toInstant(ZoneOffset.UTC).toEpochMilli();
    }

    /**
     * 毫秒时间戳 转化为 "yyyy-MM-dd"
     *
     * @param stamp
     * @return
     */
    public static String getDate(Long stamp) {
        LocalDate localDate = Instant.ofEpochMilli(stamp).atZone(ZoneId.systemDefault()).toLocalDate();
        return localDate.format(DateTimeFormatter.ofPattern(FORMAT_YYYY_MM_DD));
    }

    /**
     * 毫秒时间戳 转化为 "yyyy-MM-dd HH:mm:ss"
     *
     * @param stamp
     * @return
     */
    public static String getDateTime(Long stamp) {
        LocalDateTime localDateTime = Instant.ofEpochMilli(stamp).atZone(ZoneId.systemDefault()).toLocalDateTime();
        return localDateTime.format(DateTimeFormatter.ofPattern(FORMAT_YYYY_MM_DD_HH_MM_SS));
    }

    /**
     * 秒时间戳
     *
     * @return
     */
    public static int currentSecond() {
        return Long.valueOf(System.currentTimeMillis() / 1000).intValue();
    }

    /**
     * 秒时间戳
     *
     * @return
     */
    public static int parseToSecond(Long millisecond) {
        return Long.valueOf(millisecond / 1000).intValue();
    }


    /**
     * 返回当前的日期
     *
     * @return
     */
    public static LocalDate getCurrentLocalDate() {
        return LocalDate.now();
    }

    /**
     * 返回当前时间
     *
     * @return
     */
    public static LocalTime getCurrentLocalTime() {
        return LocalTime.now();
    }

    /**
     * 返回当前日期时间
     *
     * @return
     */
    public static LocalDateTime getCurrentLocalDateTime() {
        return LocalDateTime.now();
    }

    /**
     * 获取当期日期
     *
     * @return
     */
    public static String getCurrentDateStrYYYYMMDD() {
        return LocalDate.now().format(YYYYMMDD_FORMATTER);
    }

    /**
     * 获取当期日期
     *
     * @return
     */
    public static String getCurrentDateStrYYYY_MM_DD() {
        return LocalDate.now().format(YYYY_MM_DD_FORMATTER);
    }

    /**
     * yyMMdd
     *
     * @return
     */
    public static String getCurrentShortDateStr() {
        return LocalDate.now().format(SHORT_DATE_FORMATTER);
    }

    /**
     * yyyyMM
     *
     * @return
     */
    public static String getCurrentMonthStr() {
        return LocalDate.now().format(MONTH_FORMATTER);
    }

    /**
     * yyyyMMddHHmmss
     *
     * @return
     */
    public static String getCurrentDateTimeStr() {
        return LocalDateTime.now().format(DATETIME_FORMATTER);
    }

    /**
     * yyMMddHHmmss
     *
     * @return
     */
    public static String getCurrentShortDateTimeStr() {
        return LocalDateTime.now().format(SHORT_DATETIME_FORMATTER);
    }

    /**
     * HHmmss
     *
     * @return
     */
    public static String getCurrentTimeStr() {
        return LocalTime.now().format(TIME_FORMATTER);
    }

    public static String getCurrentDateStr(String pattern) {
        return LocalDate.now().format(DateTimeFormatter.ofPattern(pattern));
    }

    public static String getCurrentDateTimeStr(String pattern) {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(pattern));
    }

    public static String getCurrentTimeStr(String pattern) {
        return LocalTime.now().format(DateTimeFormatter.ofPattern(pattern));
    }

    public static LocalDate parseLocalDate(String dateStr, String pattern) {
        return LocalDate.parse(dateStr, DateTimeFormatter.ofPattern(pattern));
    }

    public static LocalDateTime parseLocalDateTime(String dateTimeStr, String pattern) {
        return LocalDateTime.parse(dateTimeStr, DateTimeFormatter.ofPattern(pattern));
    }

    public static LocalTime parseLocalTime(String timeStr, String pattern) {
        return LocalTime.parse(timeStr, DateTimeFormatter.ofPattern(pattern));
    }

    public static String formatLocalDate(LocalDate date, String pattern) {
        return date.format(DateTimeFormatter.ofPattern(pattern));
    }

    public static String formatLocalDateTime(LocalDateTime datetime, String pattern) {
        return datetime.format(DateTimeFormatter.ofPattern(pattern));
    }

    public static String formatLocalTime(LocalTime time, String pattern) {
        return time.format(DateTimeFormatter.ofPattern(pattern));
    }

    public static LocalDate parseLocalDateYYYYMMDD(String dateStr) {
        return LocalDate.parse(dateStr, YYYYMMDD_FORMATTER);
    }

    public static LocalDate parseLocalDateYYYY_MM_DD(String dateStr) {
        return LocalDate.parse(dateStr, YYYY_MM_DD_FORMATTER);
    }

    public static LocalDateTime parseLocalDateTime(String dateTimeStr) {
        return LocalDateTime.parse(dateTimeStr, DATETIME_FORMATTER);
    }

    public static LocalTime parseLocalTime(String timeStr) {
        return LocalTime.parse(timeStr, TIME_FORMATTER);
    }

    /**
     * 格式化日期
     *
     * @param date
     * @return
     */
    public static String formatLocalDateToYYYYMMDD(LocalDate date) {
        return date.format(YYYYMMDD_FORMATTER);
    }

    /**
     * 格式化日期
     *
     * @param date
     * @return
     */
    public static String formatLocalDateToYYYY_MM_DD(LocalDate date) {
        return date.format(YYYY_MM_DD_FORMATTER);
    }

    /**
     * 格式化日期时间为yyyyMMddHHmmss
     *
     * @param datetime
     * @return
     */
    public static String formatLocalDateTime(LocalDateTime datetime) {
        return datetime.format(DATETIME_FORMATTER);
    }

    /**
     * 格式化时间为HHmmss
     *
     * @param time
     * @return
     */
    public static String formatLocalTime(LocalTime time) {
        return time.format(TIME_FORMATTER);
    }

    /**
     * 日期相隔天数
     *
     * @param startDateInclusive
     * @param endDateExclusive
     * @return
     */
    public static int periodDays(LocalDate startDateInclusive, LocalDate endDateExclusive) {
        return Period.between(startDateInclusive, endDateExclusive).getDays();
    }

    /**
     * 日期相隔年数
     * @param date1
     * @param date2
     * @return
     */
    public static int periodYears(LocalDate date1, LocalDate date2) {
        return Period.between(date2, date1).getYears();
    }

    /**
     * 日期相隔小时
     *
     * @param startInclusive
     * @param endExclusive
     * @return
     */
    public static long durationHours(Temporal startInclusive, Temporal endExclusive) {
        return Duration.between(startInclusive, endExclusive).toHours();
    }

    /**
     * 日期相隔分钟
     *
     * @param startInclusive
     * @param endExclusive
     * @return
     */
    public static long durationMinutes(Temporal startInclusive, Temporal endExclusive) {
        return Duration.between(startInclusive, endExclusive).toMinutes();
    }

    /**
     * 日期相隔毫秒数
     *
     * @param startInclusive
     * @param endExclusive
     * @return
     */
    public static long durationMillis(Temporal startInclusive, Temporal endExclusive) {
        return Duration.between(startInclusive, endExclusive).toMillis();
    }

    /**
     * 是否当天
     *
     * @param date
     * @return
     */
    public static boolean isToday(LocalDate date) {
        return getCurrentLocalDate().equals(date);
    }

    public static Long toEpochMilli(LocalDateTime dateTime) {
        return dateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    public static void main(String[] args) {
        LocalDate localDate = LocalDate.parse("1993-07-04");
        System.out.println(periodYears(LocalDate.now(), localDate));
    }
}
