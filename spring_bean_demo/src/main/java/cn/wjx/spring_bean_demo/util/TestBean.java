package cn.wjx.spring_bean_demo.util;

/**
 * @Author: wjx
 * @Description:
 * @Date: create in 2021-01-06 14:16
 */
public class TestBean {
    private String username="张三";
    private String url="www.baidu.com";
    private String password="12345";
    public void sayHello(){
        System.out.println("TestBean sayHello...");
    }
    @Override
    public String toString(){
        return "username:"+this.username+",url:"+this.url+",password:"+this.password;
    }
    public void start(){
        System.out.println("TestBean 初始化。。。");
    }
    public void cleanUp(){
        System.out.println("TestBean 销毁。。。");
    }
}
