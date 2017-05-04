package mmry.eureka_feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloControler {
	@Autowired
    HelloService helloService;
	@Value("${test}")
	String appName;
    @RequestMapping(value = "/hello")
    public String hi(@RequestParam String name){
        return helloService.sayHello("feign:"+name);
    }
    @RequestMapping(value = "/mmry")
    public String say(@RequestParam String name){
        return helloService.sayHello("feign-mmry:"+name+"   appname:"+appName);
    }
}
