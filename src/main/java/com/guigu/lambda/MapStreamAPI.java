package com.guigu.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

import com.guigu.lambda.Person.Status;

/**
 * 类(接口)描述://中间操作
 * 
 * @author xnn 2018年10月22日下午3:27:12
 */
public class MapStreamAPI {

	List<Person> person = Arrays.asList(new Person("李四", 59, 6666.66, Status.FREE),
			new Person("张三", 18, 9999.99, Status.FREE),
			new Person("王五", 28, 3333.33, Status.BUSY),
			new Person("赵六", 8, 7777.77, Status.VACATION), 
			new Person("田七", 38, 5555.55, Status.BUSY),
			new Person("田七", 38, 5555.55, Status.VACATION), 
			new Person("田七", 38, 5555.55, Status.VACATION)

	);

	/**
	 * 映射： 1、map(Function f) 接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素。
	 * 2、mapToDouble(ToDoubleFunction f)) 接收一个函数作为参数，该函数会被应用到每个素上，产生一个新的
	 * DoubleStream 3、mapToInt(ToIntFunction f)接收一个函数作为参数，该函数会被应用到每个元素上，产生一个新的
	 * IntStream。 4、mapToLong(ToLongFunction f) 接收一个函数作为参数，该函数会被应用到每个元素上，产生一个新的
	 * LongStream 5、flatMap(Function f) 接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流
	 * 
	 * @author:xnn 2018年10月22日下午3:55:54
	 */
	@Test
	public void test2() {
		Stream<Person> stream = person.stream();
		// 1、map(Function f) 接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素。
		// 把姓名的集合取出来
		// stream.map((x)->x.getName()).forEach(System.out::println);
		// 方法引用的方式写的
//		stream.map(Person::getName).forEach(System.out::println);
		Set<String> collect = stream.map(Person::getName).collect(Collectors.toSet());

		System.out.println("================" + collect);

		// 2、mapToDouble(ToDoubleFunction f)) 接收一个函数作为参数，该函数会被应用到每个素上，产生一个DoubleStream
		Stream<Person> stream1 = person.stream();
		// stream1.mapToDouble((x)->x.getSalary())
		// .forEach(System.out::println);
		// 另一种写法 即:接受了Person类的getSalary()方法为参数，把薪资全都取出胡来了
		stream1.mapToDouble(Person::getSalary).forEach(System.out::println);
		System.out.println("================");

		// 3、mapToInt(ToIntFunction f)接收一个函数作为参数，该函数会被应用到每个元素上，产生一个新的 IntStream。
		Stream<Person> stream2 = person.stream();
		stream2.mapToInt(Person::getAge).forEach(System.out::println);
		System.out.println("================");

		Stream<String> stream3 = Stream.of("aaa", "bbb", "ccc", "ddd");

		/*
		 * TestStreamAPI2::filterCharacter就代表把每一个字符串（"aaa","bbb"...）都进行filterCharacter()
		 * 处理， 这时候每个字母，都变成了一个流，而map()方法返回的也是一个流，所以返回值就成了Stream<Stream<Character>>
		 */
		Stream<Stream<Character>> map = stream3.map(MapStreamAPI::myFilterCharacter);

		// 用map的话还得多重遍历(sm 代表一个Stream<Character>，所以再对sm进行了遍历)
		map.forEach((sm) -> sm.forEach(System.out::println));
		System.out.println("++++++++++++++++++++++++++");

		// flatMap(Function f) 接收一个函数作为参数，将流中的每个值都换成另一个流，
		// 然后把所有流连接成一个流（是个关键）
		Stream<String> stream4 = Stream.of("aaa", "bbb", "ccc", "ddd");
		Stream<Character> flatMap = stream4.flatMap(MapStreamAPI::myFilterCharacter);
		flatMap.forEach(System.out::println);
		System.out.println("==============");

		/**
		 * map 和flatmap类似于list集合的add()方法和addAll()方法
		 */
		List<Object> list = new ArrayList<>();
		List<Object> list2 = new ArrayList<>();
		list.add("aaa");
		list.add("bbb");
		list2.add("1");
		// add是把集合加进去了
		list2.add(list);
		System.out.println(list2);

		System.out.println("+++++++++++++++++++++++++");
		List<Object> list3 = new ArrayList<>();
		List<Object> list4 = new ArrayList<>();
		list3.add("aaa");
		list3.add("bbb");
		list4.add("1");
		// addAll是把集合中的每一个元素加进去了
		list4.addAll(list3);
		System.out.println(list4);

	}

	// 把字符串转化为字符数组流
	public static Stream<Character> myFilterCharacter(String str) {
		List<Character> list = new ArrayList<>();
		for (Character character : str.toCharArray()) {
			list.add(character);
		}
		return list.stream();
	}
}