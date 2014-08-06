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
    private final ShiritoriManager mng;

    public FXMLDocumentController() {
        mng = new ShiritoriManager();
    }

    
    
    @FXML
    private void onClickReset(ActionEvent event) {
        mng.initNewShiritori("ひとりしりとり");
        settingWordLabel("ひとりしりとり");
        txtfInputWord.clear();
        txtfInputWord.setDisable(false);
        logger.info("リセット");
    }

    @FXML
    private void keyEventInputWord(KeyEvent event) {
        //エンターキーを押したら確定
        if (event.getCode() == KeyCode.ENTER) {
            //空文字だったら無視する
            if(txtfInputWord.getText().isEmpty()){
                return;
            }
            
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
                    settingWordLabel(word);
                    txtfInputWord.clear();
                    break;
                default:       
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if(mng.isContinued()){
            settingWordLabel(mng.initContinueShiritori());
        }else {
            mng.initNewShiritori("ひとりしりとり");
            settingWordLabel("ひとりしりとり");
        }
    }

    private void settingWordLabel(String word){
        StringBuilder sb = new StringBuilder();
        sb.setLength(0);
        sb.append(word).append("[");
        
        mng.getNextHeadChars().forEach( c -> {
            sb.append(c).append(",");
        });
        //余分なカンマを消す
        sb.deleteCharAt(sb.length()-1);
        sb.append("]");
        lblWord.setText(sb.toString());
    }
}
