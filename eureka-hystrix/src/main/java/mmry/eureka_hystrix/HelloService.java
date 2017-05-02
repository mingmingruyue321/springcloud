package mmry.eureka_hystrix;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "mmry-provider-demo",fallback=SchedualServiceHiHystric.class)
public interface HelloService {
	@RequestMapping(value = "/hello",method = RequestMethod.GET)
    String sayHello(@RequestParam(value = "name") String name);
}
