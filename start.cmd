@echo off
start cmd /k "cd  eureka\target&&echo 启动注册中心--8761&&java -jar eureka-0.0.1-SNAPSHOT.jar"
pause
start cmd /k "cd  config\target&&echo 启动配置中心--9001&&java -jar config-0.0.1-SNAPSHOT.jar"
pause
start cmd /k "cd  eureka-provider\target&&echo 启动注册服务provider--7006&&java -jar -Dserver.prot=7006 eureka-provider-0.0.1-SNAPSHOT.jar"
pause
start cmd /k "cd  eureka-provider\target&&echo 启动注册服务provider--7007&&java -jar -Dserver.prot=7007 eureka-provider-0.0.1-SNAPSHOT.jar"
pause
start cmd /k "cd  eureka-consumer\target&&echo 启动注册服务consumer--7001&&java -jar -Dserver.prot=7001 eureka-consumer-0.0.1-SNAPSHOT.jar"
start cmd /k "cd  eureka-consumer\target&&echo 启动注册服务consumer--7002&&java -jar -Dserver.prot=7002 eureka-consumer-0.0.1-SNAPSHOT.jar"
start cmd /k "cd  eureka-feign\target&&echo 启动注册服务feign--7003&&java -jar -Dserver.prot=7003 eureka-feign-0.0.1-SNAPSHOT.jar"
start cmd /k "cd  eureka-feign\target&&echo 启动注册服务feign--7004&&java -jar -Dserver.prot=7004 eureka-feign-0.0.1-SNAPSHOT.jar"