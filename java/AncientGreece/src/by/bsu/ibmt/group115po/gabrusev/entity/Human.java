
package by.bsu.ibmt.group115po.gabrusev.entity;

import by.bsu.ibmt.group115po.gabrusev.utils.Log;

/**
 * Description: Base Class for humans
 * @version 0.0.1
 * @author Alexey Gabrusev 
 * group: PVO15
 * date: 09.04.2016
 */
public class Human {
    
    protected String name;
    protected int age;
    protected String weakness;
    protected ReligiousHuman religious = null;
    
    public Human(String name, int age, String weakness)
    {
        this.name = name;
        this.age = age;
        this.weakness = weakness;
        
        Log.log("Human " + this.getName() + " was created");
    }
    
    public String getName()
    {
        return this.name;
    }
    
    public int getAge()
    {
        return this.age;
    }
    
    public boolean startRecruitment(God god, String weakness)
    {
        if (this.weakness.equals(weakness))
        {
            // that man now is religious
           this.religious = new ReligiousHuman(this.name, this.age, this.weakness, god);
           Log.log("Human " + this.name + " is now a religious person. His/her God is - " + god.getName());
           return true;
        }
        Log.log("Human " + this.name + " resists to God - " + god.getName());
        return false;
    }
    
    public ReligiousHuman getReligiousPartOfHuman()
    {
        return this.religious;
    }
    
}
