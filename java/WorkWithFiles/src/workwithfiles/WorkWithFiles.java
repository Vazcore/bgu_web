/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package workwithfiles;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;

/**
 *
 * @author USER
 */

class Apple implements Serializable{
    public String color;
}

public class WorkWithFiles {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        /*
        OutputStream out = new FileOutputStream("test.txt");
        
        for (int i = 0; i < 10; i++) {
            out.write(i);
        }
        
        out.flush();
        out.close();
        */
        
        /*
         * Serialization
         */
        
        
        Apple ap1 = new Apple();
        ap1.color = "red";
        
        ObjectOutputStream out = new ObjectOutputStream(
                new BufferedOutputStream(
                    new FileOutputStream("apple.bin")
                )
        );
                    
        out.writeObject(ap1);
                    
        out.close();
        
        // read object from file
        ObjectInputStream in = new ObjectInputStream(
                new BufferedInputStream(
                    new FileInputStream("apple.bin")
                )
        );
        
        Apple r_app1 = null;
         try {
             r_app1 = (Apple)in.readObject();
             System.out.println(r_app1.color);                    
        } catch (ClassNotFoundException e) {
            System.out.println(e);                    
        }
        
        
        
    }
}
