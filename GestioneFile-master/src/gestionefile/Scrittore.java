package gestionefile;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MC
 * @version 12/01/23
 */

public class Scrittore implements Runnable{

    String nomeFile;
    String username;
    String password;

    String copia;


    public Scrittore(String nomeFile, String username, String password, String copia){
        this.nomeFile = nomeFile;
        this.username = username;
        this.password = password;
        this.copia    = copia;
    }
    
    @Override
    public void run() {
        scrivi();
    }
    /**
     * Scrive un file di testo usando la classe BufferedWriter
     */
    public void scrivi(){
        BufferedWriter br=null;
        
        try {
            //1) apro il file
            br = new BufferedWriter(
                    new FileWriter(nomeFile));
            //2) scrivo nel buffer
            br.write("File in output");

            br.write
            ("<" + username + ">" 
            + ";" + 
            "<" + password + ">")
            ;

            br.write("\n\r");
            //3) svuoto il buffer e salvo nel file i dati
            br.flush();         
        } catch (IOException ex) {
            Logger.getLogger(Scrittore.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if (br!=null)
                try {
                    //4)chiudo lo stream in uscita
                    br.close();
            } catch (IOException ex) {
                Logger.getLogger(Scrittore.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            /* 
            private static void copyFile(String nomeFile, String copia) {
                try (BufferedReader reader = new BufferedReader(new FileReader(nomeFile));
                     BufferedWriter writer = new BufferedWriter(new FileWriter(copia))) {
        
                    String riga;
        
                    
                    while ((riga = reader.readLine()) != null) {
                        writer.write(riga);
                        writer.newLine(); 
                    }
        
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            */
        }
    }
}
