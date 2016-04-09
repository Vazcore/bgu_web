
package by.bsu.ibmt.group115po.gabrusev.logic;

import by.bsu.ibmt.group115po.gabrusev.entity.God;
import by.bsu.ibmt.group115po.gabrusev.entity.SupremeGod;
import by.bsu.ibmt.group115po.gabrusev.entity.Power;
import by.bsu.ibmt.group115po.gabrusev.utils.Log;

/**
 * Description: Ancient Abyss - creature that can take immortality from normal God
 * Supreme Gods can summon Abyss
 * @version 0.0.1
 * @author Alexey Gabrusev 
 * group: PVO15
 * date: 09.04.2016
 */
public class Abyss {
    
    private static int ancient_power = 111;
    
    // check if there is no power left in God to get access
    // to immortality    
    public static boolean accessToImmortality(God god)
    {
        int points = god.getPoints();
        return (points <= 0);
    }
    
    // abyss can absorb power for supreme god
    public static int absorbPower(SupremeGod supreme_god, God god)
    {
        int points = 0;
        if (accessToImmortality(god))
        {
            Power power = god.getPower();
            points = power.getPoints();
            god.takeImmortality(ancient_power);
            Log.log("Abyss took immortality from God - " + god.getName());
        }
        else
        {
            Log.log("Abyss rejects to take immortality from God " + god.getName());
        }
        return points;
    }
    
}
