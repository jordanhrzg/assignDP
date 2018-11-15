package factoryMethod_pattern;

/**
 * Class for creating Bee factories.
 * @author Jordan
 */
public class BeeFactory {
    public static Bee getBee(BeeAbstractFactory factory) {
        return factory.createBee();
    }
}
