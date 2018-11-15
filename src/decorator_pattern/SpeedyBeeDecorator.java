package decorator_pattern;

public class SpeedyBeeDecorator extends BeeDecorator{
    
    public SpeedyBeeDecorator(Bee decoratedBee) {
        super(decoratedBee);
    }
    
    @Override
    public void getType() {
        decoratedBee.getType();
        setSpeedyAttribute(decoratedBee); 
    }
    
    private void setSpeedyAttribute(Bee decoratedBee) {
        System.out.println("Attribute: Speedy");
    }
}
