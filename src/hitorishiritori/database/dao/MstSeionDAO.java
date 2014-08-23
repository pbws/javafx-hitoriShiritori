/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hitorishiritori.database.dao;

import hitorishiritori.database.SQLiteDBManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author pbws_bis
 */
public class MstSeionDAO {
    private final static String DB_NAME = "db/hitorishiritori";
    static Logger logger = LogManager.getLogger();
    
    public static ArrayList<String> select(String chara){
        ArrayList<String> res = new ArrayList<>();
        Connection conn = SQLiteDBManager.getConnection(DB_NAME);
        
        try {
            Statement stmt = conn.createStatement();
            String sql = "select seion from mst_seion where dakuon like '%" + chara + "%'";
            ResultSet result = stmt.executeQuery(sql);
            
            while(result.next()){
                res.add(result.getString("seion"));
            }
        } catch(SQLException ex){
            logger.error("SQL例外",ex);
        }
        return res;
    }
}
