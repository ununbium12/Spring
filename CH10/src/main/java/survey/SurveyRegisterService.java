package survey;

import controller.SurveyCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class SurveyRegisterService {

    private SurveyDao surveyDao;

    @Autowired
    public SurveyRegisterService(SurveyDao surveyDao) {
        this.surveyDao = surveyDao;
    }

    public void update(SurveyCommand surveyCommand) {
        int respondentAge = Integer.parseInt(String.valueOf(surveyCommand.getRespondentAge()));
        Survey survey = new Survey(
                surveyCommand.getQ1(),
                surveyCommand.getQ2(),
                surveyCommand.getQ3(),
                surveyCommand.getRespondentName(),
                respondentAge,
                LocalDateTime.now()
        );
        surveyDao.insert(survey);
    }
}
