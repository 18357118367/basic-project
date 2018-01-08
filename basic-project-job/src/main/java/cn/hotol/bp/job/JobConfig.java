package cn.hotol.bp.job;

import com.xxl.job.core.executor.XxlJobExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JobConfig {

    private Logger logger = LoggerFactory.getLogger(JobConfig.class);
    /**
     * xxl-job 服务地址
     */
    @Value("${xxl.job.admin.addresses}")
    private String addresses;
    /**
     * 应用名
     */
    @Value("${xxl.job.executor.appname}")
    private String appname;
    /**
     * 应用IP，默认为空
     */
    @Value("${xxl.job.executor.ip}")
    private String ip;
    /**
     * 应用需要暴露的端口号，自行定义
     */
    @Value("${xxl.job.executor.port}")
    private int port;
    /**
     * 应用要打印的定时任务日志文件地址，例如/data/xxlJob/log
     */
    @Value("${xxl.job.executor.logpath}")
    private String logpath;
    /**
     * 定时任务token默认无
     */
    @Value("${xxl.job.accessToken}")
    private String accessToken;

    @Bean(initMethod = "start", destroyMethod = "destroy")
    public XxlJobExecutor xxlJobExecutor() {
        logger.info(">>>>>>>>>>> xxl-job config init.");
        XxlJobExecutor xxlJobExecutor = new XxlJobExecutor();
        xxlJobExecutor.setIp(ip);
        xxlJobExecutor.setPort(port);
        xxlJobExecutor.setAppName(appname);
        xxlJobExecutor.setAdminAddresses(addresses);
        xxlJobExecutor.setLogPath(logpath);
        xxlJobExecutor.setAccessToken(accessToken);
        return xxlJobExecutor;
    }

}
