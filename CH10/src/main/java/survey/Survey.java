package survey;

import java.time.LocalDateTime;

public class Survey {

    private Long id;

    private String Q1;

    private String Q2;

    private String Q3;

    private String RespondentName;

    private int RespondentAge;

    private LocalDateTime REGDATE;

    public Survey(String Q1, String Q2, String Q3, String RespondentName, int RespondentAge, LocalDateTime REGDATE) {
        this.Q1 = Q1;
        this.Q2 = Q2;
        this.Q3 = Q3;
        this.RespondentName = RespondentName;
        this.RespondentAge = RespondentAge;
        this.REGDATE = REGDATE;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQ1() {
        return Q1;
    }

    public String getQ2() {
        return Q2;
    }

    public String getQ3() {
        return Q3;
    }

    public String getRespondentName() {
        return RespondentName;
    }

    public void setRespondentAge(int respondentAge) {
        this.RespondentAge = respondentAge;
    }

    public int getRespondentAge() {
        return RespondentAge;
    }

    public LocalDateTime getREGDATE() {
        return REGDATE;
    }

    public void setREGDATE(LocalDateTime REGDATE) {
        this.REGDATE = REGDATE;
    }
}
