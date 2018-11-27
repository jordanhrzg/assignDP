package pattern.decorator;

public class StrongBeeDecorator extends BeeDecorator {
    
    public StrongBeeDecorator(Bee decoratedBee) {
        super(decoratedBee);
    }
    
    @Override
    public String getType() {
        return decoratedBee.getType() + setSpeedyAttribute(decoratedBee); 
    }
    
    private String setSpeedyAttribute(Bee decoratedBee) {
        return ("\nAttribute: Strong");
    }

}