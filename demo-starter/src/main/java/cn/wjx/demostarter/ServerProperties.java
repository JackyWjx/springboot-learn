package cn.wjx.demostarter;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Description: 服务配置
 * @author: Mr.Wang
 * @createTime: 2021-10-22 14:42
 **/
@ConfigurationProperties("wjx.server")
public class ServerProperties {
    private String name;
    private int port;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
