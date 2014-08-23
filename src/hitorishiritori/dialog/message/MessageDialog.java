/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hitorishiritori.dialog.message;

import hitorishiritori.dialog.DialogBase;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.StageStyle;
import javafx.stage.Window;

/**
 *
 * @author ws
 */
public class MessageDialog extends DialogBase<Boolean>{

    public MessageDialog(Window owner) {
        super(owner);
        this.initStyle(StageStyle.TRANSPARENT);
        status = true;
    }

    @Override
    public MessageDialog init() {
        return init("","");
    }
    
    public MessageDialog init(String title, String message){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MessageDialogView.fxml"));
        try {
            loader.load();
            Parent root = loader.getRoot();
            
            MessageDialogController control = loader.getController();
            control.init(this, title, message);

            Scene scene = new Scene(root);
            this.setScene(scene);
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
        return this;
    }
}
