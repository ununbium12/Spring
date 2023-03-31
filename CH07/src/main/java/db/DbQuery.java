package db;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Component
public class DbQuery {

    @Autowired
    private DataSource dataSource;

    public int count() {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();

            try (
                    Statement statement = connection.createStatement();
                    ResultSet rs =
                            statement.executeQuery("select count(*) from MEMBER")) {
                rs.next();
                return rs.getInt(1);
            }
        } catch (SQLException e) {
                throw new RuntimeException(e);
        } finally {
            if(connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {}
            }
        }
    }
}

