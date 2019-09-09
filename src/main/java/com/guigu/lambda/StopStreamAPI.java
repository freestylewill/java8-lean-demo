package com.guigu.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Test;

import com.guigu.lambda.Person.Status;

/**
 * 类(接口)描述://中间操作
 * 
 * @author xnn 2018年10月22日下午3:27:12
 */
public class StopStreamAPI {

    List<Person> person = Arrays.asList(
            new Person("李四", 59, 6666.66, Status.FREE),
            new Person("张三", 18, 9999.99, Status.FREE),
            new Person("王五", 28, 3333.33, Status.BUSY),
            new Person("赵六", 8, 7777.77, Status.VACATION),
            new Person("田七", 38, 5555.55, Status.BUSY),
            new Person("田七", 38, 5555.55, Status.VACATION),
            new Person("田七", 38, 5555.55, Status.VACATION)

    );
/**
     * stream的终止操作(查找与匹配) 
     * 1、allMatch(Predicate p) 检查是否匹配所有元素
     * 2、anyMatch(Predicate p) 检查是否至少匹配一个元素 
     * 3、noneMatch(Predicate p)检查是否没有匹配所有元素 
     * 4、findFirst() 返回第一个元素 
     * 5、findAny() 返回当前流中的任意元素
     * @author:xnn 2018年10月23日下午2:48:07
     */
    @Test
    public void test4() {
        // allMatch(Predicate p) 检查是否匹配所有元素，即所有元素的status是BUSY才返回true
        boolean b = person.stream()
                .allMatch((e) -> e.getStatus().equals(Status.BUSY));
		System.out.println("allMatch===" + b);
        System.out.println("===================");

        // anyMatch(Predicate p) 检查是否至少匹配一个元素，只要有一个元素的status是BUSY就返回true
        boolean c = person.stream()
                .anyMatch((w) -> w.getStatus().equals(Status.BUSY));
		System.out.println("anyMatch===" + c);
        System.out.println("===================");

        // noneMatch(Predicate p) 检查是否没有匹配所有元素，即 所有的元素的status都不是BUSY才返回true
        boolean d = person.stream()
                .noneMatch((q) -> q.getStatus().equals(Status.BUSY));
		System.out.println("noneMatch===" + d);
        System.out.println("===================");

        // findFirst() 返回第一个元素，返回符合条件的第一个元素
        Optional<Person> findFirst = person.stream().sorted(
                (e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()))
                .findFirst();
		System.out.println("findFirst===" + findFirst.get());
        System.out.println("========================");

        // findAny() 返回当前流中的任意元素()
        Optional<Person> any = person.parallelStream()
                .filter((e) -> e.getStatus().equals(Status.BUSY)).findAny();
		System.out.println("findAny===" + any.get());
    }
}