package ru.job4j;

import org.postgresql.core.Logger;

import java.sql.*;

public class SQLStorage {

    private static final Logger log = new Logger();

    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5432/java_a_to_z";
        String username = "postgres";
        String password = "123tester123";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, username, password);
            PreparedStatement st = conn.prepareStatement("delete from users where id =?");
            st.setInt(1, 4);
            st.executeUpdate();
            st.close();
        } catch (Exception e) {
            log.info(e.getMessage(), e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    log.info(e.getMessage(), e);
                }
            }
        }
    }
}
