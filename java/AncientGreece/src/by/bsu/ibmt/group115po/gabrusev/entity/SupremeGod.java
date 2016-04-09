
package by.bsu.ibmt.group115po.gabrusev.entity;

import by.bsu.ibmt.group115po.gabrusev.logic.Abyss;
import by.bsu.ibmt.group115po.gabrusev.utils.Log;

/**
 * Description: Class SupremeGod - High ranked God. 
 * Specialty  - ability to make a mortal normal God 
 * and get their points
 * @version 0.0.1
 * @author Alexey Gabrusev 
 * group: PVO15
 * date: 09.04.2016
 */
public class SupremeGod extends God{
    
    private int absorbtion_level = 0;
    
    public SupremeGod(String name, Power power)
    {
        super(name, power);
    }
    
    public boolean absorbGod(God god)
    {
        Log.log("Supreme God - " + this.name + " is trying to take immortality from God - " + god.getName());
        int extra_points = Abyss.absorbPower(this, god);
        if (extra_points != 0)
        {
            this.points += extra_points;
            this.absorbtion_level++;
        }
        
        return (extra_points > 0);
    }
    
}
