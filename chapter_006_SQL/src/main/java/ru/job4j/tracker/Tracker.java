package ru.job4j.tracker;

import org.postgresql.core.Logger;

import java.sql.*;
import java.util.*;
import java.lang.System;

/**
 * @author vsokolov
 * @version $Id$
 * @since 0.1
 */
public class Tracker implements AutoCloseable {

    private Connection con = null;
    private final Logger log = new Logger();

    public Tracker(Connection con) {
        this.con = con;
    }

    /**
     * Метод реализаущий добавление заявки в хранилище
     * @param item новая заявка
     */
    public void add(Item item) {
        try {
            PreparedStatement ps = this.con.prepareStatement(
                    "INSERT into item (name, message) values (?, ?)");
            ps.setString(1, item.getName());
            ps.setString(2, item.getMessage());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            log.info(e.getMessage(), e);
        } finally {
            if (this.con != null) {
                try {
                    this.con.close();
                } catch (SQLException e) {
                    log.info(e.getMessage(), e);
                }
            }
        }
    }

    /**
     * Метод реализаущий редактирование заявки в хранилище
     * @param item редаkтируемая заявка
     */
    public void replace(Item item, int id) {
        try {
            PreparedStatement ps = this.con.prepareStatement(
                    "update item set name = ?, message = ? where id =?");
            ps.setString(1, item.getName());
            ps.setString(2, item.getMessage());
            ps.setInt(3, id);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            log.info(e.getMessage(), e);
        } finally {
            if (this.con != null) {
                try {
                    this.con.close();
                } catch (SQLException e) {
                    log.info(e.getMessage(), e);
                }
            }
        }
    }

    /**
     * Method deletes an item from the array.
     * @param id - to delete
     */
    public void delete(int id) {
        try {
            PreparedStatement ps = this.con.prepareStatement(
                    "delete from item where id =?");
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            log.info(e.getMessage(), e);
        } finally {
            if (this.con != null) {
                try {
                    this.con.close();
                } catch (SQLException e) {
                    log.info(e.getMessage(), e);
                }
            }
        }
    }

    /**
     * Method returns a list of all the items.
     */
    public List<Item> findAll() {
        List<Item> result = new ArrayList<>();
        try {
            PreparedStatement ps = this.con.prepareStatement(
                    "SELECT * FROM item");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Item i = new Item(rs.getString("name"), rs.getString("message"));
                result.add(i);
                System.out.println(String.format("%d %s %s",
                        rs.getInt("id"), rs.getString("name"), rs.getString("message")));
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            log.info(e.getMessage(), e);
        } finally {
            if (this.con != null) {
                try {
                    this.con.close();
                } catch (SQLException e) {
                    log.info(e.getMessage(), e);
                }
            }
        }
        return result;
    }

    /**
     * Method returns a list of all the items with a given name.
     * param@ key - given name.
     */
    public List<Item> findByName(String key) {
        List<Item> result = new ArrayList<>();
        try {
            PreparedStatement ps = this.con.prepareStatement(
                    "SELECT * FROM item where name = ?");
            ps.setString(1, key);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Item i = new Item(rs.getString("name"), rs.getString("message"));
                result.add(i);
                System.out.println(String.format("%d %s %s",
                        rs.getInt("id"), rs.getString("name"), rs.getString("message")));
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            log.info(e.getMessage(), e);
        } finally {
            if (this.con != null) {
                try {
                    this.con.close();
                } catch (SQLException e) {
                    log.info(e.getMessage(), e);
                }
            }
        }
        return result;
    }

    /**
     * Method returns a item with a given id.
     * param@ id - given id.
     */
    public Item findById(int id) {
        Item result = new Item("not found", "not found");
        try {
            PreparedStatement ps = this.con.prepareStatement(
                    "SELECT * FROM item where id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
                result.setName(rs.getString("name"));
                result.setMessage(rs.getString("message"));
                System.out.println(String.format("%d %s %s",
                        rs.getInt("id"), rs.getString("name"), rs.getString("message")));
            rs.close();
            ps.close();
        } catch (Exception e) {
            log.info(e.getMessage(), e);
        } finally {
            if (this.con != null) {
                try {
                    this.con.close();
                } catch (SQLException e) {
                    log.info(e.getMessage(), e);
                }
            }
        }
        return result;
    }

    /**
     * Method checks whether a table exists in schema
     * and if it does not - adds the table to database
     * param@ tableName
     */
    public void checkForTable(String tableName) {
        try {
            PreparedStatement ps = this.con.prepareStatement(
                    "SELECT * FROM nformation_schema.tables where table_name = ?");
            ps.setString(1, tableName);
            ResultSet rs = ps.executeQuery();
            if (!rs.next()) {
                try {
                    PreparedStatement ps1 = this.con.prepareStatement(
                            "create table tableName(id serial primary key, name varchar(200), message text)");
                    ps1.executeUpdate();
                    ps1.close();
                } catch (Exception e) {
                    log.info(e.getMessage(), e);
                } finally {
                    if (this.con != null) {
                        try {
                            this.con.close();
                        } catch (SQLException e) {
                            log.info(e.getMessage(), e);
                        }
                    }
                }
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            log.info(e.getMessage(), e);
        } finally {
            if (this.con != null) {
                try {
                    this.con.close();
                } catch (SQLException e) {
                    log.info(e.getMessage(), e);
                }
            }
        }
    }

    @Override
    public void close() throws Exception {
        this.con.close();
    }
}