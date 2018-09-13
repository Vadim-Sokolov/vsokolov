package ru.job4j.sqlite;

import org.postgresql.core.Logger;

import java.sql.*;

/**
 * @author vsokolov
 * @version $Id$
 * @since 0.1
 */
public class StoreRunner {

    private static final Logger log = new Logger();

    public static void main( String args[] ) throws SQLException {
        Connection conn = null;
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:test.db");
            System.out.println("Opened database successfully");
            StoreSQL ssql = new StoreSQL(conn);
            ssql.checkForTable("entry");
            ssql.generate(10);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM COMPANY;" );
            while ( rs.next() ) {
                System.out.println(rs.getInt("entry"));
            }
        } catch (Exception e) {
            log.info(e.getMessage(), e);
        }finally {
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
