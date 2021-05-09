package tpsit.parcheggiowaitnotify;


public class Main {
    public static void main(String[] args) {
        
        Parcheggio p = new Parcheggio();
        
        Auto a1 = new Auto("Motoscafo", p);
        Auto a2 = new Auto("Quadrocicletta", p);
        Auto a3 = new Auto("Lambo", p);
        Auto a4 = new Auto("Buga", p);
        Auto a5 = new Auto("Ferrari", p);
        
        a1.start();
        a2.start();
        a3.start();
        a4.start();
        a5.start();
        
        try{
            a1.join();
            a2.join();
            a3.join();
            a4.join();
            a5.join();
        }catch(Exception e){}
        
        System.out.println("\nAuto rimanenti: " + Parcheggio.numPosti);
        
    }
}
