
package by.bsu.ibmt.group115po.gabrusev.entity;

import by.bsu.ibmt.group115po.gabrusev.utils.Log;

/**
 * Description: Class Power defines God
 * @version 0.0.1
 * @author Alexey Gabrusev 
 * group: PVO15
 * date: 09.04.2016
 */
public class Power {
    
    private final String type;
    private final int points;
    // this option helps to access God and hits him
    private final int power_access_hash = 222;
    
    public Power (String type, int points)
    {
        this.points = points;
        this.type = type;
        
        Log.log("Power - " + type + " was created with power points - " + points);
    }
    
    public int getPoints()
    {
        return this.points;
    }
    
    public String getType()
    {
        return this.type;
    }
    
    public int hit(God god, int extra_boost)
    {
        if(god.takeDamage(this.power_access_hash, this.points + extra_boost))
        {
            return this.points;
        }
        else
        {
            return 0;
        }
    }
    
}
