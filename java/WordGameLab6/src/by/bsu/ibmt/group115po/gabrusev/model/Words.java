/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsu.ibmt.group115po.gabrusev.model;

import java.util.Random;

/**
 *
 * @author Alexey
 */
public class Words {
    
    private String[] words = {"dog", "cat", "family", "name", "software",
    "game", "freedom", "java"};
    
    private Random r = new Random();
    
    private String currentWord;
    private String currMixedWord;
    
    
    private String getRandomWord()
    {
        int size = this.words.length;        
        return words[this.getRandomFromTo(0, size-1)];
    }
    
    public int getRandomFromTo(int from, int to)
    {
        int random = Math.abs((this.r.nextInt() % (to - from + 1)) + from);
        return random;
    }
    
    private String uglifyWord(String word)
    {
        StringBuilder str = new StringBuilder(word);
        int size = str.length();
        int[] skip_positions = new int[size];
        char tmp;
        for (int i = 0; i < size; i++)
        {
            if (skip_positions[i] == 1)
            {
                continue;
            }
            int pos = this.getRandomFromTo(i, size - 1);
            skip_positions[pos] = 1;
            skip_positions[i] = 1;
            tmp = str.charAt(i);
            str.setCharAt(i, str.charAt(pos));
            str.setCharAt(pos, tmp);
        }
        
        return str.toString();
    }
    
    public String getNextMixedWord()
    {
        this.currentWord = this.getRandomWord();
        this.currMixedWord = this.uglifyWord(this.currentWord);
        return this.currMixedWord;
    }
    
    public String getCurrentMixedWord()
    {
        return this.currMixedWord;
    }
    
    public boolean checkWord(String word)
    {
        return this.currentWord.equals(word);
    }
    
}
