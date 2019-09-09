package com.guigu.time;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;

/**
 * 
 * @classname: PeriodBetween
 * @description: TODO 主要是Period类方法getYears（），getMonths（）和getDays（）来计算.
 * @author majun
 * @date 2019年9月9日 上午11:01:03
 */
public class PeriodBetween {

	public static void main(String[] args) {
		LocalDate today = LocalDate.now();
		System.out.println("Today : " + today);
		LocalDate birthDate = LocalDate.of(1993, Month.OCTOBER, 19);
		System.out.println("BirthDate : " + birthDate);

		Period period = Period.between(birthDate, today);
		System.out.printf("年龄 : %d 年 %d 月 %d 日", period.getYears(), period.getMonths(), period.getDays());

		long periodDays = periodDays(birthDate, today);
		System.out.println("periodDays : " + periodDays);
	}

	/**
	 * 日期相隔天数
	 * 
	 * @param startDateInclusive
	 * @param endDateExclusive
	 * @return
	 */
	public static long periodDays(LocalDate startDateInclusive, LocalDate endDateExclusive) {
		return endDateExclusive.toEpochDay() - startDateInclusive.toEpochDay();
	}
}
