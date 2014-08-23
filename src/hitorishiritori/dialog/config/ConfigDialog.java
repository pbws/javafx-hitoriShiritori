/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hitorishiritori.dialog.config;

import hitorishiritori.dialog.DialogBase;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Window;

/**
 *
 * @author ws
 */
public class ConfigDialog extends DialogBase<Boolean>{
    
    public ConfigDialog(Window owner) {
        super(owner);
        status = false;
    }
    
    @Override
    public ConfigDialog init() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ConfigDialogView.fxml"));
        try {
            loader.load();
            Parent root = loader.getRoot();

            ConfigDialogController control = loader.getController();
            control.setStage(this);

            Scene scene = new Scene(root);
            this.setScene(scene);
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
        return this;
    }    
}
