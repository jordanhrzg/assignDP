package decorator_pattern;

public class Drone implements Bee{
    @Override
    public void getType() {
        System.out.println("Type: Drone");  
    }
}
