package config;

import chapter11.AuthService;
import controller.HelloController;
import controller.LoginController;
import controller.MainController;
import controller.RegisterController;
import controller.SurveyController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import survey.SurveyRegisterService;

@Configuration
public class ControllerConfig {

    @Autowired
    private AuthService authService;

    @Autowired
    private SurveyRegisterService surveyRegisterService;

    @Bean
    public MainController mainController() {
        return new MainController();
    }

    @Bean
    public RegisterController registerController() {
        return new RegisterController();
    }

    @Bean
    public HelloController helloController() {
        return new HelloController();
    }

    @Bean
    public SurveyController surveyController() {
        SurveyController surveyController = new SurveyController();
        surveyController.setSurveyController(surveyRegisterService);
        return surveyController;
    }

    @Bean
    public LoginController loginController() {
        LoginController loginController = new LoginController();
        loginController.setAuthService(authService);
        return loginController;
    }
}
