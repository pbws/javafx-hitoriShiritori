/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hitorishiritori.dialog.confirm;

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
public class ConfirmDialog extends DialogBase<ConfirmDialog.ConfirmStatus>{
    public enum ConfirmStatus {YES,NO,CANCEL}
    public enum ConfirmMode {YES_NO, YES_NO_CANCEL};
    
    public ConfirmDialog(Window owner) {
        super(owner);
        status = ConfirmStatus.YES;
    }

    @Override
    public DialogBase init() {
        return init(ConfirmMode.YES_NO,"","");
    }
    
    public DialogBase init(ConfirmMode mode, String title, String message){
        String fxml = (mode==ConfirmMode.YES_NO_CANCEL) ? "ConfirmDialogYesNoCancelView.fxml":"ConfirmDialogYesNoView.fxml";
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
        try {
            loader.load();
            Parent root = loader.getRoot();
            
            ConfirmDialogController control = loader.getController();
            control.init(this, title, message);

            Scene scene = new Scene(root);
            this.setScene(scene);
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
        return this;
    }
    
}
