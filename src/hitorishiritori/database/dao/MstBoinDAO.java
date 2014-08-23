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

/**
 *
 * @author pbws_bis
 */
public class MstBoinDAO {
    private final static String DB_NANE = "db/hitorishiritori";
    
    public static ArrayList<String> select(String chara){
        ArrayList<String> res = new ArrayList<>();
        Connection conn = SQLiteDBManager.getConnection(DB_NANE);
        try{
            Statement stmt = conn.createStatement();
            String sql = "select boin from mst_boin where chars like '%" + chara + "%'";
            ResultSet result = stmt.executeQuery(sql);
            while(result.next()){
                res.add(result.getString("boin"));
            }
        } catch (SQLException ex){
            
        }
        return res;
    }
}
