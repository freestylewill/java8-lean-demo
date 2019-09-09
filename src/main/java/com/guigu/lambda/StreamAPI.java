package com.guigu.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.junit.Test;

/**
 * 类(接口)描述:Stream 操作的三个步骤 1.创建流 2.做一些中间操作 3.做终止操作
 * 
 * @author xnn 2018年10月22日下午2:56:26
 */
public class StreamAPI {
//获取流的第一种方式   （Java8中的Collection接口被扩展没提供了两个获取流的方法 Stream()  parallelStream()）
	List<Person> person = Arrays.asList(
			new Person("李四", 59, 6666.66),
			new Person("张三", 18, 9999.99),
			new Person("王五", 28, 3333.33), 
			new Person("赵六", 8, 7777.77), 
			new Person("田七", 38, 5555.55));

	@Test
	public void test1() {
		// 第一种:获取一个顺序流
		Stream<Person> stream = person.stream();
		System.out.println(stream);

		// 第一种:获取一个并行流
		Stream<Person> parallelStream = person.parallelStream();
		System.out.println(parallelStream);

		// 第二种:获取流的第二种方式 ——由数组创建流
		Integer arr[] = new Integer[] { 1, 4, 5, 6, 78, 7 };
		Stream<Integer> stream2 = Arrays.stream(arr);
		
		
		Optional<Integer> first = stream2.findFirst();
		System.out.println(first);
		// 第三种:获取流的第三种方式——可以使用静态方法 Stream.of(),即用值创建流
		Stream<String> stream3 = Stream.of("y7yiu");
		String string = stream3.findFirst().get();
		System.out.println(string);
		System.err.println("=========================================");
	}

	@Test
	public void test2() {
		// 创建无限流
		// 迭代的方式创建无限流
		Stream.iterate(0, (x) -> x + 2).limit(10).forEach(System.out::println);
		// 生成的方式产生无限流
		Stream.generate(() -> Math.random()).limit(3).forEach(System.out::println);
	}
}