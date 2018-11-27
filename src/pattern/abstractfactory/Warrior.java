package pattern.abstractfactory;

/**
 * Class for creating Warrior-Bees.
 * @author Jordan
 */
public class Warrior extends Bee {
    private String type = "warrior";
    
    public Warrior() {}
    
    @Override
    public String getType() { 
        return this.type; 
    }
}