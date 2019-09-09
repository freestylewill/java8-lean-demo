package com.guigu.optional;

import java.util.Optional;

/**
 * Hello world!
 *
 */
public class OptionalApp {
	public static void main(String[] args) {

		// 创建一个值为张三的String类型的Optional
		Optional<String> ofOptional = Optional.of("张三");


		////////////////////////////////////////////////////
		// 为指定的值创建Optional对象，不管所传入的值为null不为null，创建的时候都不会报错
		Optional<String> nullOptional = Optional.ofNullable(null);
		Optional<String> nullOptional1 = Optional.ofNullable("lisi");

		Object orElse = Optional.ofNullable(null).orElse(0);

		System.out.println(orElse);
		// 如果我们用of方法创建Optional对象时，所传入的值为null，则抛出NullPointerException如下图所示
//		Object object1 = Optional.of(null).get();
//		System.out.println("object===" + object1);
	}
}
