package com.thoughtworks.util;

import java.sql.Date;
import java.util.Calendar;

public class Today {
    private Calendar theCalender = Calendar.getInstance();

    public Today() {
        theCalender.setTime(new java.util.Date());
    }

    public Date day() {
        java.util.Date thedate = new java.util.Date();
        return new Date(thedate.getTime());
    }

    public Date todayDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new java.util.Date());
        return new Date(calendar.getTimeInMillis());
    }

    public Date past() {
        Calendar result = Calendar.getInstance();
        result.add(Calendar.DATE, -2);
        return new Date(result.getTimeInMillis());
    }

    public Date future() {
        Calendar result = Calendar.getInstance();
        result.add(Calendar.DATE, 2);
        return new Date(result.getTimeInMillis());
    }

    public boolean isSameDayAs(Date otherDate) {
        if (otherDate == null) return false;
        boolean isSame = true;
        Calendar otherCal = Calendar.getInstance();
        otherCal.setTime(otherDate);

        if (theCalender.get(Calendar.YEAR) != otherCal.get(Calendar.YEAR)) isSame = false;
        if (theCalender.get(Calendar.MONTH) != otherCal.get(Calendar.MONTH)) isSame = false;
        if (theCalender.get(Calendar.MONTH) != otherCal.get(Calendar.MONTH)) isSame = false;
        return isSame;
    }

}
