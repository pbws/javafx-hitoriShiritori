/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hitorishiritori.dialog;

import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;

/**
 *
 * @author ws
 * @param <T>
 */
abstract public class  DialogBase<T> extends Stage{
    protected T status;
    
    abstract public DialogBase init();

    public DialogBase(Window owner) {
        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.WINDOW_MODAL);
        this.initOwner(owner);
    }
    
    public T showDialog(){
        this.showAndWait();
        return this.status;
    }
    
    public T getStatus(){
        return this.status;
    }
    
    public void setStatus(T param){
        this.status = param;
    }
}
