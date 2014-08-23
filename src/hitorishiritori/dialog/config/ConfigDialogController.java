/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hitorishiritori.dialog.config;

import hitorishiritori.util.Config;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ws
 */
public class ConfigDialogController implements Initializable {
    @FXML private CheckBox checkTyouon1;
    @FXML private CheckBox checkTyouon2;
    @FXML private CheckBox checkTyouon3;
    @FXML private CheckBox checkYouon1;
    @FXML private CheckBox checkYouon2;
    @FXML private RadioButton radioDakuon1;
    @FXML private RadioButton radioDakuon2;
    
    private ConfigDialog stage;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        checkTyouon1.setSelected(getBooleanProperty("tyouon.boin"));
        checkTyouon2.setSelected(getBooleanProperty("tyouon.intact"));
        checkTyouon3.setSelected(getBooleanProperty("tyouon.ignore"));
        checkYouon1.setSelected(getBooleanProperty("youon.seion"));
        checkYouon2.setSelected(getBooleanProperty("youon.intact"));
        if(getBooleanProperty("dakuon.seion")){
            radioDakuon2.setSelected(true);
        }else {
            radioDakuon1.setSelected(true);
        }
    }

    @FXML
    private void onClickConfigSave(ActionEvent event){
        Config.setProperty("tyouon.boin", String.valueOf(checkTyouon1.isSelected()));
        Config.setProperty("tyouon.intact", String.valueOf(checkTyouon2.isSelected()));
        Config.setProperty("tyouon.ignore", String.valueOf(checkTyouon3.isSelected()));
        Config.setProperty("youon.seion", String.valueOf(checkYouon1.isSelected()));
        Config.setProperty("youon.intact", String.valueOf(checkYouon2.isSelected()));
        Config.setProperty("dakuon.seion", String.valueOf(radioDakuon2.isSelected()));
        stage.setStatus(true);
        stage.close();
    }
    
    @FXML
    private void onClickCancel(ActionEvent event){
        stage.close();
    }
    
    private boolean getBooleanProperty(String propertyName){
        String property = Config.getProperty(propertyName);
        if(!property.isEmpty()){
            return Boolean.valueOf(property);
        }
        return true;
    }
    
    public void setStage(Stage stage){
        this.stage = (ConfigDialog)stage;
    }
}
