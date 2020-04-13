package cn.wjx.smsdemo.utils;

import com.alibaba.fastjson.JSON;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
public class SMSTool {

    //替换成你的AccessKey

    final String accessKeyId ="";//你的accessKeyId,

    final String accessKeySecret ="";//你的accessKeySecret

    /**

     * 短信发送接口信息  支持批量发送 ps--目前签名信息仅设置一个

     *

     * @param phone        需要发送的电话号码，支持多个电话号码 格式为"13600000000,15000000000"

     * @param templateCode  明确需要使用哪个模板，可以从阿里云控制台查看

     * @param templateParam 模板内需要填充的字段及字段值 格式为("{\"name\":\"Tom\", \"code\":\"123\"}")

     * @Return true 代表发送成功  false 代表发送失败

     */

    public boolean sendMsg(String phone, String templateCode, String templateParam) {

        boolean bool =false;

        DefaultProfile profile = DefaultProfile.getProfile("default",accessKeyId,accessKeySecret);

        IAcsClient client =new DefaultAcsClient(profile);

        CommonRequest request =new CommonRequest();

        request.setMethod(MethodType.POST);

        request.setDomain("dysmsapi.aliyuncs.com");

        request.setVersion("2017-05-25");// 版本信息  已经固定  不能进行更改

//必填:待发送手机号。支持以逗号分隔的形式进行批量调用，批量上限为1000个手机号码,批量调用相对于单条调用及时性稍有延迟,验证码类型的短信推荐使用单条调用的方式；发送国际/港澳台消息时，接收号码格式为国际区号+号码，如“85200000000”

        request.putQueryParameter("PhoneNumbers", phone);

        //  阿里云控制台签名

        String signName ="控制台签名";

        request.putQueryParameter("SignName", signName);

        // 阿里云控制台模板编号

        request.putQueryParameter("TemplateCode", templateCode);

        request.setAction("SendSms");//系统规定参数

        // 模板内需要填充参数信息

        request.putQueryParameter("TemplateParam", templateParam);

        try {

            log.info("调用阿里云短信服务请求 phone={}，templateCode={},templateParam={}", phone, templateCode, templateParam);

            CommonResponse response = client.getCommonResponse(request);

            // 下面是一个json格式转换工具，把String 转换为map 也可以转换为对象

            Map map = JSON.parseObject(response.getData());

            if ("OK".equals(map.get("Code"))) {

                bool =true;

            }

        }catch (ServerException e) {

            log.error("阿里云短信服务异常:{}", e);

        }catch (ClientException e) {

            log.error("连接阿里云短信异常:{}", e);

        }catch (Exception e) {

            log.error("json转换异常:{}", e);

        }

        return bool;

    }
}
