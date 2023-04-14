package controller;

import org.hibernate.validator.constraints.NotBlank;
import survey.Survey;
import survey.SurveyDao;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class SurveyCommand {
    private final SurveyDao surveyDao;

    public SurveyCommand(SurveyDao surveyDao) {
        this.surveyDao = surveyDao;
    }

    public void saveSurvey(String Q1, String Q2, String Q3, String RespondentName, int RespondentAge, LocalDateTime REGDATE) {
        Survey survey = new Survey(Q1, Q2, Q3, RespondentName, RespondentAge, REGDATE);
        surveyDao.saveSurvey(survey);
    }

    @NotBlank
    private String name;

    @NotNull
    private int age;

    @NotBlank
    private String field;

}
