package com.guigu.time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import org.junit.Test;

/**
 * Hello world!
 *
 */
public class LocalDateTest {
	public static void main(String[] args) {
		System.out.println("Hello World!");
	}

	// 获取当天日期 Java 8中的 LocalDate 用于表示当天日期。和java.util.Date不同，它只有日期，不包含时间。
	@Test
	public void test1() {
		LocalDate date = LocalDate.now();
		System.out.println("当前日期=" + date);
	}

	// 构造指定日期 调用工厂方法LocalDate.of()创建任意日期，
	// 该方法需要传入年、月、日做参数，返回对应的LocalDate实例。这个方法的好处是没再犯老API的设计错误，比如年度起始于1900，月份是从0开 始等等
	@Test
	public void test2() {
		LocalDate date = LocalDate.of(2000, 1, 1);
		System.out.println("千禧年=" + date);
	}

	// 获取年月日信息
	@Test
	public void test3() {
		LocalDate date = LocalDate.now();
		System.out.printf("年=%d， 月=%d， 日=%d", date.getYear(), date.getMonthValue(), date.getDayOfMonth());
	}

	// 比较两个日期是否相等
	@Test
	public void test4() {
		LocalDate now = LocalDate.now();
		LocalDate date = LocalDate.of(2019, 9, 3);
		System.out.println("日期是否相等=" + now.equals(date));
	}

	// 获取当前时间 Java 8中的 LocalTime 用于表示当天时间。和java.util.Date不同，它只有时间，不包含日期。
	@Test
	public void test5() {
		LocalTime time = LocalTime.now();
		System.out.println("当前时间=" + time);
	}

	// 示例1： 日期时间计算
	@Test
	public void test6() {

		// 时间增量
		LocalTime time = LocalTime.now();
		System.out.println("newTime=" + time);
		LocalTime newTime = time.plusHours(2);
		System.out.println("newTime=" + newTime);

		// 日期增量
		LocalDate date = LocalDate.now();
		LocalDate newDate = date.plus(1, ChronoUnit.WEEKS);
		System.out.println("newDate=" + newDate);

		LocalDate newDateDAYS = date.plus(-365, ChronoUnit.DAYS);
		System.out.println("newDate=" + newDateDAYS);

//		newDateDAYS.

		LocalDate newDateDAYS1 = date.plusDays(-3);
		System.out.println("newDate=" + newDateDAYS1);

	}

	// Java8提供了isAfter()、isBefore()用于判断当前日期时间和指定日期时间的比较
	@Test
	public void test7() {

		LocalDate now = LocalDate.now();
		LocalDate date1 = LocalDate.of(2000, 1, 1);
		if (now.isAfter(date1)) {
			System.out.println("千禧年已经过去了");
		}

		LocalDate date2 = LocalDate.of(2020, 1, 1);
		if (now.isBefore(date2)) {
			System.out.println("2020年还未到来");
		}
	}

	// 创建带有时区的日期时间
	// Java 8不仅分离了日期和时间，也把时区分离出来了。现在有一系列单独的类如ZoneId来处理特定时区，ZoneDateTime类来表示某时区下的时间。
	@Test
	public void test8() {

		// 上海时间
		ZoneId shanghaiZoneId = ZoneId.of("Asia/Shanghai");
		ZonedDateTime shanghaiZonedDateTime = ZonedDateTime.now(shanghaiZoneId);

		// 东京时间
		ZoneId tokyoZoneId = ZoneId.of("Asia/Tokyo");
		ZonedDateTime tokyoZonedDateTime = ZonedDateTime.now(tokyoZoneId);

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		System.out.println("上海时间: " + shanghaiZonedDateTime.format(formatter));
		System.out.println("东京时间: " + tokyoZonedDateTime.format(formatter));

	}

	// 使用预定义格式解析与格式化日期
	@Test
	public void test9() {

		// 解析日期
		String dateText = "20180924";
		LocalDate date = LocalDate.parse(dateText, DateTimeFormatter.BASIC_ISO_DATE);
		System.out.println("格式化之后的日期=" + date);

		// 格式化日期
		dateText = date.format(DateTimeFormatter.ISO_DATE);
		System.out.println("dateText=" + dateText);
	}

	// 日期和字符串的相互转换
	@Test
	public void test10() {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

		// 日期时间转字符串
		LocalDateTime now = LocalDateTime.now();
		String nowText = now.format(formatter);
		System.out.println("nowText=" + nowText);

		String nowText_BASIC_ISO_DATE = now.format(DateTimeFormatter.BASIC_ISO_DATE);
		System.out.println("nowText_BASIC_ISO_DATE=" + nowText_BASIC_ISO_DATE);

		String nowText_ISO_DATE = now.format(DateTimeFormatter.ISO_DATE);
		System.out.println("nowText_ISO_DATE=" + nowText_ISO_DATE);

		String nowText_ISO_TIME = now.format(DateTimeFormatter.ISO_TIME);
		System.out.println("nowText_ISO_TIME=" + nowText_ISO_TIME);

		String nowText_ISO_DATE_TIME = now.format(DateTimeFormatter.ISO_DATE_TIME);
		System.out.println("nowText_ISO_DATE_TIME=" + nowText_ISO_DATE_TIME);

		String nowText_ISO_LOCAL_DATE = now.format(DateTimeFormatter.ISO_LOCAL_DATE);
		System.out.println("nowText_ISO_LOCAL_DATE=" + nowText_ISO_LOCAL_DATE);

//		String nowText_ISO_OFFSET_DATE = now.format(DateTimeFormatter.ISO_OFFSET_DATE);
//		System.out.println("nowText_ISO_OFFSET_DATE=" + nowText_ISO_OFFSET_DATE);

		// 字符串转日期时间
		String datetimeText = "1999-12-31 23:59:59";
		LocalDateTime datetime = LocalDateTime.parse(datetimeText, formatter);
		System.out.println(datetime);
	}
}
