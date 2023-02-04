package com.zpb.component;

import com.xxl.job.core.context.XxlJobHelper;
import com.xxl.job.core.handler.annotation.XxlJob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author pengbo.zhao
 */

@Slf4j
@Component
public class XxlJobDemoHandler {

    /**
     * 1、任务开发：在Spring Bean实例中，开发Job方法；
     * 2、注解配置：为Job方法添加注解 "@XxlJob(value="自定义jobhandler名称", init = "JobHandler初始化方法", destroy = "JobHandler销毁方法")"，注解value值对应的是调度中心新建任务的JobHandler属性的值。
     * 3、执行日志：需要通过 "XxlJobHelper.log" 打印执行日志；
     * 4、任务结果：默认任务结果为 "成功" 状态，不需要主动设置；
     *      如有诉求，比如设置任务结果为失败，可以通过 "XxlJobHelper.handleFail/handleSuccess" 自主设置任务结果；
     */
    @XxlJob("demoJobHandler")
    public void demoJobHandler() throws Exception {
        XxlJobHelper.log("XXL-JOB, Hello World.");
        XxlJobHelper.log("param : [{}]",XxlJobHelper.getJobParam());

        System.err.println("XXL-JOB, Hello World.");
        System.err.println("param: "+XxlJobHelper.getJobParam());

    }

}