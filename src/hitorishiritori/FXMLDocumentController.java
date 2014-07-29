/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hitorishiritori;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
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
    private List<String> nextHeadWords;

    @FXML
    private void onClickReset(ActionEvent event) {
        lblWord.setText("ひとりしりとり");
        txtfInputWord.clear();
        txtfInputWord.setDisable(false);
        logger.info("リセット");
    }

    @FXML
    private void keyEventInputWord(KeyEvent event) {
        //エンターキーを押したら確定
        if (event.getCode() == KeyCode.ENTER) {
            String word = txtfInputWord.getText();
            boolean checkFlg = false;

            //しりとりチェック
            for (String hw : nextHeadWords) {
                if (word.substring(0, hw.length()).equals(hw)) {
                    checkFlg = true;
                    break;
                }
            }

            if (!checkFlg) {
                logger.info("Not Shiritori");
            }else {
                logger.info("OK Shiritori");
            }
            
            //最後が「ん」だったらゲームオーバー
            if (word.substring(word.length() - 1, word.length()).equals("ん")) {
                lblWord.setText("Game Over");
                txtfInputWord.setDisable(true);
            } else {
                lblWord.setText(word);
                txtfInputWord.clear();
                
                nextHeadWords.clear();
                if (word.substring(word.length() - 1, word.length()).equals("ー")) {
                    nextHeadWords.add(word.substring(word.length() - 2, word.length()));
                    nextHeadWords.add(word.substring(word.length() -2 , word.length()-1));
                    //母音
                } else {
                    nextHeadWords.add(word.substring(word.length()-1, word.length()));
                }
                String m = "";
                for (String tmp : nextHeadWords) m += tmp +",";
                logger.debug(m);
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        nextHeadWords = new ArrayList<>();
        nextHeadWords.add("り");

    }

}
