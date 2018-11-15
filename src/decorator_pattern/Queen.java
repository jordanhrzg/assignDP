package decorator_pattern;

public class Queen implements Bee{
    @Override
    public void getType() {
        System.out.println("Type: Queen");  
    }
}