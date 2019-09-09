package com.guigu;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import com.guigu.lambda.Person;
import com.guigu.lambda.Person.Status;

/**
 * Hello world!
 *
 */
public class App {

	List<Person> emps = null;

	public static void main(String[] args) {
		System.out.println("Hello World!");
	}

	@Before
	public void testbefore() {

		emps = Arrays.asList(
				new Person("李四", 59, 6666.66, Status.FREE), 
				new Person("张三", 18, 9999.99, Status.FREE),
				new Person("王五", 28, 3333.33, Status.BUSY), 
				new Person("赵六", 8, 7777.77, Status.VACATION),
				new Person("田七", 38, 5555.55, Status.BUSY), 
				new Person("田七", 38, 5555.55, Status.VACATION),
				new Person("田七", 38, 5555.55, Status.VACATION)

		);
	}


	@Test
	public void test44() {

		List<Person> emps = Arrays.asList(new Person("李四", 59, 6666.66, Status.FREE),
				new Person("张三", 18, 9999.99, Status.FREE), new Person("王五", 28, 3333.33, Status.BUSY),
				new Person("赵六", 8, 7777.77, Status.VACATION), new Person("田七", 38, 5555.55, Status.BUSY),
				new Person("田七", 38, 5555.55, Status.VACATION), new Person("田七", 38, 5555.55, Status.VACATION)

		);

		Set<String> nameSet = new HashSet<>();
		emps.stream().filter((e) -> {
			System.out.println("短路！"); // && ||
			if (!nameSet.contains(e.getName())) {
				nameSet.add(e.getName());
				System.out.println("==============！"); // && ||
				return true;
			} else {
				return false;
			}
		}).forEach(System.out::println);

		System.err.println(nameSet);
	}

	@Test
	public void test4() {
		emps.stream().filter((e) -> {
			System.out.println("短路！"); // && ||
			return e.getSalary() >= 5000;
		}).limit(3).forEach(System.out::println);
	}

	@Test
	public void test5() {
		emps.parallelStream().filter((e) -> e.getSalary() >= 5000).skip(2).forEach(System.out::println);
	}
}
