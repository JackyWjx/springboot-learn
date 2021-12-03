package cn.wjx.voice_demo;

/**
 * @Author: wjx
 * @Description:
 * @Date: create in 2021-04-23 16:09
 */
public class ShareData {
    volatile int number = 0;

    public void setNumberTo100() {
        this.number = 100;
    }

}
