/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hitorishiritori.shiritori;

import hitorishiritori.database.dao.ResultShiritoriDAO;
import java.util.ArrayList;

/**
 *
 * @author bi_pbws
 */
public class ScoreManager {
    private long score;

    public ScoreManager() {
    }
    
    public void initScore(int mode){
        score = 0L;
        ArrayList<String> result = ResultShiritoriDAO.selectTop(0, mode);
        for(String w : result){
            addScore(w);
        }
    }

    public void addScore(String word){
        score += word.length()*10;
    }
    
    public void resetScore(){
        score = 0L;
    }
    
    public long getScore() {
        return score;
    }
}
