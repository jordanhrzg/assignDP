package pattern.abstractfactory;

/**
 * Class for creating a Drone-Bee factories.
 * @author Jordan
 */
public class DroneFactory implements BeeAbstractFactory {
    public DroneFactory() {}
    
    @Override
    public Bee createBee() {
        return new Drone();
    }
}