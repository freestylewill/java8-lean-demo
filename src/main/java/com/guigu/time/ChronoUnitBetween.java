package com.guigu.time;

import java.time.LocalDate;
import java.time.Month;
import java.time.chrono.ChronoPeriod;
import java.time.temporal.ChronoUnit;

/**
 * 
 * @classname: ChronoUnitBetween
 * @description: TODO ChronoUnit类可用于在单个时间单位内测量一段时间，例如天数或秒。
 *               以下是使用between方法来查找两个日期之间的区别的示例。
 * @author majun
 * @date 2019年9月9日 上午11:00:06
 */
public class ChronoUnitBetween {

    public static void main(String[] args) {
        LocalDate startDate = LocalDate.of(1993, Month.OCTOBER, 19);
        System.out.println("开始时间  : " + startDate);

        LocalDate endDate = LocalDate.of(2017, Month.JUNE, 16);
        System.out.println("结束时间 : " + endDate);

        long daysDiff = ChronoUnit.DAYS.between(startDate, endDate);
		ChronoPeriod between = ChronoPeriod.between(startDate, endDate);
		long daysDiff2 = ChronoUnit.DAYS.between(endDate, startDate);
        System.out.println("两天之间的差在天数   : " + daysDiff);
		System.out.println("两天之间的差在天数daysDiff2   : " + daysDiff2);
		System.out.println("两天之间的差在天数between   : " + between.get(ChronoUnit.DAYS));

    }
}
