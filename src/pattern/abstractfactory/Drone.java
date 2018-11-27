package pattern.abstractfactory;

/**
 * Class for creating Drone-Bees.
 * @author Jordan
 */
public class Drone extends Bee {
    private String type = "drone";
    
    public Drone() {}
    
    @Override
    public String getType() { 
        return this.type;  
    }
}