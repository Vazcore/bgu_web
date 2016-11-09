/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bgu;

/**
 *
 * @author Aliaksei_Habruseu
 */
public class WordTranslation {
    public int id;
    public String word;
    public String trans;

    public WordTranslation(int id, String word, String trans) {
        this.id = id;
        this.word = word;
        this.trans = trans;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getTrans() {
        return trans;
    }

    public void setTrans(String trans) {
        this.trans = trans;
    }

    
}
