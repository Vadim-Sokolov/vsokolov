package ru.job4j.sqlite;

import org.postgresql.core.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @author vsokolov
 * @version $Id$
 * @since 0.1
 */
public class StoreSQL {

    private static final Logger log = new Logger();
    private Connection conn;

    public StoreSQL(Connection conn) {
        this.conn = conn;
    }

    public void checkForTable(String name) {
        try {
            PreparedStatement ps = this.conn.prepareStatement(
                    "SELECT * FROM information_schema.tables where table_name = ?");
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            if (!rs.next()) {
                try {
                    Statement stmt = conn.createStatement();
                    String sql = "CREATE TABLE name(field integer)";
                    stmt.executeUpdate(sql);
                    stmt.close();
                    conn.close();
                } catch (Exception e) {
                    log.info(e.getMessage(), e);
                }
            }rs.close();
            ps.close();
        } catch (Exception e) {
            log.info(e.getMessage(), e);
        }
    }

    public void generate(int number) {
        try {
            for(int i = 0; i < number; i++) {
                PreparedStatement ps = this.conn.prepareStatement(
                        "INSERT into entry (field) values (?)");
                ps.setInt(1, i);
                ps.executeUpdate();
                ps.close();
            }
        } catch (Exception e) {
            log.info(e.getMessage(), e);
        }
    }
}

