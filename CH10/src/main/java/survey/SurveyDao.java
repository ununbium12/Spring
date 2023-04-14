package survey;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SurveyDao {
    private final String url;
    private final String username;
    private final String password;

    public SurveyDao(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public List<Survey> getAllSurveys() {
        List<Survey> surveys = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM SURVEY");
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Long id = rs.getLong("ID");
                String q1 = rs.getString("Q1");
                String q2 = rs.getString("Q2");
                String q3 = rs.getString("Q3");
                String respondentName = rs.getString("RespondentName");
                int respondentAge = rs.getInt("RespondentAge");
                LocalDateTime regDate = rs.getTimestamp("REGDATE").toLocalDateTime();
                surveys.add(new Survey(q1, q2, q3, respondentName, respondentAge, regDate));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return surveys;
    }

    public Survey getSurveyById(Long id) {
        Survey survey = null;
        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM SURVEY WHERE ID = ?")) {
            stmt.setLong(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String q1 = rs.getString("Q1");
                    String q2 = rs.getString("Q2");
                    String q3 = rs.getString("Q3");
                    String respondentName = rs.getString("RespondentName");
                    int respondentAge = rs.getInt("RespondentAge");
                    LocalDateTime regDate = rs.getTimestamp("REGDATE").toLocalDateTime();
                    survey = new Survey(q1, q2, q3, respondentName, respondentAge, regDate);
                    survey.setId(id);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return survey;
    }

    public void saveSurvey(Survey survey) {
        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO SURVEY(Q1, Q2, Q3, RespondentName, RespondentAge, REGDATE) VALUES(?, ?, ?, ?, ?, ?)")) {
            stmt.setString(1, survey.getQ1());
            stmt.setString(2, survey.getQ2());
            stmt.setString(3, survey.getQ3());
            stmt.setString(4, survey.getRespondentName());
            stmt.setInt(5, survey.getRespondentAge());
            stmt.setTimestamp(6, Timestamp.valueOf(survey.getREGDATE()));
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void updateSurvey(Survey survey) {
        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement stmt = conn.prepareStatement("UPDATE SURVEY SET Q1 = ?, Q2 = ?, Q3 = ?, RespondentName = ?, RespondentAge = ?, REGDATE = ? WHERE ID = ?")) {
            stmt.setString(1, survey.getQ1());
            stmt.setString(2, survey.getQ2());
            stmt.setString(3, survey.getQ3());
            stmt.setString(4, survey.getRespondentName());
            stmt.setInt(5, survey.getRespondentAge());
            stmt.setObject(6, survey.getREGDATE());
            stmt.setLong(7, survey.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}