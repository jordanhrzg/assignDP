package factoryMethod_pattern;

/**
 * Class for creating Drone-Bees.
 * @author Jordan
 */
public class Drone extends Bee{
    private String _type = "drone";
    
    public Drone() {}
    
    @Override
    public String getType() { return this._type; }
}
