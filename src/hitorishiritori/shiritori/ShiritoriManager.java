/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hitorishiritori.shiritori;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sywatanabe
 */
public class ShiritoriManager {
    public enum CheckStatus { WORD_OK, HEAD_CHAR_NG, FOOT_CHAR_NG }
    
    private final List<String> nextHeadChars = new ArrayList<String>();
    private int tyouonFlg;
    private int youonFlg;
    private int dakuonFlg;

    public ShiritoriManager() {
        tyouonFlg = 1;
        youonFlg = 1;
        dakuonFlg = 1;
    }
    
    public CheckStatus checkShiritori(String word) {
        for (String hc : nextHeadChars) {
            if (word.substring(0, hc.length()).equals(hc)) {
                return CheckStatus.HEAD_CHAR_NG;
            }
        }
        if (word.substring(word.length() - 1, word.length()).equals("ん")) {
            return CheckStatus.FOOT_CHAR_NG;
        }
        this.setNextHeadChars(word);

        return CheckStatus.WORD_OK;
    }
    
    private void setNextHeadChars(String word){
        switch (word.substring(word.length() - 1, word.length())) {
            case "ー":
                if((tyouonFlg & 1) != 0){
                    //母音を取得
                }
                if((tyouonFlg & 2) != 0){
                    //拗音チェック
                    
                }
                break;
            case "ゃ":
            case "ゅ":
            case "ょ":
            case "ぁ":
            case "ぃ":
            case "ぅ":
            case "ぇ":
            case "ぉ":
                break;
            default:
                
        }
    }
}
