package decorator_pattern;

public class StrongBeeDecorator extends BeeDecorator{
    
    public StrongBeeDecorator(Bee decoratedBee) {
        super(decoratedBee);
    }
    
    @Override
    public void getType() {
        decoratedBee.getType();
        setSpeedyAttribute(decoratedBee); 
    }
    
    private void setSpeedyAttribute(Bee decoratedBee) {
        System.out.println("Attribute: Strong");
    }

}
