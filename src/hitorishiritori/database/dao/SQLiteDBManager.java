/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hitorishiritori.database.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author pbws_bis
 */
public class SQLiteDBManager {
    private static final Map<String, Connection> conns = new HashMap<>();
    private static final Logger logger = LogManager.getLogger();
    
    public static Connection getConnection(String name) {
        if (!conns.containsKey(name)) {
            try {
                //コネクションがない場合
                Class.forName("org.sqlite.JDBC");
                Connection conn = DriverManager.getConnection("jdbc:sqlite:" + name);
                conn.setAutoCommit(false);
                conns.put(name, conn);
            } catch (ClassNotFoundException | SQLException ex) {
                logger.fatal("DBエラー", ex);
                return null;
            }
        }
        return conns.get(name);
    }
}
