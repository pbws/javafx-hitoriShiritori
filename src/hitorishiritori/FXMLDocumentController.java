/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hitorishiritori;

import hitorishiritori.database.dao.ResultShiritoriDAO;
import hitorishiritori.shiritori.ShiritoriManager;
import hitorishiritori.shiritori.ShiritoriManager.CheckStatus;
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
    private final ShiritoriManager mng = new ShiritoriManager();

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
            CheckStatus sts =  mng.checkShiritori(word);
            switch(sts){
                case HEAD_CHAR_NG:
                    logger.debug("頭文字NG");
                    lblWord.setText("Game Over");
                    txtfInputWord.setDisable(true);
                    ResultShiritoriDAO.deleteAll();
                    break;
                case WORD_NG:
                    logger.debug("重複NG");
                    lblWord.setText("Game Over");
                    txtfInputWord.setDisable(true);
                    ResultShiritoriDAO.deleteAll();
                    break;
                case FOOT_CHAR_NG:
                    logger.debug("んNG");
                    lblWord.setText("Game Over");
                    txtfInputWord.setDisable(true);
                    ResultShiritoriDAO.deleteAll();
                    break;
                case WORD_OK:
                    logger.debug("OK");
                    lblWord.setText(word);
                    txtfInputWord.clear();
                    break;
                default:
                    
            }
//            boolean checkFlg = false;
//
//            //しりとりチェック
//            for (String hw : nextHeadWords) {
//                if (word.substring(0, hw.length()).equals(hw)) {
//                    checkFlg = true;
//                    break;
//                }
//            }
//
//            if (!checkFlg) {
//                logger.info("Not Shiritori");
//            }else {
//                logger.info("OK Shiritori");
//            }
//            
//            //最後が「ん」だったらゲームオーバー
//            if (word.substring(word.length() - 1, word.length()).equals("ん")) {
//                lblWord.setText("Game Over");
//                txtfInputWord.setDisable(true);
//            } else {
//                lblWord.setText(word);
//                txtfInputWord.clear();
//                
//                nextHeadWords.clear();
//                if (word.substring(word.length() - 1, word.length()).equals("ー")) {
//                    nextHeadWords.add(word.substring(word.length() - 2, word.length()));
//                    nextHeadWords.add(word.substring(word.length() -2 , word.length()-1));
//                    //母音
//                } else {
//                    nextHeadWords.add(word.substring(word.length()-1, word.length()));
//                }
//                String m = "";
//                for (String tmp : nextHeadWords) m += tmp +",";
//                logger.debug(m);
//            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

}
