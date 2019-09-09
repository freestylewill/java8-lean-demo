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
public class ReduceStopStreamAPI {

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
     * 归约 
     * 1、reduce(T iden, BinaryOperator b) 可以将流中元素反复结合起来，得到一个值，返回 T
     * 2、reduce(BinaryOperator b) 可以将流中元素反复结合起来，得到一个值。返回 Optional<T>
     */
    @Test
    public void test6() {
        // reduce(T iden, BinaryOperator b) 可以将流中元素反复结合起来，得到一个值，返回 T
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        /**
         * 先把0作为了x，y是流中的第一个元素 相加得1，然后1作为x，流中的第二个元素作为y，就这样，依次加下去。
         */
        Integer reduce = list.stream().reduce(0, (x, y) -> x + y);
		System.out.println("reduce===" + reduce);
        System.out.println("=======华丽的分割线========");
		System.out.println();

        // reduce(BinaryOperator b) 可以将流中元素反复结合起来，得到一个值。返回 Optional<T>
        /**
         * 可以看出两个reduce方法返回的并不一样，因为第一个reduce方法有初始值，最后所得的值肯定不会为空，而第二种情况则有可能会为空，所以返回值为跑optional
         */
        Optional<Double> reduce2 = person.stream().map(Person::getSalary)
                .reduce(Double::sum);
		System.out.println("reduce===" + reduce2);
        System.out.println("=======华丽的分割线========");

    }
}