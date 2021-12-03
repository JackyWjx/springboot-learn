package cn.wjx.demostarter;

import com.sun.net.httpserver.HttpServer;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * @Description:
 * @author: Mr.Wang
 * @createTime: 2021-10-22 14:45
 **/
@EnableConfigurationProperties(ServerProperties.class)
public class ServerConfig {

    @Bean // 声明创建 Bean
    @ConditionalOnClass(HttpServer.class) // 需要项目中存在 com.sun.net.httpserver.HttpServer 类。该类为 JDK 自带，所以一定成立。
    public HttpServer httpServer(ServerProperties serverProperties) throws IOException {
        // 创建 HttpServer 对象，并启动
        HttpServer server = HttpServer.create(new InetSocketAddress(serverProperties.getPort()), 0);
        server.start();
        System.out.println(("[httpServer][启动服务器成功，端口为:"+serverProperties.getPort()+"]"));
        // 返回
        return server;
    }
}
