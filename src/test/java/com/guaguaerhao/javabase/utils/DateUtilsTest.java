package com.guaguaerhao.javabase.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class DateUtilsTest {

    @BeforeEach
    void testBeforeEach() {
        System.out.println("============method before===========");
    }

    @Test
    void isSameDay() {
        long wusiDate = 1714780800000L; // 2024-05-04
        long wusiDateNineClock = 1714780800000L + 9 * 60 * 60 * 1000; // 2024-05-04 09:00:00
        long wusiTomorrowDate = 1714780800000L + 24 * 60 * 60 * 1000; // 2024-05-05
        Date d1 = new Date(wusiDate);
        Date d2 = new Date(wusiDate);
        Date d3NineClock = new Date(wusiDateNineClock);
        Date tomorrow = new Date(wusiTomorrowDate);
        boolean shouldSameDay = DateUtils.isSameDay(d1, d2);
        boolean shouldSameDayToo = DateUtils.isSameDay(d2, d3NineClock);
        boolean shouldNotSameDay = DateUtils.isSameDay(d1, tomorrow);

        System.out.println("d1: " + DateUtils.formatDateTime(d1));
        System.out.println("d2: " + DateUtils.formatDateTime(d2));
        System.out.println("d3NineClock: " + DateUtils.formatDateTime(d3NineClock));
        System.out.println("tomorrow: " + DateUtils.formatDateTime(tomorrow));

        Assertions.assertTrue(shouldSameDay);
        Assertions.assertTrue(shouldSameDayToo);
        Assertions.assertFalse(shouldNotSameDay);
    }

    @Test
    void isSameInstant() {
        long wusiDate = 1714780800000L; // 2024-05-04
        long wusiTomorrowDate = 1714780800000L + 24 * 60 * 60 * 1000; // 2024-05-05
        Date d1 = new Date(wusiDate);
        Date d2 = new Date(wusiDate);
        Date tomorrow = new Date(wusiTomorrowDate);
        boolean shouldSameInstant = DateUtils.isSameInstant(d1, d2);
        boolean shouldNotSameInstant = DateUtils.isSameInstant(d1, tomorrow);

        System.out.println("d1: " + DateUtils.formatDateTime(d1));
        System.out.println("d2: " + DateUtils.formatDateTime(d2));
        System.out.println("tomorrow: " + DateUtils.formatDateTime(tomorrow));

        Assertions.assertTrue(shouldSameInstant);
        Assertions.assertFalse(shouldNotSameInstant);
    }

    @Test
    void testIsSameInstant() {
        long wusiDate = 1714780800000L; // 2024-05-04
        long wusiTomorrowDate = 1714780800000L + 24 * 60 * 60 * 1000; // 2024-05-05
        Date d1 = new Date(wusiDate);
        Date d2 = new Date(wusiDate);
        Date tomorrow = new Date(wusiTomorrowDate);

        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(d1);
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(d2);
        Calendar tomorrowCal = Calendar.getInstance();
        tomorrowCal.setTime(tomorrow);

        boolean shouldSameInstant = DateUtils.isSameInstant(cal1, cal2);
        boolean shouldNotSameInstant = DateUtils.isSameInstant(cal2, tomorrowCal);

        System.out.println("d1: " + DateUtils.formatDateTime(d1));
        System.out.println("d2: " + DateUtils.formatDateTime(d2));
        System.out.println("tomorrow: " + DateUtils.formatDateTime(tomorrow));

        Assertions.assertTrue(shouldSameInstant);
        Assertions.assertFalse(shouldNotSameInstant);
    }
}