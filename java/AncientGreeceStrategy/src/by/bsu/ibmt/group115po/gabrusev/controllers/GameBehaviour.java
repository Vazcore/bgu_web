/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsu.ibmt.group115po.gabrusev.controllers;

import by.bsu.ibmt.group115po.gabrusev.models.God;
import by.bsu.ibmt.group115po.gabrusev.models.GodEntity;
import by.bsu.ibmt.group115po.gabrusev.models.Human;
import by.bsu.ibmt.group115po.gabrusev.models.HumanRank;
import by.bsu.ibmt.group115po.gabrusev.models.Power;
import by.bsu.ibmt.group115po.gabrusev.models.ReligiousHumanRank;
import by.bsu.ibmt.group115po.gabrusev.models.SupremeGod;
import by.bsu.ibmt.group115po.gabrusev.models.interfaces.HumanBehavior;
import by.bsu.ibmt.group115po.gabrusev.utils.MLogger;
import by.bsu.ibmt.group115po.gabrusev.utils.Menu;
import by.bsu.ibmt.group115po.gabrusev.utils.Saver;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Aliaksei_Habruseu
 */
public class GameBehaviour {
    
    private static List<Object> objs = null;    
    private static List<Integer> relations = null;
    public static boolean game_running = false;
    
    public static List<Object> getData()
    {
        if (objs == null)
            objs = new ArrayList<Object>();
        return objs;
    }
    public static List<Integer> getRelation()
    {
        if (relations == null)
            relations = new ArrayList<Integer>();
        return relations;
    }
    
    
    public static void coreInit() throws IOException, FileNotFoundException, ClassNotFoundException
    {
        getData();
        getRelation();
        boolean playing = false;        
        int choice = -1;
        
        while(!playing && choice != 0)
        {
            // Load Menu
            choice = Menu.getChoiceFromLoadingMenu();           
            

            switch(choice)
            {
                case 1:                    
                    Saver.load(objs, relations);
                    MLogger.info("Data were loaded");
                    break;
                case 2:                
                    addGod(objs, relations);
                    break;
                case 3:
                    addHuman(objs, relations);
                    break;
                case 4:
                    Saver.removeData();
                    break;
                case 5:
                    playing();
                    playing = true;
                    break;
            }
        }
    }
    
    public static void playing() throws IOException {
        MLogger.info("Game is starting! Good Luck!");
        MLogger.info("Updating gods container - " + objs.size());
        // updating gods container
        EntityContainer.updateData(objs, relations);
        Menu.getGameMenu();        
        int choice = Integer.parseInt(Menu.inputConsole());        
        int switching = -1;
        if (choice == 1)
        {
            while(switching != 0)
            {
                Menu.printList(EntityContainer.getListNameOfGods(), -1);
                choice = Integer.parseInt(Menu.inputConsole());
                MLogger.info("Choosing god with id - " + choice);
                switching = play(choice);
            }
            Saver.save(objs, relations);
        }
        else
        {
            Saver.save(objs, relations);
        }
    }
    
