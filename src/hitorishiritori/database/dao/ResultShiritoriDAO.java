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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pbws_bis
 */
public class ResultShiritoriDAO{
    private static final String DB_NAME = "db/hitorishiritori";
    
    public static ArrayList<String> select(String word, int mode_flg){
        ArrayList<String> words = new ArrayList<>();
        Connection conn = SQLiteDBManager.getConnection(DB_NAME);
        try {   
            Statement stmt = conn.createStatement();
            String sql = "select word from result_shiritori "
                    + " where mode_flg = " + mode_flg
                    + ((word == null || word.isEmpty()) ? "" : " and word = '" + word + "' ");
            ResultSet result = stmt.executeQuery(sql);
            
            while(result.next()){
                words.add(result.getString("word"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ResultShiritoriDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return words;
    }
    
    public static ArrayList<String> selectTop(long limit, int mode_flg){
        ArrayList<String> words = new ArrayList<>();
        Connection conn = SQLiteDBManager.getConnection(DB_NAME);
        try {   
            Statement stmt = conn.createStatement();
            String sql = "select word from result_shiritori where mode_flg = " + mode_flg 
                    + " order by id desc" 
                    + (limit != 0 ? " limit " + limit : "");
            ResultSet result = stmt.executeQuery(sql);
            
            while(result.next()){
                words.add(result.getString("word"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ResultShiritoriDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return words;
    }
    
    public static int insert(String word, int mode_flg){
        Connection conn = SQLiteDBManager.getConnection(DB_NAME);
        int result = -1;
        try {
            Statement stmt = conn.createStatement();
            String id = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
            String sql = "insert into result_shiritori(id, word, mode_flg) "
                    + "values(" + id  + ",'" + word + "'," + mode_flg + ")";
            result = stmt.executeUpdate(sql);
            conn.commit();
        } catch (SQLException ex){
            try {
                conn.rollback();
            } catch (SQLException ex1) {
                
            }
        }
        return result;
    }
    
    public static int deleteAll(){
        int result = -1;
        Connection conn = SQLiteDBManager.getConnection(DB_NAME);
        try {
            Statement stmt = conn.createStatement();
            String sql = "delete from result_shiritori";
            result = stmt.executeUpdate(sql);
            conn.commit();
        } catch(SQLException ex){
            
        }
        return result;
    }
    
    public static int delte(int mode_flg){
        int result = -1;
        Connection conn = SQLiteDBManager.getConnection(DB_NAME);
        try {
            Statement stmt = conn.createStatement();
            String sql = "delete from result_shiritori where mode_flg = " + mode_flg;
            result = stmt.executeUpdate(sql);
            conn.commit();
        } catch(SQLException ex){
            
        }
        return result;
    }
}
