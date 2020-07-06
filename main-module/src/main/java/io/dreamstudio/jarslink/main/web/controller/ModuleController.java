package io.dreamstudio.jarslink.main.web.controller;

import com.alipay.jarslink.api.Module;
import com.alipay.jarslink.api.ModuleManager;
import io.dreamstudio.jarslink.commons.entity.ResponseDTO;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Ricky Fung
 */
@RestController
@RequestMapping("/api")
public class ModuleController {

    @Resource
    private ModuleManager moduleManager;

    @RequestMapping("/index")
    public ResponseDTO getServiceName() {
        return ResponseDTO.ok("this JarsLink service main module");
    }

    /**
     * 调用模块
     * @param module
     * @param action
     * @param para
     * @return
     */
    @GetMapping(value = "/{module}/{action}/{para}")
    public ResponseDTO getModule(@PathVariable String module, @PathVariable String action, @PathVariable String para) {
        Module moduleInstance = moduleManager.find(module);
        Assert.notNull(module, "module is null");
        Object result = "";
        switch (action) {
            case "order":
                //根据订单ID查询
                result = moduleInstance.doAction(action, Long.valueOf(para));
                break;
            case "user":
                //根据昵称查询
                result = moduleInstance.doAction(action, para);
                break;
            case "user-query":
                //根据昵称查询
                result = moduleInstance.doAction(action, para);
                break;
            default:
                break;
        }
        return ResponseDTO.ok(result);
    }
}
