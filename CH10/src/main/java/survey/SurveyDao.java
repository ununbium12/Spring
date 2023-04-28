package survey;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;

public class SurveyDao {

    private JdbcTemplate jdbcTemplate;

    public SurveyDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.jdbcTemplate.setDataSource(dataSource);
    }

    public class SurveyRowMapper implements RowMapper<Survey> {
        @Override
        public Survey mapRow(ResultSet resultSet, int rowNum) throws SQLException {
            Survey survey = new Survey(
                    resultSet.getString("Q1"),
                    resultSet.getString("Q2"),
                    resultSet.getString("Q3"),
                    resultSet.getString("RespondentName"),
                    resultSet.getInt("RespondentAge"),
                    resultSet.getTimestamp("REGDATE").toLocalDateTime());
            survey.setId(resultSet.getLong("ID"));
            return survey;
        }
    }

    public List<Survey> selectAll() {
        String sql = "SELECT * FROM SURVEY";
        return jdbcTemplate.query(sql, new SurveyRowMapper());
    }


    public void insert(Survey survey) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement preparedStatement = con.prepareStatement(
                        "insert into SURVEY (Q1, Q2, Q3, RespondentName, RespondentAge, REGDATE) values (?,?,?,?,?,?)",
                        Statement.RETURN_GENERATED_KEYS);
                preparedStatement.setString(1, survey.getQ1());
                preparedStatement.setString(2, survey.getQ2());
                preparedStatement.setString(3, survey.getQ3());
                preparedStatement.setString(4, survey.getRespondentName());
                preparedStatement.setInt(5, survey.getRespondentAge());
                preparedStatement.setTimestamp(6, Timestamp.valueOf(survey.getREGDATE()));
                return preparedStatement;
            }
        }, keyHolder);
        Number keyValue = keyHolder.getKey();
        survey.setId(keyValue.longValue());
        try {
            Connection connection = jdbcTemplate.getDataSource().getConnection();
            connection.commit();
        } catch (SQLException ex) {
            System.err.println("SQL exception occurred: " + ex.getMessage());
        }
    }
}
