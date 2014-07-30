/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hitorishiritori.shiritori;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author sywatanabe
 */
public class ShiritoriManager {
    public enum CheckStatus { WORD_OK, HEAD_CHAR_NG, FOOT_CHAR_NG }
    
    private final List<String> nextHeadChars = new ArrayList<String>();
    /*
    0 = 長音NG
    1 = 長音の母音
    2 = 長音ごと
    4 = 長音無視
    */
    private int tyouonFlg;
    /*
    0 = 拗音NG
    1 = 拗音の元字
    2 = 拗音ごと
    */
    private int youonFlg;
    /*
    0 = 濁音のみ
    1 = 清音可
    */
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
        nextHeadChars.clear();
        
        String lastChar = word.substring(word.length()-1, word.length());
        if(isTyouon(lastChar)){
            if((tyouonFlg & 1) != 0){
                //長音の母音を取得する
                String secChar = word.substring(word.length()-2, word.length()-1);
                //secCharで母音マスタから検索する処理
                String[] boin = {};
                nextHeadChars.addAll(Arrays.asList(boin));
            }
            if((tyouonFlg & 2) != 0){
                //長音ごと
                String secChar = word.substring(word.length()-2, word.length()-1);
                int sindex = 2;
                if(isYouon(secChar)){
                    //長音前が拗音の場合
                    sindex = 3;
                }
                String adChar = word.substring(word.length()-sindex, word.length());
                nextHeadChars.add(adChar);
                if(dakuonFlg == 1){
                    //清音可の場合
                    //sindex番目の文字の清音を取得する
                    String seion = "";
                    nextHeadChars.add(adChar.replaceFirst(adChar.substring(0, 1), seion));
                }
            }
            if((tyouonFlg & 4) != 0){
                //長音無視
                String secChar = word.substring(word.length()-2, word.length()-1);
                int sindex = 2;
                if(isYouon(secChar)){
                    //長音前が拗音の場合
                    sindex = 3;
                }
                String adChar = word.substring(word.length()-sindex, word.length()-1);
                nextHeadChars.add(adChar);
                if(dakuonFlg == 1){
                    //清音可の場合
                    //sindex番目の文字の清音を取得する
                    String seion = "";
                    nextHeadChars.add(adChar.replaceFirst(adChar.substring(0, 1), seion));
                }
            }
        }else if(isYouon(lastChar)){
            
        }else {
            
        }
    }
    
    private boolean isTyouon(String c){
        return c.equals("ー");
    }
    
    private boolean isYouon(String c){
        return "ぁぃぅぇぉゃゅょ".equals(c);
    }
}
