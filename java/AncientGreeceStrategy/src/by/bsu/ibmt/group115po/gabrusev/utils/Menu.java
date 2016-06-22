/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsu.ibmt.group115po.gabrusev.utils;

import by.bsu.ibmt.group115po.gabrusev.models.GodEntity;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import org.apache.log4j.Logger;

/**
 *
 * @author Aliaksei_Habruseu
 */
public class Menu {
    
    public static int getChoiceFromLoadingMenu() throws IOException, FileNotFoundException, ClassNotFoundException 
    {
        printInitMenu();
        boolean choosen = false;
        int choice = 0;
        while (!choosen)
        {
            try {
                choice = Integer.parseInt(inputConsole());
                choosen = true;
            } catch(Exception e) {
                MLogger.fatal("Incorrect choice");
            }
        }
        
        return choice;
    }
    
    public static void printInitMenu()
    {
        boolean isData = checkData();        
        System.out.println("============ Menu ================");
        if (isData)
        {
            System.out.println("1. Load previous data");
        }
        System.out.println("2. Add a god");
        System.out.println("3. Add a human");
        System.out.println("4. Remove data");
        System.out.println("5. Start to play");
        System.out.println("0. Exit");
        System.out.println("============================");
        System.out.println("Your choice: ");
    }
    
    public static void getGameMenu() 
    {
        System.out.println("1. Choose a god");
        System.out.println("0. Save data to disk and exit");
        System.out.println("============================");
        System.out.println("Your choice: ");
    }
    
    public static void printList(String[] list, int except_id)
    {
        System.out.println("======= List ============");
        for (int i = 0; i < list.length; i++) {
            if (i != except_id)
                System.out.println(i + ". " + list[i]);
        }
        System.out.println("============================");
        System.out.println("Your choice: ");
    }
    
    public static boolean checkData() {
        File f = new File("data.bin");
        return (f.exists() && !f.isDirectory());        
    }
    
    public static String inputConsole() throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        return s;
    }
    
    public static void next() throws IOException 
    {
        System.out.println("Press Enter to continue!!!");
        inputConsole();
    }
    
    public static void getGodOption(GodEntity god) 
    {        
        System.out.println("========= God Options ==========");
        System.out.println("1. Atack God");
        System.out.println("2. Recruit human");
        System.out.println("3. Change God");
        System.out.println("4. Take immortality");
        if (god.getClassName().indexOf(".SupremeGod") != -1)
        {
            System.out.println("5. Heal yourself");
        }
        System.out.println("0. Exit");
        System.out.println("============================");
        System.out.println("Your choice: ");
    }
    
    public static String printAddingGodMenu(String prop) throws IOException
    {
        System.out.println("======== Add a God ==========");
        if (prop == "type")
        {
            System.out.println("1. God or Supreme God ? Enter 1 or 2 : ");
            return inputConsole();
        }
        else if (prop == "name")
        {
            System.out.println("1. Type a name: ");
            return inputConsole();
        }
        else if (prop == "age")
        {
            System.out.println("2. Type an age: ");
            return inputConsole();
        }
        else if (prop == "power")
        {
            System.out.println("3. What power does God have? : ");
            return inputConsole();
        }
        else if (prop == "power_points")
        {
            System.out.println("4. What base points for power? : ");
            return inputConsole();
        }
        else
        {
            return "0";
        }
        
    }
}
