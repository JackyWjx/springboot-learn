package cn.wjx.voice_demo;

/**
 * @Author: wjx
 * @Description:
 * @Date: create in 2021-04-23 16:24
 */
public class VolatileResort {
    static int num = 0;
    static volatile boolean flag = false;
    public static void init() {
        num= 1;
        flag = true;
    }
    public static void add() {
        if (flag) {
            num = num + 5;
            System.out.println("num:" + num);
        }
    }
    public static void main(String[] args) {
        for (int i = 0 ; i < 50; i ++){
            VolatileResort volatileResort = new VolatileResort();
            volatileResort.init();
            new Thread(() -> {
                volatileResort.add();
            },"子线程").start();
        }
        }


}
