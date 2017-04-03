[![Build Status](https://travis-ci.org/alibaba/dubbo.svg?branch=master)](https://travis-ci.org/alibaba/dubbo) [![Gitter](https://badges.gitter.im/alibaba/dubbo.svg)](https://gitter.im/alibaba/dubbo?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge)

### 项目说明

本项目源码 forked from [alibaba/dubbo](https://github.com/alibaba/dubbo)， 有关dubbo的用途、原理、文档，请移步：
[alibaba/dubbo](https://github.com/alibaba/dubbo) 或 [wiki](https://github.com/alibaba/dubbo/wiki)。


### 修改内容

本项目源码 forked from [alibaba/dubbo](https://github.com/alibaba/dubbo), 相对于原来版本2.5.4-SNAPSHOT, 修改了如下内容：

1) 解决ArrayList的子类在进行序列化时丢失属性的问题，涉及的类：
```
    com.alibaba.com.caucho.hessian.io.CollectionSerializer
    com.alibaba.com.caucho.hessian.io.CollectionDeserializer
```

2) 解决ArrayList的子类经序列化后，在反序列化时被识别为ArrayList的问题，涉及的类：
```
    com.alibaba.com.caucho.hessian.io.Hessian2Input
```


### 如何编译
1) 本项目的根模块是dubbo-parent, 不是dubbo, 因此只要找到dubbo-parent模块进行compile/package。

2) 若编码报错, 可以试试先下载[opensesame](https://github.com/alibaba/opensesame.git)的源码, 再install到本地仓库。

3) 在dubbo-parent的pom.xml文件中，增加以下内容，使得编译产出为jdk1.6的目标文件或你希望的目标文件版本：
```
	<plugin>
		<groupId>org.apache.maven.plugins</groupId>
		<artifactId>maven-compiler-plugin</artifactId>
		<version>2.5.1</version>
		<configuration>
			<source>1.6</source>
			<target>1.6</target>
			<encoding>utf-8</encoding>
		</configuration>
	</plugin>
```

### 如何调试
  方式一：<br/>
&nbsp;&nbsp;&nbsp;&nbsp;进入模块dubbo-demo，直接运行com.alibaba.dubbo.demo.provider.DemoProvider，即可启动服务； 然后运行DemoConsumer即可运行消费者。

  方式二：<br/>
&nbsp;&nbsp;&nbsp;&nbsp;1) 先安装zookeeper(下载，解压，改名/conf/zoo_sample.cfg -> zoo.cfg 即可)，然后 运行bin/zkServer.bat启动zk；<br/>
&nbsp;&nbsp;&nbsp;&nbsp;2) 进入模块dubbo-demo，直接运行com.alibaba.dubbo.demo.provider.Server，即可启动服务； 然后运行Client即可运行消费者。