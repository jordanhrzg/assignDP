package factoryMethod_pattern;

/**
 * Class for creating a Warrior-Bee factories.
 * @author Jordan
 */
public class WarriorFactory implements BeeAbstractFactory{
    public WarriorFactory() {}
    
    @Override
    public Bee createBee() {
        return new Warrior();
    }
}
