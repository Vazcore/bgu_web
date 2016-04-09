
package by.bsu.ibmt.group115po.gabrusev;

import by.bsu.ibmt.group115po.gabrusev.entity.Power;
import by.bsu.ibmt.group115po.gabrusev.entity.God;
import by.bsu.ibmt.group115po.gabrusev.entity.Human;
import by.bsu.ibmt.group115po.gabrusev.entity.ReligiousHuman;
import by.bsu.ibmt.group115po.gabrusev.entity.SupremeGod;

/**
 * Description: Starting point of application
 * @version 0.0.1
 * @author Alexey Gabrusev 
 * group: PVO15
 * date: 09.04.2016
 */
public class AncientGreece {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        // First create God
        // God needs power        
        Power love = new Power("Love", 25);
        
        // than we can create a God
        God cupid = new God("Cupid", love);        
        
        Power lightning = new Power("Lightning", 100);        
        // Lets create a Supreme God (Hight rank God)
        SupremeGod zeus = new SupremeGod("Zeus", lightning);
        
        // Gods need religious people
        Human eva = new Human("Eva", 25, "money");
        ReligiousHuman adam = new ReligiousHuman("Adam", 25, "fame", cupid);
                
        // praying during 200 seconds
        adam.pray(200);
        
        // Zeus is atacking Cupid
        zeus.atack(cupid);
        
        // Zeus is trying to take immortality from Cupid
        zeus.absorbGod(cupid);
        
        // Atacking again
        zeus.atack(cupid);
        zeus.atack(cupid);
        
        zeus.absorbGod(cupid);
        
        cupid.atack(zeus);
        adam.pray(300);
        
        zeus.recruit(eva, "beauty");
        
        if(zeus.recruit(eva, "money"))
        {
            ReligiousHuman reborn_eva = eva.getReligiousPartOfHuman();
            reborn_eva.pray(150);
        }
    }
    
}
