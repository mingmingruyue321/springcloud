package mmry.config_client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RefreshScope
public class Hi {
	@Value("${appname}")
    String appname;
    @RequestMapping(value = "/app")
    public String hi(){
        return appname;
    }
}
