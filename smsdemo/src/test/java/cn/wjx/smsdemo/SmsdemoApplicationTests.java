package cn.wjx.smsdemo;

import cn.wjx.smsdemo.utils.SMSTool;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SmsdemoApplicationTests {


    @Test
    void contextLoads() {
        SMSTool tool = new SMSTool();
        tool.sendMsg("18711700638,18768334589","SMS_187751765","{\"code\":\"5542\"}");
    }

}
