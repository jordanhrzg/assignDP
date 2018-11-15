package factoryMethod_pattern;

/**
 * Class for creating a Queen-Bee factories.
 * @author Jordan
 */
public class QueenFactory implements BeeAbstractFactory{
    public QueenFactory() {}
    
    @Override
    public Bee createBee() {
        return new Queen();
    }
}
