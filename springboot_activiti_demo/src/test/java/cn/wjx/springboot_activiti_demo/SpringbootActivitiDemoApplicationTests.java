package cn.wjx.springboot_activiti_demo;

import org.activiti.api.process.model.ProcessDefinition;
import org.activiti.api.process.model.ProcessInstance;
import org.activiti.api.process.model.builders.ProcessPayloadBuilder;
import org.activiti.api.process.runtime.ProcessRuntime;
import org.activiti.api.runtime.shared.query.Page;
import org.activiti.api.runtime.shared.query.Pageable;
import org.activiti.api.task.model.Task;
import org.activiti.api.task.model.builders.TaskPayloadBuilder;
import org.activiti.api.task.runtime.TaskRuntime;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * springboot 与junit整合，测试流程定义的相关操作
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class SpringbootActivitiDemoApplicationTests {

    @Autowired
    private ProcessRuntime processRuntime;//实现流程定义相关操作

    @Autowired
    private TaskRuntime taskRuntime;//任务相关操作的类

    @Autowired
    private SecurityUtil securityUtil;//Security相关工具类

    //流程定义信息的查看  注意：流程部署工作在activiti7与springboot整合后，会自动部署（需要 将bpmn文件放置在resource/processes/下）
    @Test
    void contextLoads() {
        securityUtil.logInAs("ryandawsonuk");//springsecurity的身份认证
        //分页查询出流程定义信息
        Page<ProcessDefinition> processDefinitionPage = processRuntime.processDefinitions(Pageable.of(0, 10));
        System.out.println(processDefinitionPage.getTotalItems());//查看已部署流程的个数
        //processDefinitionPage。getContent()得到当前部署的每一个流程定义信息
        for(Object pd:processDefinitionPage.getContent()){
            System.out.println(pd);
        }
    }

    //启动流程实例
    @Test
    void testStartInstance(){
        securityUtil.logInAs("ryandawsonuk");
        ProcessInstance processInstance = processRuntime.start(ProcessPayloadBuilder.start().withProcessDefinitionKey("myProcess_1").build());//启动流程实例
        System.out.println("流程实例ID"+processInstance.getId());
    }

    //查询任务，并完成任务
    //任务查询：taskRuntime.tasks()
    @Test
    void testTask(){
        securityUtil.logInAs("erdemedeiros");//指定用户认证信息
        Page<Task> taskPage = taskRuntime.tasks(Pageable.of(0, 10)); //分页查询任务列表
        if(taskPage.getTotalItems()>0){
            //有任务
            for(Task task:taskPage.getContent()){
                //遍历任务列表
                System.out.println("任务"+task);

                //拾取任务
                taskRuntime.claim(TaskPayloadBuilder.claim().withTaskId(task.getId()).build());

                //执行任务
                taskRuntime.complete(TaskPayloadBuilder.complete().withTaskId(task.getId()).build());

            }
        }
        Page<Task> taskPage2 = taskRuntime.tasks(Pageable.of(0, 10)); //分页查询任务列表

        if(taskPage2.getTotalItems()>0){
            System.out.println("任务："+taskPage2.getContent());
        }
    }
}
