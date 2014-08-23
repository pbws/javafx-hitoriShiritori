/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hitorishiritori.dialog.message;

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
public class MessageDialogController implements Initializable {
    @FXML
    private Label lblTitle;
    @FXML 
    private Label lblMessage;
    
    private Stage parent;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    
    @FXML
    private void onClickOK(ActionEvent event){
        parent.close();
    }
    
    public void init(Stage parent , String title, String message){
        this.parent = parent;
        lblTitle.setText(title);
        lblMessage.setText(message);
    }
}
