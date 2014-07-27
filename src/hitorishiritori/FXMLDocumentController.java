/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hitorishiritori;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author ws
 */
public class FXMLDocumentController implements Initializable {
  
  @FXML
  private Label lblWord;
  @FXML
  private TextField txtfInputWord;
  
  private Logger logger = LogManager.getLogger();
  
  @FXML
  private void onClickReset(ActionEvent event) {
    
  }
  
  @FXML
  private void keyEventInputWord(KeyEvent event){
    if(event.getCode() ==  KeyCode.ENTER){
      logger.debug("確定");
    }
  }
  
  @Override
  public void initialize(URL url, ResourceBundle rb) {
    // TODO
  }  
  
}