    public static int play(int choice) throws IOException
    {
        int cl_id = EntityContainer.getClassId(choice);
        boolean in_play = true;
        GodEntity enemy;
        String[] rels = Saver.getRelations();
        GodEntity god;
        String ch;
        if (rels[cl_id] == "God") 
        {
            god = (God) EntityContainer.getGod(choice);
        }
        else
        {
            god = (SupremeGod) EntityContainer.getGod(choice);
        }
        god.introduce();
        EntityContainer.current_god = god;
        EntityContainer.current_god_id = choice;
        Menu.next();
        while (in_play)
        {
            Menu.getGodOption(god);
            ch = Menu.inputConsole();
            if (ch.equals("1"))
            {
                System.out.println("--- Choose God to atack ---");
                Menu.printList(EntityContainer.getListNameOfGods(), EntityContainer.current_god_id);
                ch = Menu.inputConsole();
                if( rels[EntityContainer.getClassId(Integer.parseInt(ch))] == "God" )
                {
                    enemy = (God) EntityContainer.getGod(Integer.parseInt(ch));
                }  
                else
                {
                    enemy = (SupremeGod) EntityContainer.getGod(Integer.parseInt(ch));
                }                
                god.atack(enemy);
                Menu.next();
            }
            else if (ch.equals("4")) 
            {
                System.out.println("--- Choose God to atack ---");
                Menu.printList(EntityContainer.getListNameOfGods(), EntityContainer.current_god_id);
                ch = Menu.inputConsole();
                if( rels[EntityContainer.getClassId(Integer.parseInt(ch))] == "God" )
                {
                    enemy = (God) EntityContainer.getGod(Integer.parseInt(ch));
                }  
                else
                {
                    enemy = (SupremeGod) EntityContainer.getGod(Integer.parseInt(ch));
                }                
                god.atack(enemy);
                Menu.next();
            }
            else if (ch.equals("5") && god.getClassName().indexOf(".SupremeGod") != -1) 
            {
                ((SupremeGod) god).heal();
                Menu.next();
            }
            else if (ch.equals("3"))
            {
                return 1;
            }
            else if (ch.equals("0"))
                return 0;
            humanStepsInit(2000);
        }        
        
        return 0;
    }
    
    private static void humanStepsInit(int time)
    {
        
        List<Integer> human_ids = EntityContainer.getEntityIds(EntityContainer.human_rels);
        String[] rels = Saver.getRelations();
        
        for (int i = 0; i < human_ids.size(); i++) {
            Object obj = EntityContainer.getHuman(human_ids.get(i));
            if (rels[EntityContainer.getHumanClassId(i) - 1] == "Human" || rels[EntityContainer.getHumanClassId(i) - 1] == "ReligiousHuman")
            {
                ((Human) obj).run();
            }

        }
        
    }
    
    public static boolean addHuman(List<Object> objs, List<Integer> relations) throws IOException
    {
        // todo
        // add a human
        List<Object> objects = getData();
        List<Integer> rels = getRelation();
        System.out.println(" =========  Adding a Human ==============");
        int type = Integer.parseInt(Menu.generateQandAMenu(" - Human or Religious Human: press 3 or 4"));
        if (type != 3 && type != 4)
            return false;
        String name = Menu.generateQandAMenu(" - Type a name: ");
        int age = Integer.parseInt(Menu.generateQandAMenu(" - Type age: "));
        String city = Menu.generateQandAMenu(" - Type city: ");
        float money = (float) 10.0;
        int spirit = 100;
        if (type == 3)
        {
            objects.add(new Human(name, age, city, money, spirit, new HumanRank()));
            rels.add(type-1);
        }
        else
        {
            objects.add(new Human(name, age, city, money, spirit, new ReligiousHumanRank()));
            rels.add(type-1);
        }
        System.out.println(" ========= Human was added ==============");
        
        Menu.next();
        return true;
    }
    
    public static boolean addGod(List<Object> objs, List<Integer> relations) throws IOException
    {
        List<Object> objects = getData();
        List<Integer> rels = getRelation();
        
        int type = Integer.parseInt(Menu.printAddingGodMenu("type"));
        if (type != 1 && type != 2)
            return false;
        String name = Menu.printAddingGodMenu("name");
        int age = Integer.parseInt(Menu.printAddingGodMenu("age"));
        String power_name = Menu.printAddingGodMenu("power");
        int power_points = Integer.parseInt(Menu.printAddingGodMenu("power_points"));
        Power power = new Power(power_name, power_points);        
        if (type == 1)
        {
            objects.add(new God(name, age, power, 1));
            rels.add(0);
            MLogger.info("God " + name + " was created and added");
        }
        else
        {
            objects.add(new SupremeGod(name, age, power, 1));
            rels.add(1);
            MLogger.info("Supreme God " + name + " was created and added");
        }        
        return true;
    }
    
}
