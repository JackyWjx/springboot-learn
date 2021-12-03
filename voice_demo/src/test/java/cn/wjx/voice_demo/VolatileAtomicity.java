package cn.wjx.voice_demo;

/**
 * @Author: wjx
 * @Description:
 * @Date: create in 2021-04-23 16:18
 */

import java.util.concurrent.atomic.AtomicInteger;

/**
 演示volatile 不保证原子性
 * @create: 2020-08-13 09:53
 */

public class VolatileAtomicity {
    public static AtomicInteger atomicInteger = new AtomicInteger();

    public static volatile int number = 0;

    public static void increase() {
//        number++;
        atomicInteger.getAndIncrement();
    }

    public static void main(String[] args) {

        for (int i = 0; i < 50; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    increase();
                }
            }, String.valueOf(i)).start();
        }

        // 当所有累加线程都结束
        while(Thread.activeCount() > 2) {
            Thread.yield();
        }

        System.out.println(atomicInteger);
    }
}
