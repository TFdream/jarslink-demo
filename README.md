# jarslink-demo
alibaba jarslink 示例demo。

## 模块
| 模块 | 说明 |
| --- | --- |
| main-module | 用于加载模块JAR包，对外提供服务|
| user-service | 获取用户信息Action | 
| order-service | 获取订单信息Action |

## 使用说明
步骤如下：
1. 根路径下执行``` mvn clean package```命令 将user-service和order-service打成jar包；
2. 将main-module中```io.dreamstudio.jarslink.main.config.ModuleRefreshSchedulerImpl```类中的PATH参数值换成你本地路径；
3. 启动```io.dreamstudio.jarslink.main.MainApplication``` 中的main方法；
4. 浏览器请求 ``` http://localhost:8080/api/user-service/user/{nickname}``` 获取模块用户信息；
5. 浏览器请求 ``` http://localhost:8080/api/order-service/order/{order-id}``` 获取模块订单信息；
6. 修改UserAction代码，重新打包user-service并将user-service-1.0.0-SNAPSHOT.jar拷贝到，浏览器请求上一步路径，发现已经热更新成功。

## 文档
* [如何使用](https://github.com/alibaba/taitan/wiki/%E5%A6%82%E4%BD%95%E4%BD%BF%E7%94%A8)
* [实现原理](https://github.com/alibaba/taitan/wiki/%E5%AE%9E%E7%8E%B0%E5%8E%9F%E7%90%86)
* [应用场景](https://github.com/alibaba/taitan/wiki/%E5%BA%94%E7%94%A8%E5%9C%BA%E6%99%AF)
* [高级特性](https://github.com/alibaba/taitan/wiki/%E9%AB%98%E7%BA%A7%E7%89%B9%E6%80%A7)
