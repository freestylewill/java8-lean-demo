package com.guigu.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.Test;

import com.guigu.lambda.Person.Status;

/**
 * 类(接口)描述://中间操作
 * 
 * @author xnn 2018年10月22日下午3:27:12
 */
public class MiddleStreamAPI {

    List<Person> personList = Arrays.asList(
            new Person("李四", 59, 6666.66, Status.FREE),
            new Person("张三", 18, 9999.99, Status.FREE),
            new Person("王五", 28, 3333.33, Status.BUSY),
            new Person("赵六", 8, 7777.77, Status.VACATION),
            new Person("田七", 38, 5555.55, Status.BUSY),
            new Person("田七", 38, 5555.55, Status.VACATION),
            new Person("田七", 38, 5555.55, Status.VACATION)

    );
    /*
     * 筛选与切片 filter——接收 Lambda ， 从流中排除某些元素。 limit——截断流，使其元素不超过给定数量。 
     * skip(n) ——跳过元素，返回一个扔掉了前 n 个元素的流。若流中元素不足 n 个，则返回一个空流。
     * 与 limit(n) 互补
     * distinct——筛选，通过流所生成元素的 hashCode() 和 equals() 去除重复元素
     */
    @Test
    public void test1() {
        // 先获取流
        Stream<Person> stream = personList.stream();

        // 筛选 Stream<T> filter(Predicate<? super T> predicate);
        // Predicate接口的test方法 传递进去一个T 返回一个Boolean
        // filter——接收 Lambda ， 从流中排除某些元素
        // 这个forEach被称为是内部迭代
        stream.filter((u) -> {
            System.out.println("中间操作");
            //筛选出年龄大于20 的人员
            return u.getAge() > 20;
        }).forEach(System.out::println);
        System.out.println("==============================");
        /**
         * 下面这一部分由于没有终止操作，所以"中间操作"这四个字并没有打印出来，只有当做终止操作时，所有的中间操作会一次性的全部执行，称为“惰性求值”
         */
        Stream<Person> stream4 = personList.stream();
        stream4.filter((u) -> {
            System.out.println("中间操作");
            return u.getAge() > 20;
        });
        System.out.println("==============================");

        // 必须再创建一个新流 目测是新功能的时候，不能用上面的流，否则会报流已经打开或关闭的错误
        Stream<Person> stream1 = personList.stream();

        // limit——截断流，使其元素不超过给定数量
        //筛选出年龄大于20岁的人元信息后，只取前两个值
        stream1.filter((u) -> u.getAge() > 20).limit(2)
                .forEach(System.out::println);
        System.out.println("==============================");

        // skip(n) —— 跳过元素，返回一个扔掉了前 n 个元素的流。若流中元素不足 n 个，则返回一个空流。与 limit(n) 互补
        Stream<Person> stream2 = personList.stream();
        //筛选出年龄大于20岁的人元信息后，跳过第一个人，取后面的值
        stream2.filter((u) -> u.getAge() > 20).skip(1)
                .forEach(System.out::println);

        System.out.println("==============================");
        
        // distinct——筛选，通过流所生成元素的 hashCode() 和 equals()这样去除重复元素(意即需要重写实体类的hashcode 和equals方法)
        Stream<Person> stream3 = personList.stream();

        stream3.filter((u) -> u.getAge() > 20).distinct()
				.forEach(System.err::println);
    }
}