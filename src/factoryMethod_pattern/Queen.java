package factoryMethod_pattern;

/**
 * Class for creating Queen-Bees.
 * @author Jordan
 */
public class Queen extends Bee{
    private String _type = "queen";
    
    public Queen() {}
    
    @Override
    public String getType() { return this._type; }
}
