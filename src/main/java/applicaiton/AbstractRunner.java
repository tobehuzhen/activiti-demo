package applicaiton;

import org.activiti.engine.*;

/**
 * Created by huzhen on 2017/11/2.
 */
public abstract class AbstractRunner {
    private ProcessEngine processEngine;
    protected RepositoryService repositoryService;
    protected RuntimeService runtimeService;
    protected TaskService taskService;
    protected FormService formService;
    protected HistoryService historyService;
    protected IdentityService identityService;
    protected ManagementService managementService;

    public AbstractRunner(){
        if(processEngine==null) {
            //此处使用此种方法调用的activiti的配置文件为 classpath路径下的activiti.cfg.xml
            //采用的H2的数据库
            processEngine = ProcessEngines.getDefaultProcessEngine();
        }
        //获取工作流的各种服务信息
        repositoryService = processEngine.getRepositoryService();
        runtimeService = processEngine.getRuntimeService();
        taskService = processEngine.getTaskService();
        formService = processEngine.getFormService();
        historyService = processEngine.getHistoryService();
        identityService = processEngine.getIdentityService();
        managementService = processEngine.getManagementService();
        //调用扩展的初始化工作
        initialize();
    }

    public abstract void initialize();

    public RuntimeService getRuntimeService(){
        return runtimeService;
    }

    public RepositoryService getRepositoryService(){
        return repositoryService;
    }

    public TaskService getTaskService(){return taskService;}

    public HistoryService getHistoryService(){return historyService;}
}
