package mmry.eureka_hystrix;

import org.springframework.stereotype.Component;

@Component
public class SchedualServiceHiHystric implements HelloService{

	@Override
	public String sayHello(String name) {
		return "error";
	}

}
