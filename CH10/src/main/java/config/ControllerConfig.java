package config;

import controller.HelloController;
import controller.MainController;
import controller.RegistController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ControllerConfig {

    @Bean
    public HelloController helloController() {
        return new HelloController();
    }

    @Bean
    public RegistController registController() {
        return new RegistController();
    }

    @Bean
    public MainController mainController() {
        return new MainController();
    }
}
