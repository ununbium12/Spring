package survey;

import chapter10.Member;
import chapter10.WrongPasswordException;
import chapter11.AuthInfo;
import controller.SurveyCommand;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

public class SurveyRegisterService {

    @Autowired
    private final SurveyDao surveyDao;


    public void register(SurveyCommand surveyCommand) {
        String q1 = surveyCommand.getQ1();
        String q2 = surveyCommand.getQ2();
        String q3 = surveyCommand.getQ3();
        String respondentName = surveyCommand.getRespondentName();
        int respondentAge = surveyCommand.getRespondentAge();
        LocalDateTime regDate = LocalDateTime.now();

        Survey survey = new Survey(q1, q2, q3, respondentName, respondentAge, regDate);
        surveyDao.saveSurvey(survey);
    }

//    public AuthInfo authenicate(String email, String password) {
//        Member member = memberDao.selectByEmail(email);
//        if (member == null) throw new WrongPasswordException();
//        if (!member.matchPassword(password)) throw new WrongPasswordException();
//        return new AuthInfo(member.getId(), member.getEmail(), member.getName());
//    }
}
