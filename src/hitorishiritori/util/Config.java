/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hitorishiritori.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ws
 */
public class Config {
    private final static File file = new File(get_currentpath() +  "/config/config.property");

    public static String getProperty(String propertyName){
        Properties prop = new Properties();
        try {
            prop.load(new FileInputStream(file));
            String p = prop.getProperty(propertyName);
            return p == null ? "" : p;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Config.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Config.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
    
    public static void setProperty(String propertyName, String propertyValue){
        Properties prop = new Properties();
        try {
            prop.load(new FileInputStream(file));
            prop.setProperty(propertyName, propertyValue);
            prop.store(new FileOutputStream(file), null);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Config.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Config.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static String get_currentpath() {
        String cp = System.getProperty("java.class.path");
        String fs = System.getProperty("file.separator");
        String acp = (new File(cp)).getAbsolutePath();
        int p, q;
        for (p = 0; (q = acp.indexOf(fs, p)) >= 0; p = q + 1){};
        return acp.substring(0, p);
    }
}
