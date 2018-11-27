package pattern.decorator;

public class BeeDecorator implements Bee {
    protected Bee decoratedBee;
    
    public BeeDecorator(Bee decoratedBee) {
        this.decoratedBee = decoratedBee;
    }
    
    public String getType() {
        return decoratedBee.getType();
    }
}