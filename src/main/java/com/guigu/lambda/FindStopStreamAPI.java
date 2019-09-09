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
public class FindStopStreamAPI {

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
     * 1、count() 返回流中元素总数 
     * 2、max(Comparator c) 返回流中最大值
     * 3、min(Comparator c)返回流中最小值 
     * 4、forEach(Consumer c) 内部迭代(使用 Collection接口需要用户去做迭代，称为外部迭代。相反，Stream API 使用内部迭代——它帮你把迭代做
     */
    @Test
    public void test5() {
        // count() 返回流中元素总数
        long count = person.stream().count();
		System.out.println("count===" + count);
        System.out.println("=======华丽的分割线========");

        // max(Comparator c) 返回流中最大值
        Optional<Person> max = person.stream().max(
                (e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
		System.out.println("max===" + "最高工资员工为" + max);
        System.out.println("=======华丽的分割线========");

        // min(Comparator c) 返回流中最小值
        Optional<Person> min = person.stream().min(
                (e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
		System.out.println("min===" + "最低工资员工为" + min);
    }
}