package com.personal.activiti.listener;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.ExecutionListener;

import java.util.Date;

/**
 * Created by huzhen on 2017/11/3.
 */
public class EndEventExecutionListener implements ExecutionListener{
    public void notify(DelegateExecution delegateExecution) throws Exception {
        System.out.println("===流程结束==="+new Date());
    }
}
