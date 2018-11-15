package decorator_pattern;

public class BeeDecorator implements Bee{
    protected Bee decoratedBee;
    
    public BeeDecorator(Bee decoratedBee) {
        this.decoratedBee = decoratedBee;
    }
    
    public void getType() {
        decoratedBee.getType();
    }
}