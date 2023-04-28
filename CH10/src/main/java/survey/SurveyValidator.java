package survey;

import controller.SurveyCommand;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class SurveyValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return SurveyCommand.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        SurveyCommand surveyCommand = (SurveyCommand) target;

        if(surveyCommand.getQ1() == null || surveyCommand.getQ1().trim().isEmpty()) {
            errors.rejectValue("q1", "NotEmpty");
        }
        if (surveyCommand.getQ2() == null || surveyCommand.getQ2().trim().isEmpty()) {
            errors.rejectValue("q2", "NotEmpty");
        }
        if (surveyCommand.getQ3() == null || surveyCommand.getQ3().trim().isBlank()) {
            errors.rejectValue("q3", "NotBlank");
        }
        if (surveyCommand.getRespondentName() == null || surveyCommand.getRespondentName().trim().isBlank()) {
            errors.rejectValue("respondentName", "NotBlank");
        }
        if (surveyCommand.getRespondentAge() < 1) {
            errors.rejectValue("respondentAge", "Min", new Object[]{1}, "Min");
        }
    }
}
