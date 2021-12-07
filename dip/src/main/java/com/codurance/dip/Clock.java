package com.codurance.dip;

import java.time.MonthDay;

public class Clock implements TimeProvider {
    public MonthDay monthDay(){
        return MonthDay.now();
    }
}
