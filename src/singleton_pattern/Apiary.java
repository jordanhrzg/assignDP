package singleton_pattern;

import builder_pattern.Beehive;
import java.util.Vector;

/**
 * Singleton class that creates an apiary containing beehives.
 * 
 * Requirements met:
 * - an apiary can have many beehives in them. Only ever allow one apiary to exist.
 */
public class Apiary {   
    public Vector<Beehive> _hives; 
    
    //make it a singleton
    private static Apiary instance = null;
    
    //private constructor
    private Apiary() { 
        _hives = new Vector<Beehive>();
    }
    
    //get instance
    public static Apiary getInstance() {
        if(instance == null) {
            instance = new Apiary();
        }
        return instance;
    }
}