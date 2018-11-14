package singleton_pattern;

import builder_pattern.Beehive;
import java.util.Vector;


public class Apiary {
    
    private Vector<Beehive> _hives; 
    
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
    
    //add hive
    protected void addHive(Beehive b) {
        _hives.add(b);
    }
    //add hives
    protected void addHives(Vector<Beehive> hives) {
        _hives.addAll(hives);
    }
    
    //get hives
    protected Vector<Beehive> getHives(){ return _hives; }

}
