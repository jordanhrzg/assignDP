package pattern.decorator;

public class Drone implements Bee {
    @Override
    public String getType() {
        return ("Type: Drone");  
    }
}