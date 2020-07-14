package cn.wjx.springboot_aop;

import com.sun.org.apache.bcel.internal.generic.NEW;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootTest
class SpringbootAopApplicationTests {

    @Test
    void contextLoads() {

    }


    public static void main(String arg[]) throws Exception{

    }

    public static void test1() throws Exception{
        System.out.println("我执行了....");
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("===task start===");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("===task finish===");
            }
        });
        thread.start();
        System.out.println("我执行结束了....");
    }

    public static void test2() throws Exception {
        System.out.println("main函数开始执行");
        ExecutorService executor = Executors.newFixedThreadPool(2);
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(new Supplier<Integer>() {
            @Override
            public Integer get() {
                System.out.println("===task start===");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("===task finish===");
                return 3;
            }
        }, executor);
        future.thenAccept(e -> System.out.println(e));
        System.out.println("main函数执行结束");
    }

    @Test
    public void test3(){
        Stream<List<Integer>> inputStream = Stream.of(
                Arrays.asList(1),
                Arrays.asList(2, 3),
                Arrays.asList(4, 5, 6)
        );
        List<Integer> aa =inputStream.
                flatMap((childList) -> childList.stream()).collect(Collectors.toList());
        for (Integer i:aa) {
            System.out.println(i);

        }
    }

    @Test
    public void test4(){
        System.out.println(Optional.ofNullable(null).orElse("wjx"));
    }

}
