package cn.hotol.bp.dingding;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class DingConfig {

    @Bean(initMethod = "init",destroyMethod = "destroy")
    @ConfigurationProperties(prefix = "ding.default")
    @Scope("singleton")
    public MyDing getMyDing(){
        return new MyDing();
    }
}
