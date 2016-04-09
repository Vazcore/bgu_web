
package by.bsu.ibmt.group115po.gabrusev.entity;

import by.bsu.ibmt.group115po.gabrusev.utils.Log;

/**
 * Description: Class God
 * @version 0.0.1
 * @author Alexey Gabrusev 
 * group: PVO15
 * date: 09.04.2016
 */
public class God {
    
    protected final String name;
    protected final Power power;
    protected int points = 0; 
    protected boolean immortal = true;
    protected final int weakness = 111;
    protected final String praying_words = "Amen";
    protected final int power_access_hash = 222;
    
    public God(String name, Power power)
    {
        this.power = power;
        this.name = name;
        
        Log.log("God " + this.getName() + " was created");
    }
    
    public String getName()
    {
        return this.name;
    }
    
    public int getPoints()
    {
        return this.points;
    }
    
    public Power getPower()
    {
        return this.power;
    }
    
    public boolean takeImmortality(int power_code)
    {
        // Only Abyss knows about god weakness
        // so God can't resist when abyss is taking 
        // his immortaliy
        if (this.weakness == power_code)
        {
            this.immortal = false;
        }
        
        return (this.weakness == power_code);
    }
    
    public void acceptPray(String praying_words, int seconds)
    {
        if (!this.immortal)
        {
            Log.log(this.name + " is mortal now! He can't accept pray");
            return;
        }
        if (this.praying_words.equals(praying_words))
        {
            this.points += seconds;
            Log.log("During praying God - " + this.name + " became stronger by " + seconds + " points");
        }
        else
        {
            Log.log("God - " + this.name + " doesnt know such pray");
        }
        
    }
    
    public int atack(God god)
    {
        if (!this.immortal)
        {
            Log.log(this.name + " is mortal now! He can't attack");
            return 0;
        }
        Log.log("God " + this.name + " attacks god - " + god.getName());
        return this.power.hit(god, this.points);
    }
    
    public boolean takeDamage(int power_access_hash, int points)
    {
        if (power_access_hash == this.power_access_hash)
        {
            this.points -= points;
            if (this.points < 0)
            {
                this.points = 0;
            }
            Log.log("God "+this.name+" took damage with - " + points);
            return true;
        }
        return false;
    }
    
    public boolean recruit(Human human, String weakness)
    {
        Log.log("God " + this.name + " is trying to recruit human - " + human.getName());
        return human.startRecruitment(this, weakness);
    }
    
}
