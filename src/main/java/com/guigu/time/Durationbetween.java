package com.guigu.time;

import java.time.Duration;
import java.time.Instant;

/**
 * 
 * @classname: Durationbetween
 * @description: TODO 提供了使用基于时间的值（如秒，纳秒）测量时间量的方法。
 * @author majun
 * @date 2019年9月9日 上午10:59:30
 */
public class Durationbetween {

    public static void main(String[] args) {
        Instant inst1 = Instant.now();
        System.out.println("Inst1 : " + inst1);
        Instant inst2 = inst1.plus(Duration.ofSeconds(10));
        System.out.println("Inst2 : " + inst2);

        System.out.println("Difference in milliseconds : " + Duration.between(inst1, inst2).toMillis());

        System.out.println("Difference in seconds : " + Duration.between(inst1, inst2).getSeconds());

    }
}
