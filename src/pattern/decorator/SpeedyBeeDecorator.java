package pattern.decorator;

public class SpeedyBeeDecorator extends BeeDecorator {
    
    public SpeedyBeeDecorator(Bee decoratedBee) {
        super(decoratedBee);
    }
    
    @Override
    public String getType() {
        return (decoratedBee.getType() + setSpeedyAttribute(decoratedBee)); 
    }
    
    private String setSpeedyAttribute(Bee decoratedBee) {
        return ("\nAttribute: Speedy");
    }
}