package tpsit.parcheggiowaitnotify;

import java.util.Random;
import static tpsit.parcheggiowaitnotify.Parcheggio.numPosti;


public class Auto extends Thread{

    private Parcheggio p;
    
    public Auto(String name, Parcheggio p) {
        super(name);
        this.p = p;
    }

    @Override
    public void run() {
        
        try{
            
            System.out.println("Macchina " + getName() + " prova ad entrare (" + Parcheggio.numPosti +")");
            
            synchronized(p){
                p.entra();
                System.out.println("Macchina " + getName() + " entrata nel parcheggio (" + Parcheggio.numPosti +")");
            }
            
            //la macchina sosta per un tempo random
            this.sleep(new Random().nextInt(10));
            
            System.out.println("Macchina " + getName() + " prova ad uscire (" + Parcheggio.numPosti +")");
            
            synchronized(p){
                p.esci();
                System.out.println("Macchina " + getName() + " esce dal parcheggio (" + Parcheggio.numPosti +")");
            }
                
        }catch(InterruptedException e){}
        
    }
    
}
