[![Build Status](https://travis-ci.org/alibaba/dubbo.svg?branch=master)](https://travis-ci.org/alibaba/dubbo) [![Gitter](https://badges.gitter.im/alibaba/dubbo.svg)](https://gitter.im/alibaba/dubbo?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge)

Dubbo is a distributed, high performance RPC framework which empowers applications with service import/export capabilities.

It contains three key parts, which include:

* **Remoting**: a network communication framework providing sync-over-async and request-response messaging.
* **Clustering**: a remote procedure call abstraction with load-balancing/failover/clustering capabilities.
* **Registration**: a service directory framework for service registration and service event publish/subscription

For more details, please refer to [wiki](https://github.com/alibaba/dubbo/wiki) or [dubbo.io](http://dubbo.io).

## 修改内容摘要

本项目源码 forked from [alibaba/dubbo](https://github.com/alibaba/dubbo), 相对于原来版本2.5.4-SNAPSHOT, 修改了如下内容：

1) 解决ArrayList的子类在进行序列化时丢失属性的问题，涉及的类：
```
    com.alibaba.com.caucho.hessian.io.CollectionSerializer
    com.alibaba.com.caucho.hessian.io.CollectionDeserializer
```

2) 解决ArrayList的子类经序列化后，在反序列化时被识别为ArrayList的问题，涉及的类：
```
    com.alibaba.com.caucho.hessian.io.Hessian2Input:
```




