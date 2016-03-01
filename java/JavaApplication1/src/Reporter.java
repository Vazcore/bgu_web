/**
 * Description: The program prints out an aphorism
 * @version 0.0.1
 * @author Alexey Gabrusev 
 * group: PVO15
 * date: 21.02.2016
 */

class AphorismGuru{
    private String aphorizm = "Who are careful in their promises, the more accurate in their performance."; 
    private String author = "Vk.com";
    public void printAphorizm(){
        System.out.println(this.aphorizm + "\n(c)" +this.author);
    }
}

/**
 *
 *  Main class of the program
 */
public class Reporter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       // creation AphorismGuru object
       AphorismGuru guru = new AphorismGuru();
       // calling printing method
       guru.printAphorizm();
    }
    
}
