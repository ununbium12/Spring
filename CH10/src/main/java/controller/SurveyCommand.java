package controller;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Min;

public class SurveyCommand {

    @NotEmpty
    private String q1;

    @NotEmpty
    private String q2;

    @NotBlank
    private String q3;

    @NotBlank
    private String respondentName;

    @Min(1)
    private int respondentAge;


    public String getQ1() {
        return q1;
    }

    public void setQ1(String q1) {
        this.q1 = q1;
    }

    public String getQ2() {
        return q2;
    }

    public void setQ2(String q2) {
        this.q2 = q2;
    }

    public String getQ3() {
        return q3;
    }

    public void setQ3(String q3) {
        this.q3 = q3;
    }

    public String getRespondentName() {
        return respondentName;
    }

    public void setRespondentName(String respondentName) {
        this.respondentName = respondentName;
    }

    public int getRespondentAge() {
        return respondentAge;
    }

    public void setRespondentAge(int respondentAge) {
        this.respondentAge = respondentAge;
    }
}

