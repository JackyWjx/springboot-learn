package cn.wjx.springbean_test.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@NoArgsConstructor
@AllArgsConstructor
@ConfigurationProperties(prefix = "wjx")
@Data
@RefreshScope
public class HelloBean {
    private String name;
    private String age;
    private String sex;
    @PostConstruct
    private void init(){
        System.out.println("name:"+name+",age:"+age+",sex:"+sex);
    }
}
