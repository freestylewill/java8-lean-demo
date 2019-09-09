package com.guigu.time;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

public class DateSwapLocalDate {

	public static void main(String[] args) {
		dateToLocalDateTime();
		System.err.println("##############################333333");
		localDateTimeToDate();

	}

	public static void dateToLocalDateTime() {
        Date date = new Date();
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();

        LocalDateTime localDateTime = instant.atZone(zoneId).toLocalDateTime();
        System.out.println("Date = " + date);
        System.out.println("LocalDateTime = " + localDateTime);

    }

	public static void localDateTimeToDate() {
		ZoneId zoneId = ZoneId.systemDefault();
		LocalDateTime localDateTime = LocalDateTime.now();
		ZonedDateTime zdt = localDateTime.atZone(zoneId);

		Date date = Date.from(zdt.toInstant());

		System.out.println("LocalDateTime = " + localDateTime);
		System.out.println("Date = " + date);
	}
}