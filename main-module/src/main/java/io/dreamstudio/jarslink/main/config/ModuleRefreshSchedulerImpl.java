package io.dreamstudio.jarslink.main.config;

import com.alipay.jarslink.api.ModuleConfig;
import com.alipay.jarslink.api.impl.AbstractModuleRefreshScheduler;
import com.google.common.collect.ImmutableList;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * @author Ricky Fung
 */
public class ModuleRefreshSchedulerImpl extends AbstractModuleRefreshScheduler {
    //替换这个路径为你本地路径
    private static final String PROJECT_DIR = "/Users/apple/Ricky/Code_repo/Github/jarslink-demo/";

    private static final String VERSION = "1.0.0-SNAPSHOT";

    @Override
    public List<ModuleConfig> queryModuleConfigs() {
        return ImmutableList.of(buildUserServiceModuleConfig(), buildOrderServiceModuleConfig());
    }

    private ModuleConfig buildUserServiceModuleConfig() {
        return buildModuleConfig("user-service", VERSION, PROJECT_DIR + "user-service/target/user-service-1.0.0-SNAPSHOT.jar");
    }

    private ModuleConfig buildOrderServiceModuleConfig() {
        return buildModuleConfig("order-service", VERSION, PROJECT_DIR + "order-service/target/order-service-1.0.0-SNAPSHOT.jar");
    }

    private ModuleConfig buildModuleConfig(String moduleName, String version, String jarPath) {
        ModuleConfig moduleConfig = new ModuleConfig();
        try {
            URL demoModule = new URL("file", "", -1, jarPath);
            moduleConfig.setName(moduleName);
            moduleConfig.setEnabled(true);
            moduleConfig.setVersion(version);
            moduleConfig.setModuleUrl(ImmutableList.of(demoModule));
            return moduleConfig;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return moduleConfig;
    }
}
