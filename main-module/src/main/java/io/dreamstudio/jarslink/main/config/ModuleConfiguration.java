package io.dreamstudio.jarslink.main.config;

import com.alipay.jarslink.api.impl.ModuleLoaderImpl;
import com.alipay.jarslink.api.impl.ModuleManagerImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Ricky Fung
 */
@Configuration
public class ModuleConfiguration {

    @Bean
    public ModuleLoaderImpl moduleLoader() {
        return new ModuleLoaderImpl();
    }

    @Bean
    public ModuleManagerImpl moduleManager() {
        return new ModuleManagerImpl();
    }

    @Bean
    public ModuleRefreshSchedulerImpl moduleRefreshScheduler() {
        ModuleRefreshSchedulerImpl moduleRefreshScheduler = new ModuleRefreshSchedulerImpl();
        moduleRefreshScheduler.setModuleLoader(moduleLoader());
        moduleRefreshScheduler.setModuleManager(moduleManager());
        //初始化的延迟时间
        moduleRefreshScheduler.setInitialDelay(3);
        //刷新间隔时间
        moduleRefreshScheduler.setRefreshDelay(30);
        return moduleRefreshScheduler;
    }
}
