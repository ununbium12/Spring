package chapter07;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemberDao {

    private JdbcTemplate jdbcTemplate;
    public MemberDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public class MemberRowMapper implements RowMapper<Member> {
        @Override
        public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
            Member member = new Member(
                    rs.getString("EMAIL"),
                    rs.getString("PASSWORD"),
                    rs.getString("NAME"),
                    rs.getTimestamp("REGDATE").toLocalDateTime());
            member.setId(rs.getLong("ID"));
            return member;
        }
    }

    public Member selectByEmail(String email) {
        List<Member> results = jdbcTemplate.query(
                "select * from MEMBER where EMAIL = ?",
                new MemberRowMapper(), email);
        return results.isEmpty() ? null :results.get(0);
    }

    public List<Member> selectAll() {
        List<Member> result = jdbcTemplate.query(
                "select * from MEMBER",
                new MemberRowMapper());
        return result;
    }

    public int count() {
        int result = jdbcTemplate.queryForObject(
                "select count(*) from MEMBER",
                Integer.class);
        return result;
    }
    public void update(Member member){
        jdbcTemplate.update("update MEMBER set Name = ?, PASSWORD =? where EMAIL = ?",
                member.getName(),member.getPassword(),member.getEmail());
    }
    public void insert(Member member){
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement preparedStatement = con.prepareStatement(
                        "insert into MEMBER (EMAIL, PASSWORD, NAME, REGDATE) values (?,?,?,?)",
                        new String[] {"ID"});
                preparedStatement.setString(1,member.getEmail());
                preparedStatement.setString(2,member.getPassword());
                preparedStatement.setString(3,member.getName());
                preparedStatement.setTimestamp(4, Timestamp.valueOf(member.getRegisterDateTime()));

                return preparedStatement;
            }
        }, keyHolder);
    Number keyValue = keyHolder.getKey();
    member.setId(keyValue.longValue());
    }
}