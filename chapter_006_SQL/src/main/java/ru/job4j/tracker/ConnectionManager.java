package ru.job4j.tracker;

import org.postgresql.core.Logger;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

    private final Logger log = new Logger();

    private String url;
    private String username;
    private String password;
    private Connection conn = null;

    public ConnectionManager(File file) {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            this.url = br.readLine();
            this.username = br.readLine();
            this.password = br.readLine();
        } catch (IOException e) {
            log.info(e.getMessage(), e);
        }
    }

    public Connection getConnection() {
        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            log.info(e.getMessage(), e);
            System.out.println("Failed to create the database connection.");
        }
        return conn;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}