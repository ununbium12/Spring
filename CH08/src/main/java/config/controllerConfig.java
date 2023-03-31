package config;

import controller.HelloController;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;

@Controller
public class controllerConfig {

    @Bean
    public HelloController helloController() {
        return new HelloController();
    }
}
