package mmry.eureka.provider;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@EnableDiscoveryClient
@SpringBootApplication
@RestController
public class AppProvider {
	public static void main(String[] args) {
		SpringApplication.run(AppProvider.class, args);
	}

	@Value("${server.port}")
	String port;

	@RequestMapping("/hello")
	public String home(@RequestParam String name) {
		return "hello " + name + ",port:" + port;
	}
}
