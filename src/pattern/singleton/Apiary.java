package pattern.singleton;

import java.util.Vector;

import pattern.builder.Beehive;

/**
 * Singleton class that creates an apiary containing beehives.
 * Requirements met:
 * - an apiary can have many beehives in them. Only ever allow one apiary to exist.
 */
public class Apiary {   
    public Vector<Beehive> hives; 
    
    //make it a singleton
    private static Apiary instance = null;
    
    //private constructor
    private Apiary() { 
        hives = new Vector<Beehive>();
    }
    
    //get instance
    /**
     * A method to return the instance of this class.
     * @return Apiary instance
     */
    public static Apiary getInstance() {
        if (instance == null) {
            instance = new Apiary();
        }
        return instance;
    }
}