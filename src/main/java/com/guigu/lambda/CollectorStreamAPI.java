package com.guigu.lambda;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.Test;

import com.guigu.lambda.Person.Status;

/**
 * 类(接口)描述://中间操作
 * 
 * @author xnn 2018年10月22日下午3:27:12
 */
public class CollectorStreamAPI {

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
     * 收集： collect(Collector c) 将流转换为其他形式。接收一个 Collector接口的实现，用于给Stream中元素做汇总的方法
     */
    @Test
    public void test7() {
        //把人员的名字放到一个list中去
        List<String> collect = person.stream().map(Person::getName)
                .collect(Collectors.toList());
		System.out.println("collect===" + collect);
          System.out.println("=======华丽的分割线=======");
        
          //把人员的名字放到一个hashset中去(会自动去重)
		Set<String> collect2 = person.stream().map(Person::getName)
                .collect(Collectors.toCollection(HashSet::new));
		System.out.println("collect(Collectors.toCollection)===" + collect2);
        System.out.println("=======华丽的分割线=======");

        //计数
        Long long1 = person.stream().collect(Collectors.counting());
		System.out.println("collect(Collectors.counting())===" + long1);
        System.out.println("=======华丽的分割线=======");

        // 按状态分组
        Map<Status, List<Person>> collect3 = person.stream()
                .collect(Collectors.groupingBy((e) -> e.getStatus()));
		System.out.println("collect(Collectors.groupingBy((e) -> e.getStatus()))===" + collect3);
        System.out.println("=======华丽的分割线=======");

        // 多重分组(先按状态分组，再按薪资是否大于5000分组)
        Map<Status, Map<Boolean, List<Person>>> collect4 = person.stream()
                .collect(Collectors.groupingBy((e) -> e.getStatus(),
                        Collectors.groupingBy((e) -> e.getSalary() > 5000)));
		System.out.println("collect===" + collect4);
        System.out.println("=======华丽的分割线=======");
        
        //取所有人员薪资的平均值
        Double double1 = person.stream()
                .collect(Collectors.averagingDouble((e) -> e.getSalary()));
		System.out.println("collect===" + "所有人员薪资的平均值:" + double1);
        System.out.println("=======华丽的分割线=======");
         
        //把所有人的姓名拼接成一个字符串
        String collect5 = person.stream().map(Person::getName)
                .collect(Collectors.joining());
		System.out.println("collect===" + collect5);
        System.out.println("=======华丽的分割线=======");
         
        //找出所有人中薪资最少的一个员工的信息。
        Optional<Person> optional = person.stream().collect(Collectors.minBy(
                (e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary())));
		System.out.println("collect===" + optional);
        System.out.println("=======华丽的分割线=======");

    }
}