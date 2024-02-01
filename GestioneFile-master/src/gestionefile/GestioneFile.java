package gestionefile;

/**
 *
 * @author MC
 * @version 12/01/23
 */

 import java.util.Scanner;
public class GestioneFile {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //String output = "output.csv";
        //String copia = "copia.csv";

        //1)LETTURA
        Lettore lettore = new Lettore("user.json");
        lettore.start();
        //2)ELABORAZIONE
        Scanner sc = new Scanner(System.in);

        String username;
        String password;

        System.out.println("Inserisci username: ");
        username = sc.nextLine();

        System.out.println("Inserisci password: ");
        password = sc.nextLine();

        System.out.println(username);
        System.out.println(password);

        //3) SCRITTURA
        Scrittore scrittore = new Scrittore("output.csv", username, password, "copia.csv");

        Thread threadScrittore = new Thread(scrittore);
        threadScrittore.start();
    }
    
}
