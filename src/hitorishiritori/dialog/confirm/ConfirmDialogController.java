/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hitorishiritori.dialog.confirm;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ws
 */
public class ConfirmDialogController implements Initializable {
    
    @FXML private Label lblTitle;
    @FXML private Label lblMessage;
    
    private ConfirmDialog parent;
    
    @FXML
    private void onClickYes(ActionEvent event){
        parent.setStatus(ConfirmDialog.ConfirmStatus.YES);
        parent.close();
    }
    
    @FXML
    private void onClickNo(ActionEvent event){
        parent.setStatus(ConfirmDialog.ConfirmStatus.NO);
        parent.close();
    }
    
    @FXML
    private void onClickCancel(ActionEvent event){
        parent.setStatus(ConfirmDialog.ConfirmStatus.CANCEL);
        parent.close();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void init(ConfirmDialog parent, String title, String message){
        this.parent = parent;
        lblTitle.setText(title);
        lblMessage.setText(message);
    }
}
