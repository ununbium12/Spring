package survey;

import controller.SurveyCommand;

import java.time.LocalDateTime;

public class Survey {

    private Long id;
    private String q1;
    private String q2;
    private String q3;
    private String RespondentName;
    private int RespondentAge;
    private LocalDateTime REGDATE;

    public Survey(String q1, String q2, String q3, String RespondentName, int RespondentAge, LocalDateTime REGDATE) {
        this.q1 = q1;
        this.q2 = q2;
        this.q3 = q3;
        this.RespondentName = RespondentName;
        this.RespondentAge = RespondentAge;
        this.REGDATE = REGDATE;
    }

    void setId(long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getQ1() {
        return q1;
    }

    public String getQ2() {
        return q2;
    }

    public String getQ3() {
        return q3;
    }

    public String getRespondentName() {
        return RespondentName;
    }

    public int getRespondentAge() {
        return RespondentAge;
    }

    public LocalDateTime getREGDATE() {
        return REGDATE;
    }

    public Survey(SurveyCommand surveyCommand) {
        this.q1 = surveyCommand.getQ1();
        this.q2 = surveyCommand.getQ2();
        this.q3 = surveyCommand.getQ3();
        this.RespondentName = surveyCommand.getRespondentName();
        this.RespondentAge = surveyCommand.getRespondentAge();
        this.REGDATE = LocalDateTime.now();
    }

}
