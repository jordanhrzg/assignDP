package pattern.abstractfactory;

/**
 * Class for creating Queen-Bees.
 * @author Jordan
 */
public class Queen extends Bee {
    private String type = "queen";
    
    public Queen() {}
    
    @Override
    public String getType() { 
        return this.type; 
    }
}