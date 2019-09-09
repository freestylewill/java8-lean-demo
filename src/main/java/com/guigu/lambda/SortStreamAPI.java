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
public class SortStreamAPI {

    List<Person> person = Arrays.asList(
            new Person("李四", 59, 6666.66, Status.FREE),
            new Person("张三", 18, 9999.99, Status.FREE),
			new Person("马六", 18, 9999.99, Status.FREE),
			new Person("a", 18, 9999.99, Status.FREE), 
			new Person("g", 18, 9999.99, Status.FREE),
			new Person("c", 18, 9999.99, Status.FREE),
            new Person("王五", 28, 3333.33, Status.BUSY),
            new Person("赵六", 8, 7777.77, Status.VACATION),
            new Person("田七", 38, 5555.55, Status.BUSY),
            new Person("田七", 38, 5555.55, Status.VACATION),
            new Person("田七", 38, 5555.55, Status.VACATION)

    );
/**
     * sorted() 产生一个新流，其中按自然顺序 sorted(Comparator comp) 产生一个新流，其中按比较器顺序
     */
    @Test
    public void test3() {
        // sorted() 产生一个新流，其中按自然顺序
        List<String> list = Arrays.asList("aa", "bb", "cc", "dd", "ee");
        Stream<String> stream = list.stream();
        stream.sorted().forEach(System.out::println);


        System.out.println("-------------------------");

        // sorted(Comparator comp) 产生一个新流，其中按比较器顺序
        person.stream().sorted((e1, e2) -> {
            /**
             * 年龄相同按姓名排序，否则按年龄排序
             */
            if (e1.getAge() == e2.getAge()) {
                return e1.getName().compareTo(e2.getName());
            } else {
                return Integer.compare(e1.getAge(), e2.getAge());
            }
        }).forEach(System.out::println);;
    }
}