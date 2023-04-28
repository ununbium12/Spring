package chapter11;

import chapter10.Member;
import chapter10.MemberDao;
import chapter10.WrongPasswordException;
import org.springframework.beans.factory.annotation.Autowired;
import survey.Survey;
import survey.SurveyDao;

public class AuthService {

    @Autowired
    private MemberDao memberDao;

    public AuthInfo authenicate(String email, String password) {
        Member member = memberDao.selectByEmail(email);
        if (member == null) throw new WrongPasswordException();
        if (!member.matchPassword(password)) throw new WrongPasswordException();
        return new AuthInfo(member.getId(), member.getEmail(), member.getName());
    }

}
