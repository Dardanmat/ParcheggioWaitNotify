package tpsit.parcheggiowaitnotify;
import java.util.concurrent.Semaphore;


public class Parcheggio {
    
    protected static int numPosti = 10;
    protected static boolean occupatoIngresso = false;
    protected static boolean occupatoUscita = false;

    public Parcheggio() {}
    
    public synchronized void entra(){
        while (occupatoIngresso) { 
            try{
                wait();
            }catch(Exception e){}

        }
        Parcheggio.occupatoIngresso = true;
        notify();
        decrementaPosti();
        occupatoIngresso = false;
    }
    
    public synchronized void esci(){
        while (occupatoUscita) { 
            try{
                wait();
            }catch(Exception e){}

        }
        Parcheggio.occupatoUscita = true;
        notify();
        aumentaPosti();
        occupatoUscita = false;
    }
    
    public static synchronized void decrementaPosti(){
        numPosti--;
    }
    
    public static synchronized void aumentaPosti(){
        numPosti++;
    }
    
}
