package decorator_pattern;

public class Warrior implements Bee{
    @Override
    public void getType() {
        System.out.println("Type: Warrior");  
    }
}