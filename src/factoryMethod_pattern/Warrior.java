package factoryMethod_pattern;

/**
 * Class for creating Warrior-Bees.
 * @author Jordan
 */
public class Warrior extends Bee{
    private String _type = "warrior";
    
    public Warrior() {}
    
    @Override
    public String getType() { return this._type; }
}
