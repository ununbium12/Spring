package config;

import chapter11.AuthService;
import controller.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import survey.SurveyDao;
import survey.SurveyRegisterService;

import javax.sql.DataSource;

@Configuration
public class ControllerConfig {

    @Autowired
    private AuthService authService;

    @Autowired
    private SurveyRegisterService surveyRegisterService;

    @Bean
    public RegisterController registerController() {
        return new RegisterController();
    }

    @Bean
    public MainController mainController() {
        return new MainController();
    }

    @Bean
    public HelloController helloController() {
        return new HelloController();
    }

    @Bean
    public SurveyController surveyController() {
        return new SurveyController(surveyRegisterService);
    }

    @Bean
    public LoginController loginController() {
        LoginController loginController= new LoginController();
        loginController.setAuthService(authService);
        return loginController;
    }

    @Bean
    public SurveyRegisterService surveyRegisterService(SurveyDao surveyDao) {
        return new SurveyRegisterService(surveyDao);
    }

    @Bean
    public SurveyDao surveyDao(DataSource dataSource) {
        return new SurveyDao(dataSource);
    }
}
