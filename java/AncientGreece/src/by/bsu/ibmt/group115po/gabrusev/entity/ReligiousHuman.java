
package by.bsu.ibmt.group115po.gabrusev.entity;

import by.bsu.ibmt.group115po.gabrusev.utils.Log;

/**
 * Description: Religious people can pray to God, it makes God stronger
 * @version 0.0.1
 * @author Alexey Gabrusev 
 * group: PVO15
 * date: 09.04.2016
 */
public class ReligiousHuman extends Human {
    
    protected God god;
    protected final String praying_words = "Amen";
    
    public ReligiousHuman(String name, int age, String weakness, God god)
    {
        super(name, age, weakness);
        this.god = god;
    }
    
    public void pray(int seconds)
    {
        Log.log("Religious Human " + this.getName() + " is starting to pray to God - "+this.god.getName()+" ...");
        // seconds during praying make God stronger
        this.god.acceptPray(this.praying_words, seconds);
        
    }
    
}
